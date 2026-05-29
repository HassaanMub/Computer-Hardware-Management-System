import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

abstract class Hardware{
    protected int id;
    protected String brand;
    protected String modelName;
    protected double price;
    public Hardware(int id, String brand, String modelName, double price){
        this.id = id;
        this.brand = brand;
        this.modelName = modelName;
        this.price = price;
    }
    public abstract void display();
}
// COMPONENT CLASSES
class CPU extends Hardware{
    int cores;
    int threads;
    double clockSpeed;
    int cache;
    int tdp;
    String socket;
    static int nextId = 0;
    public CPU(int cores, int threads, double clockSpeed, int cache, 
        int tdp, String socket, String brand, String modelName, double price){
        super(nextId++, brand, modelName, price);
        this.cores = cores;
        this.threads = threads;
        this.clockSpeed = clockSpeed;
        this.cache = cache;
        this.tdp = tdp;
        this.socket = socket;
    }
    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Model Name: " + modelName);
        System.out.println("Cores: " + cores);
        System.out.println("Threads: " + threads);
        System.out.println("Socket: " + socket);
        System.out.println("Clock Speed: " + clockSpeed + "GHz");
        System.out.println("Cache: " + cache + "MB");
        System.out.println("TDP: " + tdp + "W");
        System.out.println("Price: Rs" + price);
        System.out.println("----------");
    }
}
class GPU extends Hardware{
    int VRAM;
    int cores;
    int speed;
    int tdp;
    static int nextId = 0;
    public GPU(int VRAM, int cores, int speed, int tdp, 
        String brand, String modelName, double price){
        super(nextId++, brand, modelName, price);
        this.VRAM = VRAM;
        this.cores = cores;
        this.speed = speed;
        this.tdp = tdp;
    }
    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Model Name: " + modelName);
        System.out.println("VRAM: " + VRAM + "GB");
        System.out.println("Cores: " + cores);
        System.out.println("Clock Speed: " + speed + "MHz");
        System.out.println("TDP: " + tdp + "W");
        System.out.println("Price: Rs" + price);
        System.out.println("----------");
    }
}
class RAM extends Hardware{
    int ramCapacity;
    int speed;
    int latency;
    static int nextId = 0;
    public RAM(int ramCapacity, int speed, int latency, 
        String brand, String modelName, double price){
        super(nextId++, brand, modelName, price);
        this.ramCapacity = ramCapacity;
        this.speed = speed;
        this.latency = latency;
    }
    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Model Name: " + modelName);
        System.out.println("RAM Capacity: " + ramCapacity + "GB");
        System.out.println("Speed: " + speed + "Mhz");
        System.out.println("Latency: CL" + latency);
        System.out.println("Price: Rs" + price);
        System.out.println("----------");
    }
}
class Storage extends Hardware{
    String type;
    int capacity;
    static int nextId = 0;
    public Storage(String type, int capacity, 
        String brand, String modelName, double price){
        super(nextId++, brand, modelName, price);
        this.type = type;
        this.capacity = capacity;
    }
    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Model Name: " + modelName);
        System.out.println("Type: " + type);
        System.out.println("Memory Capacity: " + capacity + "GB");
        System.out.println("Price: Rs" + price);
        System.out.println("----------");
    }
}
class PSU extends Hardware{
    int watt;
    String efficiency;
    boolean isModular;
    static int nextId = 0;
    public PSU(int watt, String efficiency, boolean isModular, 
        String brand, String modelName, double price){
        super(nextId++, brand, modelName, price);
        this.watt = watt;
        this.efficiency = efficiency;
        this.isModular = isModular;
    }
    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Model Name: " + modelName);
        System.out.println("Watts: " + watt + "W");
        System.out.println("Efficiency: 80 Plus " + efficiency);
        System.out.println("Price: Rs" + price);
        System.out.println("----------");
    }
}
class MotherBoard extends Hardware{
    String socket;
    int ramSlot;
    static int nextId = 0;
    public MotherBoard(String socket, int ramSlot, 
        String brand, String modelName, double price){
        super(nextId++, brand, modelName, price);
        this.socket = socket;
        this.ramSlot = ramSlot;
    }
    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Model Name: " + modelName);
        System.out.println("Socket: " + socket);
        System.out.println("Ram Slots: " + ramSlot);
        System.out.println("Price: Rs" + price);
        System.out.println("----------");
    }
}
// COMPUTER CLASS
class Computer {
    int id;
    private CPU cpu;
    private GPU gpu;
    private RAM ram;
    private Storage storage;
    private PSU psu;
    static int nextCompId = 0;
    public Computer(CPU cpu, GPU gpu, RAM ram,
        Storage storage, PSU psu) {
        this.id = nextCompId++;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.storage = storage;
        this.psu = psu;
    }
    public void displaySpecs(){
        cpu.display();
        System.out.println();
        gpu.display();
        System.out.println();
        ram.display();
        System.out.println();
        storage.display();
        System.out.println();
        psu.display();
    }
}
// INVENTORY CLASS
class Inventory {
    ArrayList<CPU> cpus = new ArrayList<>();
    ArrayList<GPU> gpus = new ArrayList<>();
    ArrayList<RAM> rams = new ArrayList<>();
    ArrayList<Storage> storage = new ArrayList<>();
    ArrayList<PSU> psus = new ArrayList<>();
    ArrayList<MotherBoard> mbs = new ArrayList<>();
    ArrayList<Computer> builtComputers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    // Add Methods
    public void addCPU(){
        String brand, modelName, socket;
        int cores, threads, cache, tdp;
        double price, clockSpeed;
        sc.nextLine(); // Flush
        System.out.println("Enter Brand: ");
        brand = sc.nextLine();
        System.out.println("Enter Model Name: ");
        modelName = sc.nextLine();
        System.out.println("Enter Price: ");
        price = sc.nextDouble();
        System.out.println("Enter Cores: ");
        cores = sc.nextInt();
        System.out.println("Enter Threads: ");
        threads = sc.nextInt();
        System.out.println("Enter Clock Speed: ");
        clockSpeed = sc.nextDouble();
        System.out.println("Enter Cache: ");
        cache = sc.nextInt();
        System.out.println("Enter TDP: ");
        tdp = sc.nextInt();
        sc.nextLine(); // Flush
        System.out.println("Enter Socket: ");
        socket = sc.nextLine();
        CPU cpu = new CPU(cores, threads, clockSpeed, cache, tdp, socket, brand, modelName, price);
        cpus.add(cpu);
    }
    public void addGPU(){
        String brand, modelName;
        int VRAM, cores, speed, tdp;
        double price;
        sc.nextLine(); // Flush
        System.out.println("Enter Brand: ");
        brand = sc.nextLine();
        System.out.println("Enter Model Name: ");
        modelName = sc.nextLine();
        System.out.println("Enter Price: ");
        price = sc.nextDouble();
        System.out.println("Enter VRAM: ");
        VRAM = sc.nextInt();
        System.out.println("Enter Cores: ");
        cores = sc.nextInt();
        System.out.println("Enter Clock Speed: ");
        speed = sc.nextInt();
        System.out.println("Enter TDP: ");
        tdp = sc.nextInt();
        GPU gpu = new GPU(VRAM, cores, speed, tdp, brand, modelName, price);
        gpus.add(gpu);
    }
    public void addRAM(){
        String brand, modelName;
        int ramCapacity, speed, latency;
        double price;
        sc.nextLine(); // Flush
        System.out.println("Enter Brand: ");
        brand = sc.nextLine();
        System.out.println("Enter Model Name: ");
        modelName = sc.nextLine();
        System.out.println("Enter Price: ");
        price = sc.nextDouble();
        System.out.println("Enter RAM Capacity: ");
        ramCapacity = sc.nextInt();
        System.out.println("Enter Speed: ");
        speed = sc.nextInt();
        System.out.println("Enter Latency (CL): ");
        latency = sc.nextInt();
        RAM ram = new RAM(ramCapacity, speed, latency, brand, modelName, price);
        rams.add(ram);
    }
    public void addSTRG(){
        String brand, modelName, type;
        int capacity;
        double price;
        sc.nextLine(); // Flush
        System.out.println("Enter Brand: ");
        brand = sc.nextLine();
        System.out.println("Enter Model Name: ");
        modelName = sc.nextLine();
        System.out.println("Enter Price: ");
        price = sc.nextDouble();
        sc.nextLine(); // Flush
        System.out.println("Enter Type: ");
        type = sc.nextLine();
        System.out.println("Enter Capacity: ");
        capacity = sc.nextInt();
        Storage strg = new Storage(type, capacity, brand, modelName, price);
        storage.add(strg);
    }
    public void addPSU(){
        String brand, modelName, efficiency, mod;
        int watt;
        double price;
        boolean isModular = false;
        boolean flagVar = false;
        sc.nextLine(); // Flush
        System.out.println("Enter Brand: ");
        brand = sc.nextLine();
        System.out.println("Enter Model Name: ");
        modelName = sc.nextLine();
        System.out.println("Enter Price: ");
        price = sc.nextDouble();
        System.out.println("Enter Watt: ");
        watt = sc.nextInt();
        sc.nextLine(); // Flush
        System.out.println("Enter Efficiency Tier: ");
        efficiency = sc.nextLine();
        do{
            System.out.println("Is It Modular? (y/n): ");
            mod = sc.nextLine();
            if (mod.equalsIgnoreCase("y")){
                isModular = true;
                flagVar = true;
            }
            else if (mod.equalsIgnoreCase("n")){
                isModular = false;
                flagVar = true;
            }
            else{
                System.out.println("Invalid Input!\n");
            }
        }while(flagVar != true);
        PSU psu = new PSU(watt, efficiency, isModular, brand, modelName, price);
        psus.add(psu);
    }
    public void addMB(){
        String brand, modelName, socket;
        int ramSlot;
        double price;
        sc.nextLine(); // Flush
        System.out.println("Enter Brand: ");
        brand = sc.nextLine();
        System.out.println("Enter Model: ");
        modelName = sc.nextLine();
        System.out.println("Enter Price: ");
        price = sc.nextDouble();
        sc.nextLine(); // Flush
        System.out.println("Enter Socket: ");
        socket = sc.nextLine();
        System.out.println("Enter Ram Slots: ");
        ramSlot = sc.nextInt();
        MotherBoard mb = new MotherBoard(socket, ramSlot, brand, modelName, price);
        mbs.add(mb);
    }
    // Edit Methods
    public void editCPU() {
        if (cpus.isEmpty()) { 
            System.out.println("No CPUs in Inventory.\n"); 
            return; 
        }
        System.out.println("--- CPU List ---");
        for (int i = 0; i < cpus.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            cpus.get(i).display();
        }
        System.out.print("Select CPU Number to Edit: ");
        int choice = sc.nextInt(); 
        sc.nextLine();
        if (choice < 1 || choice > cpus.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        CPU cpu = cpus.get(choice - 1);
        System.out.println("\nCurrent Details:");
        cpu.display();
        System.out.println("\nEnter New Values (Press Enter to Keep Current Values)\n");
        System.out.print("Brand (" + cpu.brand + "): ");
        String input = sc.nextLine();
        if (!input.trim().isEmpty()) cpu.brand = input;
        System.out.print("Model Name (" + cpu.modelName + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) cpu.modelName = input;
        System.out.print("Price (" + cpu.price + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) cpu.price = Double.parseDouble(input);
        System.out.print("Cores (" + cpu.cores + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) cpu.cores = Integer.parseInt(input);
        System.out.print("Threads (" + cpu.threads + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) cpu.threads = Integer.parseInt(input);
        System.out.print("Clock Speed (" + cpu.clockSpeed + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) cpu.clockSpeed = Double.parseDouble(input);
        System.out.print("Cache (" + cpu.cache + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) cpu.cache = Integer.parseInt(input);
        System.out.print("TDP (" + cpu.tdp + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) cpu.tdp = Integer.parseInt(input);
        System.out.print("Socket (" + cpu.socket + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) cpu.socket = input;
        System.out.println("CPU updated successfully!\n");
    }
    public void editGPU() {
        if (gpus.isEmpty()) { 
            System.out.println("No GPUs in Inventory.\n"); 
            return; 
        }
        System.out.println("--- GPU List ---");
        for (int i = 0; i < gpus.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            gpus.get(i).display();
        }
        System.out.print("Select GPU Number to Edit: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > gpus.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        GPU gpu = gpus.get(choice - 1); 
        System.out.println("\nCurrent Details:");
        gpu.display();
        System.out.println("\nEnter New Values (Press Enter to Keep Current Values)\n");
        System.out.print("Brand (" + gpu.brand + "): ");
        String input = sc.nextLine();
        if (!input.trim().isEmpty()) gpu.brand = input;
        System.out.print("Model Name (" + gpu.modelName + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) gpu.modelName = input;
        System.out.print("Price (Rs " + gpu.price + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) gpu.price = Double.parseDouble(input);
        System.out.print("VRAM (" + gpu.VRAM + "GB): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) gpu.VRAM = Integer.parseInt(input);
        System.out.print("Cores (" + gpu.cores + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) gpu.cores = Integer.parseInt(input);
        System.out.print("Clock Speed (" + gpu.speed + "MHz): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) gpu.speed = Integer.parseInt(input);
        System.out.print("TDP (" + gpu.tdp + "W): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) gpu.tdp = Integer.parseInt(input);
        System.out.println("GPU Updated Successfully!\n");
    }
    public void editRAM() {
        if (rams.isEmpty()) { 
            System.out.println("No RAM in Inventory.\n"); 
            return; 
        }
        System.out.println("--- RAM List ---");
        for (int i = 0; i < rams.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            rams.get(i).display();
        }
        System.out.print("Select RAM Number to Edit: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > rams.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        RAM ram = rams.get(choice - 1);
        System.out.println("\nCurrent details:");
        ram.display();
        System.out.println("\nEnter new values (Press Enter to Keep Current Values)\n");
        System.out.print("Brand (" + ram.brand + "): ");
        String input = sc.nextLine();
        if (!input.trim().isEmpty()) ram.brand = input;
        System.out.print("Model Name (" + ram.modelName + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) ram.modelName = input;
        System.out.print("Price (Rs " + ram.price + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) ram.price = Double.parseDouble(input);
        System.out.print("Capacity (" + ram.ramCapacity + "GB): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) ram.ramCapacity = Integer.parseInt(input);
        System.out.print("Speed (" + ram.speed + "MHz): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) ram.speed = Integer.parseInt(input);
        System.out.print("Latency (CL" + ram.latency + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) ram.latency = Integer.parseInt(input);
        System.out.println("RAM Updated Successfully!\n");
    }
    public void editStorage() {
        if (storage.isEmpty()) { 
            System.out.println("No Storage in Inventory.\n"); 
            return; 
        }
        System.out.println("--- Storage List ---");
        for (int i = 0; i < storage.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            storage.get(i).display();
        }
        System.out.print("Select Storage Number to Edit: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > storage.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        Storage strg = storage.get(choice - 1);
        System.out.println("\nCurrent Details:");
        strg.display();
        System.out.println("\nEnter new values (Press Enter to Keep Current Values)\n");
        System.out.print("Brand (" + strg.brand + "): ");
        String input = sc.nextLine();
        if (!input.trim().isEmpty()) strg.brand = input;
        System.out.print("Model Name (" + strg.modelName + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) strg.modelName = input;
        System.out.print("Price (Rs " + strg.price + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) strg.price = Double.parseDouble(input);
        System.out.print("Type (" + strg.type + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) strg.type = input;
        System.out.print("Capacity (" + strg.capacity + "GB): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) strg.capacity = Integer.parseInt(input);
        System.out.println("Storage Updated Successfully!\n");
    }
    public void editPSU() {
        if (psus.isEmpty()) { 
            System.out.println("No PSUs in Inventory.\n"); 
            return; 
        }
        System.out.println("--- PSU List ---");
        for (int i = 0; i < psus.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            psus.get(i).display();
        }
        System.out.print("Select PSU Number to Edit: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > psus.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        PSU psu = psus.get(choice - 1);
        System.out.println("\nCurrent Details:");
        psu.display();
        System.out.println("\nEnter new values (Press Enter to Keep Current Values)\n");
        System.out.print("Brand (" + psu.brand + "): ");
        String input = sc.nextLine();
        if (!input.trim().isEmpty()) psu.brand = input;
        System.out.print("Model Name (" + psu.modelName + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) psu.modelName = input;
        System.out.print("Price (Rs " + psu.price + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) psu.price = Double.parseDouble(input);
        System.out.print("Watts (" + psu.watt + "W): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) psu.watt = Integer.parseInt(input);
        System.out.print("Efficiency Tier (" + psu.efficiency + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) psu.efficiency = input;
        System.out.print("Is Modular? (y/n) (" + (psu.isModular ? "y" : "n") + "): ");
        input = sc.nextLine();
        if (input.equalsIgnoreCase("y")) psu.isModular = true;
        else if (input.equalsIgnoreCase("n")) psu.isModular = false;
        System.out.println("PSU Updated Successfully!\n");
    }
    public void editMB() {
        if (mbs.isEmpty()) { 
            System.out.println("No Motherboards in Inventory.\n"); 
            return; 
        }
        System.out.println("--- Motherboard List ---");
        for (int i = 0; i < mbs.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            mbs.get(i).display();
        }
        System.out.print("Select Motherboard Number to Edit: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > mbs.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        MotherBoard mb = mbs.get(choice - 1);
        System.out.println("\nCurrent Details:");
        mb.display();
        System.out.println("\nEnter new values (Press Enter to Keep Current Values)\n");
        System.out.print("Brand (" + mb.brand + "): ");
        String input = sc.nextLine();
        if (!input.trim().isEmpty()) mb.brand = input;
        System.out.print("Model Name (" + mb.modelName + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) mb.modelName = input;
        System.out.print("Price (Rs " + mb.price + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) mb.price = Double.parseDouble(input);
        System.out.print("Socket (" + mb.socket + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) mb.socket = input;
        System.out.print("RAM Slots (" + mb.ramSlot + "): ");
        input = sc.nextLine();
        if (!input.trim().isEmpty()) mb.ramSlot = Integer.parseInt(input);
        System.out.println("Motherboard Updated Successfully!\n");
    }
    // Delete Methods
    public void deleteCPU() {
        if (cpus.isEmpty()) { 
            System.out.println("No CPUs in Inventory.\n"); 
            return; 
        }
        System.out.println("--- CPU List ---");
        for (int i = 0; i < cpus.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            cpus.get(i).display();
        }
        System.out.print("Select CPU Number to Delete: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > cpus.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        CPU removed = cpus.remove(choice - 1);
        System.out.println("Deleted: " + removed.brand + " " + removed.modelName + "\n");
    }
    public void deleteGPU() {
        if (gpus.isEmpty()) { 
            System.out.println("No GPUs in Inventory.\n"); 
            return; 
        }
        System.out.println("--- GPU List ---");
        for (int i = 0; i < gpus.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            gpus.get(i).display();
        }
        System.out.print("Select GPU Number to Delete: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > gpus.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        GPU removed = gpus.remove(choice - 1);
        System.out.println("Deleted: " + removed.brand + " " + removed.modelName + "\n");
    }
    public void deleteRAM() {
        if (rams.isEmpty()) { 
            System.out.println("No RAM in Inventory.\n"); 
            return; 
        }
        System.out.println("--- RAM List ---");
        for (int i = 0; i < rams.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            rams.get(i).display();
        }
        System.out.print("Select RAM Number to Delete: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > rams.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        RAM removed = rams.remove(choice - 1);
        System.out.println("Deleted: " + removed.brand + " " + removed.modelName + "\n");
    }
    public void deleteStorage() {
        if (storage.isEmpty()) { 
            System.out.println("No Storage in Inventory.\n"); 
            return; 
        }
        System.out.println("--- Storage List ---");
        for (int i = 0; i < storage.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            storage.get(i).display();
        }
        System.out.print("Select Storage Number to Delete: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > storage.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        Storage removed = storage.remove(choice - 1);
        System.out.println("Deleted: " + removed.brand + " " + removed.modelName + "\n");
    }
    public void deletePSU() {
        if (psus.isEmpty()) { 
            System.out.println("No PSUs in Inventory.\n"); 
            return; 
        }
        System.out.println("--- PSU List ---");
        for (int i = 0; i < psus.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            psus.get(i).display();
        }
        System.out.print("Select PSU Number to Delete: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > psus.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        PSU removed = psus.remove(choice - 1);
        System.out.println("Deleted: " + removed.brand + " " + removed.modelName + "\n");
    }
    public void deleteMB() {
        if (mbs.isEmpty()) { 
            System.out.println("No Motherboards in Inventory.\n"); 
            return; 
        }
        System.out.println("--- Motherboard List ---");
        for (int i = 0; i < mbs.size(); i++) {
            System.out.print("(" + (i + 1) + ") ");
            mbs.get(i).display();
        }
        System.out.print("Select Motherboard Number to Delete: ");
        int choice = sc.nextInt(); sc.nextLine();
        if (choice < 1 || choice > mbs.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        MotherBoard removed = mbs.remove(choice - 1);
        System.out.println("Deleted: " + removed.brand + " " + removed.modelName + "\n");
    }
    // Build Computer
    public void buildComputer() {
        System.out.println("\n--- Build a Computer ---");
        if (cpus.isEmpty()) { 
            System.out.println("No CPUs in Inventory. Cannot Build Computer.\n"); 
            return; 
        }
        System.out.println("\n[Step 1 of 5] Select a CPU:");
        for (int i = 0; i < cpus.size(); i++) {
            System.out.println("(" + (i + 1) + ")");
            cpus.get(i).display();
        }
        System.out.print("Enter CPU Number: ");
        int cpuChoice = sc.nextInt(); sc.nextLine();
        if (cpuChoice < 1 || cpuChoice > cpus.size()) { 
            System.out.println("Invalid Selection. Build Cancelled.\n"); 
            return; 
        }
        CPU selectedCPU = cpus.get(cpuChoice - 1);
        if (gpus.isEmpty()) { 
            System.out.println("No GPUs in Inventory. Cannot Build Computer.\n"); 
            return; 
        }
        System.out.println("\n[Step 2 of 5] Select a GPU:");
        for (int i = 0; i < gpus.size(); i++) {
            System.out.println("(" + (i + 1) + ")");
            gpus.get(i).display();
        }
        System.out.print("Enter GPU Number: ");
        int gpuChoice = sc.nextInt(); sc.nextLine();
        if (gpuChoice < 1 || gpuChoice > gpus.size()) { 
            System.out.println("Invalid Selection. Build Cancelled.\n"); 
            return; 
        }
        GPU selectedGPU = gpus.get(gpuChoice - 1);
        if (rams.isEmpty()) { 
            System.out.println("No RAM in Inventory. Cannot Build Computer.\n"); 
            return; 
        }
        System.out.println("\n[Step 3 of 5] Select RAM:");
        for (int i = 0; i < rams.size(); i++) {
            System.out.println("(" + (i + 1) + ")");
            rams.get(i).display();
        }
        System.out.print("Enter RAM Number: ");
        int ramChoice = sc.nextInt(); sc.nextLine();
        if (ramChoice < 1 || ramChoice > rams.size()) { 
            System.out.println("Invalid Selection. Build Cancelled.\n"); 
            return; 
        }
        RAM selectedRAM = rams.get(ramChoice - 1);
        if (storage.isEmpty()) { 
            System.out.println("No Storage in Inventory. Cannot Build Computer.\n"); 
            return; 
        }
        System.out.println("\n[Step 4 of 5] Select Storage:");
        for (int i = 0; i < storage.size(); i++) {
            System.out.println("(" + (i + 1) + ")");
            storage.get(i).display();
        }
        System.out.print("Enter Storage Number: ");
        int strgChoice = sc.nextInt(); sc.nextLine();
        if (strgChoice < 1 || strgChoice > storage.size()) { 
            System.out.println("Invalid Selection. Build Cancelled.\n"); 
            return; 
        }
        Storage selectedStorage = storage.get(strgChoice - 1);
        if (psus.isEmpty()) { 
            System.out.println("No PSUs in Inventory. Cannot Build Computer.\n"); 
            return; 
        }
        System.out.println("\n[Step 5 of 5] Select a PSU:");
        for (int i = 0; i < psus.size(); i++) {
            System.out.println("(" + (i + 1) + ")");
            psus.get(i).display();
        }
        System.out.print("Enter PSU Number: ");
        int psuChoice = sc.nextInt(); sc.nextLine();
        if (psuChoice < 1 || psuChoice > psus.size()) { 
            System.out.println("Invalid Selection. Build Cancelled.\n"); 
            return; }
        PSU selectedPSU = psus.get(psuChoice - 1);
        // Remove chosen parts from inventory 
        cpus.remove(cpuChoice - 1);
        gpus.remove(gpuChoice - 1);
        rams.remove(ramChoice - 1);
        storage.remove(strgChoice - 1);
        psus.remove(psuChoice - 1);
        Computer newPC = new Computer(selectedCPU, selectedGPU, selectedRAM, selectedStorage, selectedPSU);
        builtComputers.add(newPC);
        System.out.println("\nComputer Built Successfully! Here are its specs:");
        newPC.displaySpecs();
    }
    // Sell Computer To User
    public void sellComputer(ArrayList<User> users) {
        if (builtComputers.isEmpty()) {
            System.out.println("No computers available in inventory to sell.\n");
            return;
        }
        if (users.isEmpty()) {
            System.out.println("No users found. Add a user first.\n");
            return;
        }
        // Show computers
        System.out.println("\n--- Available Computers ---");
        for (int i = 0; i < builtComputers.size(); i++) {
            System.out.println("(" + (i + 1) + ")");
            builtComputers.get(i).displaySpecs();
        }
        System.out.print("Select Computer Number to Sell: ");
        int compChoice = sc.nextInt(); 
        sc.nextLine();
        if (compChoice < 1 || compChoice > builtComputers.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        Computer selectedPC = builtComputers.get(compChoice - 1);
        // Show users
        System.out.println("\n--- User List ---");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("(" + (i + 1) + ")");
            users.get(i).displayUser();
        }
        System.out.print("Select User Number to Sell To: ");
        int userChoice = sc.nextInt(); sc.nextLine();
        if (userChoice < 1 || userChoice > users.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        User selectedUser = users.get(userChoice - 1);
        // Warn if user already owns a computer
        if (selectedUser.hasComputer()) {
            System.out.println("Warning: " + selectedUser.name + " already owns Computer #"
                + selectedUser.pc.id + ". They cannot own two computers.");
            System.out.print("Cancel sale? (y/n): ");
            String ans = sc.nextLine();
            if (!ans.equalsIgnoreCase("n")) { System.out.println("Sale Cancelled.\n"); return; }
        }
        // Transfer: remove from inventory, assign to user
        builtComputers.remove(compChoice - 1);
        selectedUser.pc = selectedPC;
        System.out.println("Computer #" + selectedPC.id + " sold to " + selectedUser.name + " successfully!\n");
    }
 
    // Buy Computer From User
    public void buyComputer(ArrayList<User> users) {
        if (users.isEmpty()) { System.out.println("No users found.\n"); return; }
        // Filter to only users who own a computer
        ArrayList<User> usersWithPC = new ArrayList<>();
        for (User u : users) { if (u.hasComputer()) usersWithPC.add(u); }
        if (usersWithPC.isEmpty()) { System.out.println("No users currently own a computer.\n"); return; }
        System.out.println("\n--- Users With a Computer ---");
        for (int i = 0; i < usersWithPC.size(); i++) {
            System.out.println("(" + (i + 1) + ")");
            usersWithPC.get(i).displayUser();
        }
        System.out.print("Select User Number to Buy Computer From: ");
        int userChoice = sc.nextInt(); sc.nextLine();
        if (userChoice < 1 || userChoice > usersWithPC.size()) { System.out.println("Invalid Selection.\n"); return; }
        User selectedUser = usersWithPC.get(userChoice - 1);
        Computer returnedPC = selectedUser.pc;
        // Transfer: remove from user, add back to inventory
        selectedUser.pc = null;
        builtComputers.add(returnedPC);
        System.out.println("Computer #" + returnedPC.id + " bought back from " + selectedUser.name + " and returned to inventory!\n");
    }
    // Display Methods
    public void displayAllHardware(){
        // CPUs
        System.out.println("--- CPUs ---\n");
        for(CPU cpu : cpus){
            cpu.display();
            System.out.println();
        }
        // GPUs
        System.out.println("--- GPUs ---\n");
        for(GPU gpu : gpus){
            gpu.display();
            System.out.println();
        }
        // Storage
        System.out.println("--- Storage ---\n");
        for(Storage strg : storage){
            strg.display();
            System.out.println();
        }
        // RAM
        System.out.println("--- RAM ---\n");
        for(RAM ram : rams){
            ram.display();
            System.out.println();
        }
        // Motherboards
        System.out.println("--- Motherboards ---\n");
        for(MotherBoard mb : mbs){
            mb.display();
            System.out.println();
        }
        // PSUs
        System.out.println("--- PSUs ---\n");
        for(PSU psu : psus){
            psu.display();
            System.out.println();
        }
    }
    public void displayBuiltComputers(){
        for(Computer computer : builtComputers){
            computer.displaySpecs();
        }
    }
}
// USER CLASS
class User{
    int userId;
    String name;
    Computer pc;
    static int nextUserId = 0;
    // Constructor 
    public User(String name){
        this.userId = nextUserId++;
        this.name = name;
    }
    // Check for Computer
    public boolean hasComputer(){
        return pc != null;
    }
    // Display
    public void displayUser(){
        System.out.println("----------");
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        if (pc != null) {
            System.out.println("Owned Computer: Computer #" + pc.id);
        } else {
            System.out.println("Owned Computer: None");
        }
        System.out.println("----------");
    }
    public void displayUserFull(){
        System.out.println("----------");
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        if (pc != null) {
            System.out.println("Owned Computer:");
            pc.displaySpecs();
        } else {
            System.out.println("Owned Computer: None");
        }
        System.out.println("----------");
    }
}
// File Handling
class FileManager {
    // FIle Names
    static final String CPU_FILE = "cpus.txt";
    static final String GPU_FILE = "gpus.txt";
    static final String RAM_FILE = "rams.txt";
    static final String STORAGE_FILE = "storage.txt";
    static final String PSU_FILE = "psus.txt";
    static final String MB_FILE = "mbs.txt";
    static final String USERS_FILE = "users.txt";
    static final String BUILT_PC_FILE = "builtComputers.txt";

    // Create A File
    public static void createFile(String fileName){
        try {
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
                System.out.println(fileName + "Created!");
            }
        } catch (IOException e) {
            System.out.println("Error Creating File.");
        }
    }
    // Initialize Files
    public static void initializeFiles() { 
        createFile(CPU_FILE); 
        createFile(GPU_FILE); 
        createFile(RAM_FILE); 
        createFile(STORAGE_FILE); 
        createFile(PSU_FILE); 
        createFile(MB_FILE); 
        createFile(USERS_FILE); 
        createFile(BUILT_PC_FILE); 
    }
    // Save CPUs
    public static void saveCPU(CPU cpu) { 
        try { 
            FileWriter writer = new FileWriter(CPU_FILE, true); 
            writer.write("ID: " + cpu.id + "\n"); 
            writer.write("Brand: " + cpu.brand + "\n"); 
            writer.write("Model Name: " + cpu.modelName + "\n"); 
            writer.write("Price: " + cpu.price + "\n"); 
            writer.write("Cores: " + cpu.cores + "\n"); 
            writer.write("Threads: " + cpu.threads + "\n"); 
            writer.write("Clock Speed: " + cpu.clockSpeed + "\n"); 
            writer.write("Cache: " + cpu.cache + "\n"); 
            writer.write("TDP: " + cpu.tdp + "\n"); 
            writer.write("Socket: " + cpu.socket + "\n"); 
            writer.write("---\n"); 
            writer.close(); 
        } 
        catch(IOException e) { 
            System.out.println("Error Saving CPU."); 
        } 
    }
    // LOAD CPUs
    public static void loadCPUs(ArrayList<CPU> cpus){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(CPU_FILE));
            String line;
            while((line = reader.readLine()) != null){
                int id = Integer.parseInt(line.substring(4));
                String brand = reader.readLine().substring(7);
                String modelName = reader.readLine().substring(12);
                double price = Double.parseDouble(reader.readLine().substring(7));
                int cores = Integer.parseInt(reader.readLine().substring(7));
                int threads = Integer.parseInt(reader.readLine().substring(9));
                double clockSpeed = Double.parseDouble(reader.readLine().substring(13));
                int cache = Integer.parseInt(reader.readLine().substring(7));
                int tdp = Integer.parseInt(reader.readLine().substring(5));
                String socket = reader.readLine().substring(8);
                reader.readLine();
                CPU cpu = new CPU(
                    cores,
                    threads,
                    clockSpeed,
                    cache,
                    tdp,
                    socket,
                    brand,
                    modelName,
                    price
                );
                cpu.id = id;
                cpus.add(cpu);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error Loading CPUs.");
        }
    }
    // Save GPUs
    public static void saveGPU(GPU gpu) {

        createFile(GPU_FILE);

        try {
            FileWriter writer = new FileWriter(GPU_FILE, true);

            writer.write("ID: " + gpu.id + "\n");
            writer.write("Brand: " + gpu.brand + "\n");
            writer.write("Model Name: " + gpu.modelName + "\n");
            writer.write("Price: " + gpu.price + "\n");
            writer.write("VRAM: " + gpu.VRAM + "\n");
            writer.write("Cores: " + gpu.cores + "\n");
            writer.write("Speed: " + gpu.speed + "\n");
            writer.write("TDP: " + gpu.tdp + "\n");
            writer.write("--------------------\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Error Saving GPU.");
        }
    }
    // Load GPUs
    public static void loadGPUs(ArrayList<GPU> gpus) {

        createFile(GPU_FILE);

        try {
            Scanner reader = new Scanner(new File(GPU_FILE));

            while (reader.hasNextLine()) {

                reader.nextLine();
                String brand = reader.nextLine().substring(7);
                String model = reader.nextLine().substring(12);
                double price = Double.parseDouble(reader.nextLine().substring(7));
                int vram = Integer.parseInt(reader.nextLine().substring(6));
                int cores = Integer.parseInt(reader.nextLine().substring(7));
                int speed = Integer.parseInt(reader.nextLine().substring(7));
                int tdp = Integer.parseInt(reader.nextLine().substring(5));

                reader.nextLine();

                GPU gpu = new GPU(
                    vram, cores, speed, tdp,
                    brand, model, price
                );

                gpus.add(gpu);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error Loading GPUs.");
        }
    }
    // Save RAMs
    public static void saveRAM(RAM ram) {

        createFile(RAM_FILE);

        try {
            FileWriter writer = new FileWriter(RAM_FILE, true);

            writer.write("ID: " + ram.id + "\n");
            writer.write("Brand: " + ram.brand + "\n");
            writer.write("Model Name: " + ram.modelName + "\n");
            writer.write("Price: " + ram.price + "\n");
            writer.write("Capacity: " + ram.ramCapacity + "\n");
            writer.write("Speed: " + ram.speed + "\n");
            writer.write("Latency: " + ram.latency + "\n");
            writer.write("--------------------\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Error Saving RAM.");
        }
    }
    // Load RAMs
    public static void loadRAMs(ArrayList<RAM> rams) {

        createFile(RAM_FILE);

        try {
            Scanner reader = new Scanner(new File(RAM_FILE));

            while (reader.hasNextLine()) {

                reader.nextLine();
                String brand = reader.nextLine().substring(7);
                String model = reader.nextLine().substring(12);
                double price = Double.parseDouble(reader.nextLine().substring(7));
                int capacity = Integer.parseInt(reader.nextLine().substring(10));
                int speed = Integer.parseInt(reader.nextLine().substring(7));
                int latency = Integer.parseInt(reader.nextLine().substring(9));

                reader.nextLine();

                RAM ram = new RAM(
                    capacity, speed, latency,
                    brand, model, price
                );

                rams.add(ram);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error Loading RAMs.");
        }
    }
    // Save Storage
    public static void saveStorage(Storage strg) {

        createFile(STORAGE_FILE);

        try {
            FileWriter writer = new FileWriter(STORAGE_FILE, true);

            writer.write("ID: " + strg.id + "\n");
            writer.write("Brand: " + strg.brand + "\n");
            writer.write("Model Name: " + strg.modelName + "\n");
            writer.write("Price: " + strg.price + "\n");
            writer.write("Type: " + strg.type + "\n");
            writer.write("Capacity: " + strg.capacity + "\n");
            writer.write("--------------------\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Error Saving Storage.");
        }
    }
    // Load Storage
    public static void loadStorage(ArrayList<Storage> storage) {

        createFile(STORAGE_FILE);

        try {
            Scanner reader = new Scanner(new File(STORAGE_FILE));

            while (reader.hasNextLine()) {

                reader.nextLine();
                String brand = reader.nextLine().substring(7);
                String model = reader.nextLine().substring(12);
                double price = Double.parseDouble(reader.nextLine().substring(7));
                String type = reader.nextLine().substring(6);
                int capacity = Integer.parseInt(reader.nextLine().substring(10));

                reader.nextLine();

                Storage strg = new Storage(
                    type, capacity,
                    brand, model, price
                );

                storage.add(strg);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error Loading Storage.");
        }
    }
    // Save PSUs
    public static void savePSU(PSU psu) {

        createFile(PSU_FILE);

        try {
            FileWriter writer = new FileWriter(PSU_FILE, true);

            writer.write("ID: " + psu.id + "\n");
            writer.write("Brand: " + psu.brand + "\n");
            writer.write("Model Name: " + psu.modelName + "\n");
            writer.write("Price: " + psu.price + "\n");
            writer.write("Watt: " + psu.watt + "\n");
            writer.write("Efficiency: " + psu.efficiency + "\n");
            writer.write("Modular: " + psu.isModular + "\n");
            writer.write("--------------------\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Error Saving PSU.");
        }
    }
    // Load PSUs
    public static void loadPSUs(ArrayList<PSU> psus) {

        createFile(PSU_FILE);

        try {
            Scanner reader = new Scanner(new File(PSU_FILE));

            while (reader.hasNextLine()) {

                reader.nextLine();
                String brand = reader.nextLine().substring(7);
                String model = reader.nextLine().substring(12);
                double price = Double.parseDouble(reader.nextLine().substring(7));
                int watt = Integer.parseInt(reader.nextLine().substring(6));
                String efficiency = reader.nextLine().substring(12);
                boolean modular = Boolean.parseBoolean(reader.nextLine().substring(9));

                reader.nextLine();

                PSU psu = new PSU(
                    watt, efficiency, modular,
                    brand, model, price
                );

                psus.add(psu);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error Loading PSUs.");
        }
    }
    // Save MotherBoards
    public static void saveMB(MotherBoard mb) {

        createFile(MB_FILE);

        try {
            FileWriter writer = new FileWriter(MB_FILE, true);

            writer.write("ID: " + mb.id + "\n");
            writer.write("Brand: " + mb.brand + "\n");
            writer.write("Model Name: " + mb.modelName + "\n");
            writer.write("Price: " + mb.price + "\n");
            writer.write("Socket: " + mb.socket + "\n");
            writer.write("RAM Slots: " + mb.ramSlot + "\n");
            writer.write("--------------------\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Error Saving Motherboard.");
        }
    }
    // Load MotherBoards
    public static void loadMBs(ArrayList<MotherBoard> mbs) {

        createFile(MB_FILE);

        try {
            Scanner reader = new Scanner(new File(MB_FILE));

            while (reader.hasNextLine()) {

                reader.nextLine();
                String brand = reader.nextLine().substring(7);
                String model = reader.nextLine().substring(12);
                double price = Double.parseDouble(reader.nextLine().substring(7));
                String socket = reader.nextLine().substring(8);
                int ramSlots = Integer.parseInt(reader.nextLine().substring(11));

                reader.nextLine();

                MotherBoard mb = new MotherBoard(
                    socket, ramSlots,
                    brand, model, price
                );

                mbs.add(mb);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error Loading Motherboards.");
        }
    }
    // Save Users
    public static void saveUser(User user) {

        createFile(USERS_FILE);

        try {
            FileWriter writer = new FileWriter(USERS_FILE, true);

            writer.write("User ID: " + user.userId + "\n");
            writer.write("Name: " + user.name + "\n");

            if (user.pc != null) {
                writer.write("Computer ID: " + user.pc.id + "\n");
            }
            else {
                writer.write("Computer ID: None\n");
            }

            writer.write("--------------------\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Error Saving User.");
        }
    }
    // Save Built Computers
    public static void saveBuiltComputer(Computer pc) {

        createFile(BUILT_PC_FILE);

        try {
            FileWriter writer = new FileWriter(BUILT_PC_FILE, true);

            writer.write("Computer ID: " + pc.id + "\n");
            writer.write("--------------------\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Error Saving Built Computer.");
        }
    }
}
public class Main{
    static Scanner sc = new Scanner(System.in);
    static Inventory inventory = new Inventory();
    static ArrayList<User> users = new ArrayList<>();
    
    public static void main(String[] args) {
        // Initialize Files
        FileManager.initializeFiles();
        // Load Files
        FileManager.loadCPUs(inventory.cpus);
        FileManager.loadGPUs(inventory.gpus);
        FileManager.loadRAMs(inventory.rams);
        FileManager.loadStorage(inventory.storage);
        FileManager.loadPSUs(inventory.psus);
        FileManager.loadMBs(inventory.mbs);
        // Load Menu
        menu();
    }
    // Menu
    public static void menu(){
        int choice;
        do{
            System.out.println("--- Computer Hardware Management ---\n");
            System.out.println("Press 1 to Add Hardware");
            System.out.println("Press 2 to Edit Hardware");
            System.out.println("Press 3 to Delete Hardware");
            System.out.println("Press 4 to Display Hardwares");
            System.out.println("Press 5 to Display Built Computers");
            System.out.println("Press 6 to Build a Computer");
            System.out.println("Press 7 to Manage Users");
            System.out.println("Press 8 to Exit");
            System.out.println("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Flush
            switch(choice){
                case 1: addHardware();      break;
                case 2: editHardware();     break;
                case 3: delHardware();      break;
                case 4: displayHardware();  break;
                case 5: displayComputers(); break;
                case 6: buildComputers(); break;
                case 7: manageUsers();      break;
                case 8: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid Choice");
                }
        }while(choice != 8);
    }
    // Adding Hardware
    public static void addHardware(){
        int ch;
        do{
            System.out.println("--- Add Hardware ---\n");
            System.out.println("Press 1 to Add CPU");
            System.out.println("Press 2 to Add GPU");
            System.out.println("Press 3 to Add RAM");
            System.out.println("Press 4 to Add Storage");
            System.out.println("Press 5 to Add Motherboard");
            System.out.println("Press 6 to Add PSU");
            System.out.println("Press 7 to Go Back");
            System.out.println("Enter Choice: ");
            ch = sc.nextInt();
            sc.nextLine(); // Flush
            switch(ch){
                case 1: inventory.addCPU();     break;
                case 2: inventory.addGPU();     break;
                case 3: inventory.addRAM();     break;
                case 4: inventory.addSTRG();    break;
                case 5: inventory.addMB();      break;
                case 6: inventory.addPSU();     break;
                case 7: System.out.println();   break;
                default: System.out.println("Invalid Choice");
                }
        }while(ch != 7);
    }
    // Editing Hardware
    public static void editHardware(){
        int ch;
        do {
            System.out.println("\n--- Edit Hardware ---");
            System.out.println("Press 1 to Edit CPU");
            System.out.println("Press 2 to Edit GPU");
            System.out.println("Press 3 to Edit RAM");
            System.out.println("Press 4 to Edit Storage");
            System.out.println("Press 5 to Edit Motherboard");
            System.out.println("Press 6 to Edit PSU");
            System.out.println("Press 7 to Go Back");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();
            sc.nextLine(); // Flush
            switch (ch) {
                case 1: inventory.editCPU();     break;
                case 2: inventory.editGPU();     break;
                case 3: inventory.editRAM();     break;
                case 4: inventory.editStorage(); break;
                case 5: inventory.editMB();      break;
                case 6: inventory.editPSU();     break;
                case 7: System.out.println();    break;
                default: System.out.println("Invalid Choice\n");
            }
        } while (ch != 7);
    }
    // Delete Hardware
    public static void delHardware(){
        int ch;
        do {
            System.out.println("\n--- Delete Hardware ---");
            System.out.println("Press 1 to Delete CPU");
            System.out.println("Press 2 to Delete GPU");
            System.out.println("Press 3 to Delete RAM");
            System.out.println("Press 4 to Delete Storage");
            System.out.println("Press 5 to Delete Motherboard");
            System.out.println("Press 6 to Delete PSU");
            System.out.println("Press 7 to Go Back");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();
            sc.nextLine(); // Flush
            switch (ch) {
                case 1: inventory.deleteCPU();     break;
                case 2: inventory.deleteGPU();     break;
                case 3: inventory.deleteRAM();     break;
                case 4: inventory.deleteStorage(); break;
                case 5: inventory.deleteMB();      break;
                case 6: inventory.deletePSU();     break;
                case 7: System.out.println();      break;
                default: System.out.println("Invalid Choice\n");
            }
        } while (ch != 7);
    }
    // Display All Hardware
    public static void displayHardware(){
        inventory.displayAllHardware();
    }
    // Display All Built Computers
    public static void displayComputers(){
        inventory.displayBuiltComputers();
    }
    // Build A Computer
    public static void buildComputers(){
        inventory.buildComputer();
    }
    // USER OPERATIONS
    // Add User
    public static void addUser() {
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();
        users.add(new User(name));
        System.out.println("User \"" + name + "\" Added Successfully!\n");
    }
    // Edit User
    public static void editUser() {
        if (users.isEmpty()) { 
            System.out.println("No Users Found.\n"); 
            return; 
        }
        System.out.println("--- User List ---");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("(" + (i + 1) + ")");
            users.get(i).displayUser();
        }
        System.out.print("Select User Number to Edit: ");
        int choice = sc.nextInt(); 
        sc.nextLine(); // Flush
        if (choice < 1 || choice > users.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        User user = users.get(choice - 1);
        System.out.print("New Name (" + user.name + "): ");
        String input = sc.nextLine();
        if (!input.trim().isEmpty()) user.name = input;
        System.out.println("User Updated Successfully!\n");
    }
    // Delete User
    public static void deleteUser() {
        if (users.isEmpty()) { 
            System.out.println("No Users Found.\n"); 
            return; 
        }
        System.out.println("--- User List ---");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("(" + (i + 1) + ")");
            users.get(i).displayUser();
        }
        System.out.print("Select User Number to Delete: ");
        int choice = sc.nextInt(); 
        sc.nextLine(); // Flush
        if (choice < 1 || choice > users.size()) { 
            System.out.println("Invalid Selection.\n"); 
            return; 
        }
        User removed = users.remove(choice - 1);
        if (removed.hasComputer()) {
            inventory.builtComputers.add(removed.pc);
            System.out.println("Note: Computer #" + removed.pc.id + " Returned to Inventory.");
        }
        System.out.println("User \"" + removed.name + "\" Deleted.\n");
    }
    // Display Users
    public static void displayAllUsers() {
        if (users.isEmpty()) { 
            System.out.println("No Users Found.\n"); 
            return; 
        }
        System.out.println("--- All Users ---");
        for (User user : users) {
            user.displayUserFull();
        }
        System.out.println();
    }
    // Manage User Menu
    public static void manageUsers(){
        int ch;
        do {
            System.out.println("\n--- Manage Users ---");
            System.out.println("Press 1 to Add User");
            System.out.println("Press 2 to Edit User");
            System.out.println("Press 3 to Delete User");
            System.out.println("Press 4 to Display All Users");
            System.out.println("Press 5 to Sell a Computer to a User");
            System.out.println("Press 6 to Buy a Computer from a User");
            System.out.println("Press 7 to Go Back");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();
            sc.nextLine(); // Flush
            switch (ch) {
                case 1: addUser();                      break;
                case 2: editUser();                     break;
                case 3: deleteUser();                   break;
                case 4: displayAllUsers();              break;
                case 5: inventory.sellComputer(users);  break;
                case 6: inventory.buyComputer(users);   break;
                case 7: System.out.println();           break;
                default: System.out.println("Invalid Choice\n");
            }
        } while (ch != 7);
    }
}