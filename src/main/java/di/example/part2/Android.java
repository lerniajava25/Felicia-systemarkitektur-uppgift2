package di.example.part2;

import di.example.part1.OperatingSystem;

public class Android implements OperatingSystem {
    @Override
    public void boot() {
        IO.println("Android booting...");
    }
}
