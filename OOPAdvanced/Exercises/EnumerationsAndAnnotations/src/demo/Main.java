package demo;

public class Main {
    public static void main(String[] args) {

        Test test = new Test();

        Class<? extends Test> testClass = Test.class;

        if (testClass.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation annotation = testClass.getAnnotation(MyAnnotation.class);

            System.out.println(annotation.value());
        }
    }
}
