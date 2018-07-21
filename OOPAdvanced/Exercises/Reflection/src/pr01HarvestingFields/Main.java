package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String modifier;
        while (true) {
            if ("HARVEST".equals(modifier = reader.readLine())) {
                break;
            }

            printAllFieldsByModifier(modifier);
        }
    }

    private static Field[] getAllFieldsByModifier(String modifier) {
        Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

        switch (modifier) {
            case "private":
                return Arrays.stream(declaredFields)
                        .filter(field -> Modifier.isPrivate(field.getModifiers()))
                        .toArray(Field[]::new);
            case "protected":
                return Arrays.stream(declaredFields)
                        .filter(field -> Modifier.isProtected(field.getModifiers()))
                        .toArray(Field[]::new);
            case "public":
                return Arrays.stream(declaredFields)
                        .filter(field -> Modifier.isPublic(field.getModifiers()))
                        .toArray(Field[]::new);
            case "all":
                return declaredFields;
        }

        return null;
    }

    private static void printAllFieldsByModifier(String modifier) {
        Field[] fields = getAllFieldsByModifier(modifier);

        Arrays.stream(fields)
                .forEach(field ->
                        System.out.println(String.format("%s %s %s",
                                Modifier.toString(field.getModifiers()),
                                field.getType().getSimpleName(),
                                field.getName())));
    }
}
