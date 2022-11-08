package intro_to_java.intro_to_java_excersize;

import java.util.Scanner;

public class ConvertNumberToText {
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
            switch (dozens) {
                case 2:
                    numberInText += " and twenty";
                    break;
                case 3:
                    numberInText += " and thirty";
                    break;
                case 4:
                    numberInText += " and forty";
                    break;
                case 5:
                    numberInText += " and fifty";
                    break;
                case 6:
                    numberInText += " and sixty";
                    break;
                case 7:
                    numberInText += " and seventy";
                    break;
                case 8:
                    numberInText += " and eighty";
                    break;
                case 9:
                    numberInText += " and ninety";
                    break;
            }
            if (dozens == 1) {
                switch (units) {
                    case 0:
                        numberInText += " and ten";
                        break;
                    case 1:
                        numberInText += " and eleven";
                        break;
                    case 2:
                        numberInText += " and twelve";
                        break;
                    case 3:
                        numberInText += " and thirteen";
                        break;
                    case 4:
                        numberInText += " and fourteen";
                        break;
                    case 5:
                        numberInText += " and fifteen";
                        break;
                    case 6:
                        numberInText += " and sixteen";
                        break;
                    case 7:
                        numberInText += " and seventeen";
                        break;
                    case 8:
                        numberInText += " and eighteen";
                        break;
                    case 9:
                        numberInText += " and nineteen";
                        break;
                }
            } else {
                switch (units) {
                    case 1:
                        numberInText += " and one";
                        break;
                    case 2:
                        numberInText += " and two";
                        break;
                    case 3:
                        numberInText += " and three";
                        break;
                    case 4:
                        numberInText += " and four";
                        break;
                    case 5:
                        numberInText += " and five";
                        break;
                    case 6:
                        numberInText += " and six";
                        break;
                    case 7:
                        numberInText += " and seven";
                        break;
                    case 8:
                        numberInText += " and eight";
                        break;
                    case 9:
                        numberInText += " and nine";
                        break;
                }
            }
        } else {
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
            }
            if (dozens == 1) {
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
                        numberInText += " and seventeen";
                        break;
                    case 8:
                        numberInText += " eighteen";
                        break;
                    case 9:
                        numberInText += "nineteen";
                        break;
                }
            }
                else {
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
            }
        System.out.println(numberInText);
}
}
