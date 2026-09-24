package di.example;

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