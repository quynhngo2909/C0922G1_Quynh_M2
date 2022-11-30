package ss18_regex.exercise.phone_number_validate;

public class PhoneNumberTest {
    private static PhoneNumberExample phoneNumberExample;
    public static final String validPhoneNumber = "(84)-(0978489648)";
    public static final String invalidPhoneNumber = "(a8)-(22222222)";

    public static void main(String[] args) {
        phoneNumberExample = new PhoneNumberExample();
        boolean isValid = phoneNumberExample.validPhoneNumber(validPhoneNumber);
        System.out.println(validPhoneNumber + " is valid " + isValid );

        boolean isValid2 = phoneNumberExample.validPhoneNumber(invalidPhoneNumber);
        System.out.println(invalidPhoneNumber + " is valid " + isValid2 );
    }
}
