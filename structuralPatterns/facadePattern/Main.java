package facadePattern;

//Complex subsystem classes

class CPU {
	public void freeze() {
		System.out.println("CPU: Freezing...");
	}

	public void execute() {
		System.out.println("CPU: Executing...");
	}
}

class Memory {
	public void load() {
		System.out.println("Memory: Loading...");
	}
}

class HardDrive {
	public void read() {
		System.out.println("Hard Drive: Reading...");
	}
}

//Facade class

class ComputerFacade {
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;

	public ComputerFacade() {
		cpu = new CPU();
		memory = new Memory();
		hardDrive = new HardDrive();
	}

	public void start() {
		System.out.println("Starting computer...");
		cpu.freeze();
		memory.load();
		hardDrive.read();
		cpu.execute();
	}
}

//Client code

public class Main {
	public static void main(String[] args) {
		ComputerFacade computer = new ComputerFacade();
		computer.start();
	}
}