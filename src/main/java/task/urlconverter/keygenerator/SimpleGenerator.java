package task.urlconverter.keygenerator;

import java.util.Random;

public class SimpleGenerator {

    private static int KEY_LENGTH = 6;

    private static char[] AVAILABLE_CHARACTERS = "acbdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public static String getRandomKey() {
        Random random = new Random(System.nanoTime());
        StringBuilder shortUrl = new StringBuilder();
        for (int i = 0; i < KEY_LENGTH; i++) {
            char temp = AVAILABLE_CHARACTERS[random.nextInt(AVAILABLE_CHARACTERS.length)];
            shortUrl.append(temp);
        }
        return shortUrl.toString();
    }
}
