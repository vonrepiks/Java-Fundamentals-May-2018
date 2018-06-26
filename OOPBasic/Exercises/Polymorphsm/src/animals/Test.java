package animals;

public class Test {
    public static void main(String[] args) {
//
//        app.Person student = new app.Student();
//
//        System.out.println(student.getClass().getSuperclass().getSimpleName());
//        System.out.println(student.getClass().getSuperclass().getSimpleName().equals("app.Person"));

        Animal dog = new Dog();
        Dog dog1 = new Dog();
        Animal cat = new Cat();
        Mammal cat1 = new Cat();
//
//        printSound(dog);
//        printSound(cat);
//        printSound(dog1);
//        printSound(cat1);

        ((Dog)dog).getName();
        dog.getSound();
//        dog1.getSound();
//        dog.getSound();
    }

    private static void printSound(Dog animal) {
        animal.getSound();
    }
}
