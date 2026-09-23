package di.example.part2;

import di.example.part1.OperatingSystem;
import di.example.part1.Phone;

public class IPhone implements Phone {

    private final OperatingSystem os;

    public IPhone(OperatingSystem os) {
        this.os = os;
    }

    @Override
    public void turnOn() {
        os.boot();
        IO.println("iPhone turning on...");
    }
}