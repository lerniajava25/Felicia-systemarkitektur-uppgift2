package di.example.part2;

public class Android implements OperatingSystem {
    @Override
    public void boot() {
        IO.println("Android booting...");
    }
}
