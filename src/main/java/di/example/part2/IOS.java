package di.example.part2;

import di.example.part1.OperatingSystem;

public class IOS implements OperatingSystem {
    @Override
    public void boot() {
        IO.println("iOS booting...");
    }
}
