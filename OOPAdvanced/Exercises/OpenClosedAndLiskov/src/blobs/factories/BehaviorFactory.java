package blobs.factories;

import blobs.interfaces.Behavior;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class BehaviorFactory {

    private static final String BEHAVIOR_PATH = "blobs.models.behaviors.";

    private BehaviorFactory() {
    }

    public static Behavior create(String behaviorType) {
        Behavior behavior = null;
        try {
            Class<?> behaviorClass =
                    Class.forName(
                            BEHAVIOR_PATH +
                                    behaviorType);

            Constructor<?> declaredConstructor =
                    behaviorClass
                            .getDeclaredConstructor();

            return (Behavior) declaredConstructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            return behavior;
        }
    }
}
