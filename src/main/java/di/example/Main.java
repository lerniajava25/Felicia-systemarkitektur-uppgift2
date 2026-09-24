package di.example;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class Main {
    static void main() {

        //Part 3 - Using Weld (CDI)
        //Top Class: PhoneShop -> IOS -> IPhone
        IO.println("Part 3:");
        try (SeContainer container = SeContainerInitializer.newInstance().initialize()) {
            PhoneShop shop = container.select(PhoneShop.class).get();
            shop.sellPhone();
        }
    }
    }
