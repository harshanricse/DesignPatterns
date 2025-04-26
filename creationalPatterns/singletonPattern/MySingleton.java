package singletonPattern;

public class MySingleton {
	private static MySingleton instance = null;
    private MySingleton() {}
    public static MySingleton getInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }
    public static void main(String[] args) {
        // Your main code can go here (if applicable)
    }
}
