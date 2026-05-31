# Computer Hardware Management System

A Console-Based Java Application for anaging a computer hardware store. It supports full inventory management of PC components, lets you build computers from those parts, and handles user accounts with buy/sell transactions - all with persistent file-based storage.

---

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Classes Overview](#classes-overview)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Compilation](#compilation)
  - [Running](#running)
- [Usage Guide](#usage-guide)
- [Data Persistence](#data-persistence)
- [Known Limitations](#known-limitations)

---

## Features

- **Hardware Inventory Management** - Add, edit, delete, and view six types of PC components:
  - CPU, GPU, RAM, Storage, PSU, Motherboard
- **PC Builder** - Assemble a computer by selecting one of each component from inventory; parts are removed from stock upon use
- **User Management** - Create and manage user profiles
- **Buy & Sell System** - Sell built computers to users, and buy them back into inventory
- **Persistent Storage** - All data is saved to plain-text `.txt` files and reloaded on the next launch
- **Edit-in-Place** - Press Enter to keep any existing field value when editing a record

---

## Project Structure

```
project/
│
├── Main.java               # Entry point; menu system and top-level operations
│
├── Hardware.java (abstract)
│   ├── CPU.java
│   ├── GPU.java
│   ├── RAM.java
│   ├── Storage.java
│   ├── PSU.java
│   └── MotherBoard.java
│
├── Computer.java           # Aggregates one of each component into a full PC
├── Inventory.java          # Manages all component and computer lists; core logic
├── User.java               # User profile; optionally owns one Computer
├── FileManager.java        # Handles all save/load operations
│
├── cpus.txt
├── gpus.txt
├── rams.txt
├── storage.txt
├── psus.txt
├── mbs.txt
├── users.txt
└── builtComputers.txt
```

> All source classes are written in a single file (`Main.java`) for simplicity.

---

## Classes Overview

### `Hardware` *(abstract)*
Base class for all components. Holds common fields: `id`, `brand`, `modelName`, `price`, and declares the abstract `display()` method.

### Component Classes
| Class | Key Fields |
|---|---|
| `CPU` | cores, threads, clockSpeed (GHz), cache (MB), TDP (W), socket |
| `GPU` | VRAM (GB), cores, clock speed (MHz), TDP (W) |
| `RAM` | capacity (GB), speed (MHz), latency (CL) |
| `Storage` | type (SSD/HDD/NVMe), capacity (GB) |
| `PSU` | wattage (W), efficiency tier (80+), modular (yes/no) |
| `MotherBoard` | socket type, RAM slots |

Each class has a static `nextId` counter for auto-incrementing IDs.

### `Computer`
Holds one instance of each component class. Has its own auto-incrementing `id` and a `displaySpecs()` method for a summary view.

### `Inventory`
Central management class containing `ArrayList`s for every component type and for built computers. Provides all CRUD methods and the core `buildComputer()`, `sellComputer()`, and `buyComputer()` logic.

### `User`
Stores a `userId`, `name`, and an optional reference to an owned `Computer`. Includes `hasComputer()` check and two display methods (summary and full specs).

### `FileManager`
Handles file I/O for all eight data files. Uses `FileWriter` for saving and `Scanner`/`BufferedReader` for loading. Data is stored in a labeled line-by-line format (e.g., `Brand: Intel`).

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK) **8 or later**
- A terminal / command prompt

### Compilation

```bash
javac Main.java
```

### Running

```bash
java Main
```

Data files are created automatically in the working directory on first run.

---

## Usage Guide

On launch, the main menu appears:

```
--- Computer Hardware Management ---

Press 1 to Add Hardware
Press 2 to Edit Hardware
Press 3 to Delete Hardware
Press 4 to Display Hardwares
Press 5 to Display Built Computers
Press 6 to Build a Computer
Press 7 to Manage Users
Press 8 to Exit
```

### Adding Hardware
Select option **1**, then choose the component type. You'll be prompted to enter all relevant specs.

### Editing Hardware
Select option **2**, choose the component type, pick a record from the list, then enter new values. **Press Enter to keep the current value** for any field.

### Building a Computer
Select option **6**. You'll walk through 6 steps, selecting a CPU, GPU, RAM, Storage, PSU, and Motherboard from available inventory. The selected parts are removed from inventory and assembled into a new `Computer` record.

### Managing Users
Select option **7** to access the user submenu:
- Add / Edit / Delete users
- Display all users (with full PC specs if owned)
- **Sell** a built computer to a user
- **Buy** a computer back from a user (returns it to inventory)

> A user can only own one computer at a time. The system will warn you before overwriting an existing ownership.

### Saving & Exiting
Select option **8**. All data is written to the `.txt` files before the program closes.

---

## Data Persistence

Each component type and entity is saved to its own file in a labeled plain-text format:

**Example `cpus.txt`:**
```
ID: 0
Brand: Intel
Model Name: Core i9-14900K
Price: 85000.0
Cores: 24
Threads: 32
Clock Speed: 3.2
Cache: 36
TDP: 125
Socket: LGA1700
--------------------
```

Data is loaded automatically at startup and saved on exit (option 8).

---

## Known Limitations

- **Single-file source** - All classes are in one `.java` file, which limits scalability for larger projects.
- **No compatibility validation** - The build process does not check socket compatibility between CPU and Motherboard.
- **No quantity tracking** - Each hardware entry represents a single unit; there is no stock count per model.
- **Plain-text storage** - The file format is sensitive to manual edits; corrupted files may cause load errors.
- **No search/filter** - Hardware can only be browsed by scrolling through the full list.

---

## Potential Improvements

- Add socket compatibility checks during PC builds
- Implement search and filter functionality for large inventories
- Switch to JSON or a database (e.g., SQLite) for more robust persistence
- Split classes into separate `.java` files for better maintainability
