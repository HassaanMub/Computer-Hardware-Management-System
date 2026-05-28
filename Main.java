import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

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
        System.out.println("Enter Socket: ");
        socket = sc.nextLine();
        CPU cpu = new CPU(cores, threads, clockSpeed, cache, tdp, socket, brand, modelName, price);
        cpus.add(cpu);
    }
    public void addGPU(){
        String brand, modelName;
        int VRAM, cores, speed, tdp;
        double price;
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
        System.out.println("Enter Brand: ");
        brand = sc.nextLine();
        System.out.println("Enter Model Name: ");
        modelName = sc.nextLine();
        System.out.println("Enter Price: ");
        price = sc.nextDouble();
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
        System.out.println("Enter Brand: ");
        brand = sc.nextLine();
        System.out.println("Enter Model Name: ");
        modelName = sc.nextLine();
        System.out.println("Enter Price: ");
        price = sc.nextDouble();
        System.out.println("Enter Watt: ");
        watt = sc.nextInt();
        System.out.println("Enter Efficiency Tier: ");
        efficiency = sc.nextLine();
        do{
            System.out.println("Is It Modular? (y/n): ");
            mod = sc.nextLine();
            if (mod.equalsIgnoreCase("y")){
                isModular = false;
                flagVar = true;
            }
            else if (mod.equalsIgnoreCase("n")){
                isModular = true;
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
        System.out.println("Enter Brand: ");
        brand = sc.nextLine();
        System.out.println("Enter Model: ");
        modelName = sc.nextLine();
        System.out.println("Enter Price: ");
        price = sc.nextDouble();
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
    private int userId;
    private String name;
    private Computer pc;
    static int nextUserId = 0;
    // Constructor 1
    public User(String name){
        this.userId = nextUserId++;
        this.name = name;
    }
    // Constructor 2
    public User(String name, Computer pc){
        this.userId = nextUserId++;
        this.name = name;
        this.pc = pc;
    }
    public void displayUser(){
        System.out.println("ID: " + userId);
        pc.displaySpecs();
        System.out.println("User: " + name);
        pc.displaySpecs();
        System.out.println("Owned Computer;\n");
        pc.displaySpecs();
    }
}
class FileManager {
    public static void saveUser(User user){
        try {
            FileWriter writer = new FileWriter("users.txt", true);
            writer.write("User Saved\n");
            writer.close();           
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
public class Main{
    static Scanner sc = new Scanner(System.in);
    static Inventory inventory = new Inventory();
    static ArrayList<User> users = new ArrayList<>();
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        int choice;
        do{
            System.out.println("--- Computer Hardware Management ---\n");
            System.out.println("Press 1 to Add Hardware");
            System.out.println("Press 2 to Edit Hardware");
            System.out.println("Press 3 to Delete Hardware");
            System.out.println("Press 4 to Display Hardwares");
            System.out.println("Press 5 to Display Computers");
            System.out.println("Press 6 to Build Computer");
            System.out.println("Press 7 to Manage Users");
            System.out.println("Press 8 to Exit");
            System.out.println("Enter Choice: ");
            choice = sc.nextInt();
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
        }while(ch != 6);
    }
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
            sc.nextLine();
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
            sc.nextLine(); // flush
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
    public static void displayHardware(){
        inventory.displayAllHardware();
    }
    public static void displayComputers(){
        inventory.displayBuiltComputers();
    }
    public static void buildComputers(){

    }
    public static void manageUsers(){

    }
}




