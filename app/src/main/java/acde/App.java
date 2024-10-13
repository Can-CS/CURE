package acde;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void count() {
        System.out.println("Bu bir duplike");
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
