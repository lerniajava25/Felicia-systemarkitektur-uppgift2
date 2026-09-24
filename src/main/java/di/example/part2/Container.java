package di.example.part2;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Container {

    private final Map<Class<?>, Class<?>> bindings = new HashMap<>();

    public <T> void bind(Class<T> type, Class<? extends T> implementation) {
        bindings.put(type, implementation);
    }

    public <T> T resolve(Class<T> type) {
        Class<?> implClass = bindings.getOrDefault(type, type);
        Constructor<?>[] constructors = implClass.getConstructors();

        if (constructors.length == 0) {
            throw new IllegalStateException(
                    "No public constructor available");
        }
        Constructor<?> constructor = constructors[0];

        Class<?>[] paramTypes = constructor.getParameterTypes();
        Object[] dependencies = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            dependencies[i] = resolve(paramTypes[i]);
        }

        try {
            return type.cast(constructor.newInstance(dependencies));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Could not instantiate " + implClass, e);
        }
    }
}