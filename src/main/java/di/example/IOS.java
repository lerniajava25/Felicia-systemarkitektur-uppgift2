package di.example;

public class IOS implements OperatingSystem {
    @Override
    public void boot() {
        IO.println("iOS booting...");
    }
}
