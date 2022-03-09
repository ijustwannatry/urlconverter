package task.urlconverter.validator;

import task.urlconverter.exception.NotValidUrlException;

public class UrlValidator {

    private static final String REGEX = "(http://|https://).+\\..*";

    public static boolean isNotValid(String url) {
        return url.isBlank() || !url.matches(REGEX);
    }

    public static void validate(String url) {
        if (isNotValid(url)) {
            throw new NotValidUrlException("Invalid URL");
        }
    }
}
