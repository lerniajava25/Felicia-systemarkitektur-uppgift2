package di.example;

public class Samsung implements Phone {

    private final OperatingSystem os;

    public Samsung(OperatingSystem os) {
        this.os = os;
    }

    @Override
    public void turnOn() {
        os.boot();
        IO.println("Samsung powering on...");
    }
}
