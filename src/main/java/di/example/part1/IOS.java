package di.example.part1;

public class IOS implements OperatingSystem {
    @Override
    public void boot() {
        IO.println("iOS booting...");
    }
}
