package demo;

import demo.test.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        String testClassName = "Car";
        String testClassPath = "demo.test.";

        try {
            Class<?> carClass = Class.forName(testClassPath + testClassName);
//
//            int index = 1;
//            for (Constructor<?> constructor  : aClass.getConstructors()) {
//                Class<?>[] parameterTypes = constructor.getParameterTypes();
//                System.out.println(String.format("Constructor: %d, with %d parameters", index++, constructor.getParameterCount()));
//                for (Class<?> parameterType : parameterTypes) {
//                    System.out.println(parameterType.getName());
//                }
//            }

            Constructor<?> declaredConstructor = carClass.getDeclaredConstructor(String.class, Double.class);
            Car car1 = (Car) declaredConstructor.newInstance("Opel", 300.0);

            Car car2 = new Car("Mercedes - Benz", 300L, 450000.0);

            Field[] carFields = Car.class.getDeclaredFields();

            for (Field carField : carFields) {
                carField.setAccessible(true);
//                System.out.println(carField.get(car1));
//                System.out.println(carField.get(car2));
            }

            Field model = Car.class.getDeclaredField("model");
            model.setAccessible(true);
            model.set(car1, "Nisan");
            model.set(car2, "Trabant");

//            System.out.println(car1.getModel());
//            System.out.println(car2.getModel());

            Method[] methods = car1.getClass().getMethods();

            for (Method method : methods) {
//                System.out.println(method.getName());
            }

            Method makeSound = car1.getClass().getDeclaredMethod("makeSound", String[].class);
            makeSound.setAccessible(true);

            String[] sounds = { "Pur pur pur" };
            String[] sounds2 = {};
            Object[] arguments = { sounds };
            Object[] arguments2 = { sounds2 };
            String pur_pur_pur = (String) makeSound.invoke(car1, arguments);
            String invoke = (String) makeSound.invoke(car1, arguments2);

//            System.out.println(pur_pur_pur);
//            System.out.println(invoke);

            Method testStaticMethod = Car.class.getDeclaredMethod("testStaticMethod", String.class);
            testStaticMethod.setAccessible(true);

            testStaticMethod.invoke(null, "Test static method invocation.");
        } catch (ClassNotFoundException |
                NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException |
                NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
