package di.example;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class IPhone implements Phone {

    private final OperatingSystem os;

    @Inject
    public IPhone(OperatingSystem os) {
        this.os = os;
    }

    @Override
    public void turnOn() {
        os.boot();
        IO.println("iPhone turning on...");
    }
}