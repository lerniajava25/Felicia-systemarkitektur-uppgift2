package di.example.part2;

import di.example.part1.OperatingSystem;
import di.example.part1.Phone;

public class Samsung implements Phone {

    private final di.example.part1.OperatingSystem os;

    public Samsung(OperatingSystem os) {
        this.os = os;
    }

    @Override
    public void turnOn() {
        os.boot();
        IO.println("Samsung powering on...");
    }
}
