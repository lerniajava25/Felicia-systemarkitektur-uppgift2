package di.example.part2;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Reflection-based DI container */
public class Container {

    private final Map<Class<?>, Class<?>> bindings = new HashMap<>();

    /** Types currently being resolved, used to detect circular dependencies. */
    private final Set<Class<?>> resolutionPath = new HashSet<>();

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
        Class<?> implClass = bindings.getOrDefault(type, type);

        if (!resolutionPath.add(implClass)) {
            throw new IllegalStateException("Circular dependency detected");
        }
        try {
            Constructor<?>[] constructors = implClass.getConstructors();

            if (constructors.length == 0) {
                throw new IllegalStateException(
                        "No public constructor available for " + implClass.getName());
            }

            if (constructors.length > 1) {
                throw new IllegalStateException
                        ("Exactly one public constructor expected, found: " + implClass.getName());
            }

            Constructor<?> constructor = constructors[0];

            Class<?>[] paramTypes = constructor.getParameterTypes();
            Object[] dependencies = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                dependencies[i] = resolve(paramTypes[i]);
            }
                return type.cast(constructor.newInstance(dependencies));
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Could not instantiate " + implClass, e);
            } finally {
                resolutionPath.remove(implClass);
            }
        }
    }

