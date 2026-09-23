package di.example.part1;

public class Android implements OperatingSystem {
    @Override
    public void boot() {
        IO.println("Android booting...");
    }
}
