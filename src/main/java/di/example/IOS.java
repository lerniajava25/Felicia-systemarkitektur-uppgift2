package di.example;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class IOS implements OperatingSystem {
    @Override
    public void boot() {
        IO.println("iOS booting...");
    }
}
