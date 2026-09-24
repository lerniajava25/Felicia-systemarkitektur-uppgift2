package di.example.part2;

public class IOS implements OperatingSystem {
    @Override
    public void boot() {
        IO.println("iOS booting...");
    }
}
