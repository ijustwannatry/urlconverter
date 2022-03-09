package task.urlconverter.keygenerator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SimpleGeneratorTest {

    private static int KEY_LENGTH = 6;
    private static String REGEX = "[a-z0-9]{" + KEY_LENGTH +  "}";

    @Test
    public void getShortUrl_Invoke_GetCorrectKey() {
        final String key = SimpleGenerator.getRandomKey();

        assertThat(key.length()).isEqualTo(KEY_LENGTH);
        assertThat(key.matches(REGEX)).isTrue();
    }
}
