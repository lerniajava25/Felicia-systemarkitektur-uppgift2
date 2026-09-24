package di.example;

public class Android implements OperatingSystem {
    @Override
    public void boot() {
        IO.println("Android booting...");
    }
}
