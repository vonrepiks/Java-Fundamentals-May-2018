import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        String resourceFolder = "C:\\SoftUni\\Java-Fundamentals-May-2018\\JavaAdvanced\\Exercises\\FilesAndStreams\\resources\\";

        String serializableObjectPath = resourceFolder + "object.ser";

        FootballPlayer player = new FootballPlayer("Cristiano Ronaldo", 32, "Real Madrid", 12);

        try (FileOutputStream fos = new FileOutputStream(serializableObjectPath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(player);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(serializableObjectPath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            FootballPlayer player1 = (FootballPlayer) ois.readObject();
            System.out.println(player1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
