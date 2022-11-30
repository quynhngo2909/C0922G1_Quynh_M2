package ss18_regex.exercise.class_name_validate;


import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ClassNameExample {

   private static final String CLASS_NAME_REGEX = "^[CAP]\\d{4}[G-M]$";

   public ClassNameExample() {
   }

   public boolean validateClassName(String regex) {
      Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);
      Matcher  matcher = pattern.matcher(regex);
      return matcher.matches();
   }
}
