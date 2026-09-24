package di.example.part2;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Reflection-based DI container */
public class Container {

    private final Map<Class<?>, Class<?>> bindings = new HashMap<>();

    public <T> void bind(Class<T> type, Class<? extends T> implementation) {
        bindings.put(type, implementation);
    }

    /**
     * Builds {@code type}, resolving its constructor dependencies recursively.
     *
     * @param type the class or interface to build
     * @return a fully constructed instance
     * @throws IllegalStateException on missing/ambiguous constructors or a dependency cycle
     */
    public <T> T resolve(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        return resolve(type, new HashSet<>());
    }

    private <T> T resolve(Class<T> type, Set<Class<?>> resolutionPath) {
        Class<?> implClass = bindings.getOrDefault(type, type);

        if (!resolutionPath.add(implClass)) {
            throw new IllegalStateException("Circular dependency detected for: " + implClass.getName());
        }
        try {
            Constructor<?> constructor = findInjectableConstructor(implClass);

            Class<?>[] paramTypes = constructor.getParameterTypes();
            Object[] dependencies = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                dependencies[i] = resolve(paramTypes[i], resolutionPath);
            }

            return type.cast(constructor.newInstance(dependencies));
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Could not instantiate " + implClass.getName(), e);
        } finally {
            resolutionPath.remove(implClass);
        }
    }

    private Constructor<?> findInjectableConstructor(Class<?> implClass) {
        Constructor<?>[] constructors = implClass.getConstructors();

        if (constructors.length == 0) {
            throw new IllegalStateException(
                    "No public constructor available for " + implClass.getName());
        }
        if (constructors.length > 1) {
            throw new IllegalStateException
                    ("Exactly one public constructor expected for: "
                            + implClass.getName() + ", but found " + constructors.length);
        }
        return constructors[0];
    }
}
