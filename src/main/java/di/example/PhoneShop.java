package di.example;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

/** PhoneShop = Top level class.
PhoneShop needs a phone, and
a Phone needs an OperatingSystem.*/

@Dependent
public class PhoneShop {

    private final Phone phone;

    @Inject
    public PhoneShop(Phone phone) {
        this.phone = phone;
    }

    public void sellPhone() {
        IO.println("Selling phone...");
        phone.turnOn();
    }
}
