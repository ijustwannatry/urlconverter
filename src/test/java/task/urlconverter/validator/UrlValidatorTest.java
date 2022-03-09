package task.urlconverter.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import task.urlconverter.exception.NotValidUrlException;

public class UrlValidatorTest {

    @ParameterizedTest
    @MethodSource("urlValidation")
    public void isNotValid_PassUrl_GetCorrectResult(String url, boolean expected) {
        assertThat(UrlValidator.isNotValid(url)).isEqualTo(expected);
    }

    private static Stream<Arguments> urlValidation() {
        return Stream.of(Arguments.of("https://www.google.com/", false),
                         Arguments.of("http://translate.en.com/", false),
                         Arguments.of("http://spring.io/", false),
                         Arguments.of("http://text", true),
                         Arguments.of("http://.text", true),
                         Arguments.of("some string", true),
                         Arguments.of("", true));
    }

    @Test
    public void validate_PassBadUrl_GetException() {
        final String badUrl = "";
        Exception exception = assertThrows(NotValidUrlException.class,
                                           () -> UrlValidator.validate(badUrl));

        String expectedMessage = "Invalid URL";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    public void validate_PassGoodUrl_NoException() {
        final String goodUrl = "https://www.google.com/";
        assertDoesNotThrow(() -> UrlValidator.validate(goodUrl));
    }
}
