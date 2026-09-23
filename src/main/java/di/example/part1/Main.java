package di.example.part1;

public class Main {
     static void main() {
        OperatingSystem iOS = new IOS();
        OperatingSystem Android = new Android();

        Phone Iphone = new IPhone(iOS);
        Iphone.turnOn();

        IO.println("___");

        Phone mySamsung = new Samsung(Android);
        mySamsung.turnOn();

        IO.println("___");

        Phone fakeIPhone = new IPhone(Android);
        fakeIPhone.turnOn();
    }
}
