package di.example.part2;

/** PhoneShop = Top level class.
PhoneShop needs a phone, and
a Phone needs an OperatingSystem.*/

public class PhoneShop {

    private final Phone phone;

    public PhoneShop(Phone phone) {
        this.phone = phone;
    }

    public void sellPhone() {
        IO.println("Selling phone...");
        phone.turnOn();
    }
}
