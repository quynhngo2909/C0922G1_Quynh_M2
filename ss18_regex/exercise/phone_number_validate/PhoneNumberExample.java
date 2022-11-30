package ss18_regex.exercise.phone_number_validate;

import java.util.regex.Pattern;

public class PhoneNumberExample {
    private static final String PHONE_NUMBER_REGEX = "^.(\\d{2}.)-.(0\\d{9}.)$";

    public PhoneNumberExample() {
    }

    public boolean validPhoneNumber(String regex) {
        return Pattern.compile(PHONE_NUMBER_REGEX).matcher(regex).matches();
    }
}
