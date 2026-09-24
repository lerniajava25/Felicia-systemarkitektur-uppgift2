package di.example;

public class Main {
    static void main() {
        //Part 1 - Manuel injection
        di.example.OperatingSystem iOS = new di.example.IOS();
        di.example.OperatingSystem Android = new Android();

        IO.println("Part 1:");
        di.example.Phone Iphone = new di.example.IPhone(iOS);
        Iphone.turnOn();

        di.example.Phone mySamsung = new Samsung(Android);
        mySamsung.turnOn();

        di.example.Phone fakeIPhone = new di.example.IPhone(Android);
        fakeIPhone.turnOn();
        IO.println("___");

        //Part 2 - DI Container
        Container container = new Container();
        IO.println("Part 2:");
        container.bind(OperatingSystem.class, IOS.class);
        container.bind(Phone.class, IPhone.class);

        PhoneShop shop = container.resolve(PhoneShop.class);

        shop.sellPhone();
    }

    }

