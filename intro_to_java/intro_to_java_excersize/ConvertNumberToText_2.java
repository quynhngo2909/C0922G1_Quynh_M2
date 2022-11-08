package intro_to_java.intro_to_java_excersize;

import java.util.Scanner;

public class ConvertNumberToText_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight number needed to convert:");
        int weight = scanner.nextInt();
        int hundreds = weight / 100;
        int dozens = (weight - hundreds * 100) / 10;
        int units = weight - hundreds * 100 - dozens * 10;
        String numberInText = "";
        if (weight > 999 || weight < 0) {
            numberInText += "Out of ability";
        }
        if (weight == 0) {
            numberInText += "Zero";
        }
        switch (hundreds) {
            case 1:
                numberInText = numberInText + "one hundred";
                break;
            case 2:
                numberInText += "two hundred";
                break;
            case 3:
                numberInText += "three hundred";
                break;
            case 4:
                numberInText += "four hundred";
                break;
            case 5:
                numberInText += "five hundred";
                break;
            case 6:
                numberInText += "six hundred";
                break;
            case 7:
                numberInText += "seven hundred";
                break;
            case 8:
                numberInText += "eight hundred";
                break;
            case 9:
                numberInText += "nine hundred";
                break;
        }
        if (hundreds != 0) {
            numberInText += " and";
        }
        switch (dozens) {
            case 2:
                numberInText += " twenty";
                break;
            case 3:
                numberInText += " thirty";
                break;
            case 4:
                numberInText += " forty";
                break;
            case 5:
                numberInText += " fifty";
                break;
            case 6:
                numberInText += " sixty";
                break;
            case 7:
                numberInText += " seventy";
                break;
            case 8:
                numberInText += " eighty";
                break;
            case 9:
                numberInText += " ninety";
                break;
            case 1:
                switch (units) {
                    case 0:
                        numberInText += " ten";
                        break;
                    case 1:
                        numberInText += " eleven";
                        break;
                    case 2:
                        numberInText += " twelve";
                        break;
                    case 3:
                        numberInText += " thirteen";
                        break;
                    case 4:
                        numberInText += " fourteen";
                        break;
                    case 5:
                        numberInText += " fifteen";
                        break;
                    case 6:
                        numberInText += " sixteen";
                        break;
                    case 7:
                        numberInText += " seventeen";
                        break;
                    case 8:
                        numberInText += " eighteen";
                        break;
                    case 9:
                        numberInText += " nineteen";
                        break;
                }
        }
        if (dozens != 1) {
                switch (units) {
                    case 1:
                        numberInText += " one";
                        break;
                    case 2:
                        numberInText += " two";
                        break;
                    case 3:
                        numberInText += " three";
                        break;
                    case 4:
                        numberInText += " four";
                        break;
                    case 5:
                        numberInText += " five";
                        break;
                    case 6:
                        numberInText += " six";
                        break;
                    case 7:
                        numberInText += " seven";
                        break;
                    case 8:
                        numberInText += " eight";
                        break;
                    case 9:
                        numberInText += " nine";
                        break;
                }
        }
        System.out.println(numberInText);
    }
}
