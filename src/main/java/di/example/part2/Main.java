package di.example.part2;

public class Main {
    static void main() {
        Container container = new Container();

        container.bind(OperatingSystem.class, IOS.class);
        container.bind(Phone.class, IPhone.class);

        PhoneShop shop = container.resolve(PhoneShop.class);

        shop.sellPhone();
    }

    }

