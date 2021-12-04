package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class Ung_dung_doc_so_thanh_chu {
    public static void main(String[] args) {
        System.out.println("Nhap so can doc: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String result = "";
        String ones = "";
        String tens = "";
        if (num >= 0 && num < 10) {
            switch (num) {
                case 0:
                    result += "zero";
                    break;
                case 1:
                    result += "one";
                    break;
                case 2:
                    result += "two";
                    break;
                case 3:
                    result += "three";
                    break;
                case 4:
                    result += "four";
                    break;
                case 5:
                    result += "five";
                    break;
                case 6:
                    result += "six";
                    break;
                case 7:
                    result += "seven";
                    break;
                case 8:
                    result += "eight";
                    break;
                case 9:
                    result += "nine";
                    break;
            }
        } else if (num >= 10 && num < 20) {
            switch (num % 10) {
                case 0:
                    result += "ten";
                    break;
                case 1:
                    result += "eleven";
                    break;
                case 2:
                    result += "twelve";
                    break;
                case 3:
                    result = "thirdteen";
                    break;
                case 4:
                    result = "fourteen";
                    break;
                case 5:
                    result = "fiveteen";
                    break;
                case 6:
                    result = "sixteen";
                    break;
                case 7:
                    result = "seventeen";
                    break;
                case 8:
                    result = "eightteen";
                    break;
                case 9:
                    result = "nineteen";
                    break;
            }
        } else if (num >= 20 && num < 100) {
            switch (num / 10) {
                case 2:
                    tens += "twenty";
                    break;
                case 3:
                    tens += "thirty";
                    break;
                case 4:
                    tens += "forty";
                    break;
                case 5:
                    tens += "fifty";
                    break;
                case 6:
                    tens += "sixty";
                    break;
                case 7:
                    tens += "seventy";
                    break;
                case 8:
                    tens += "eighty";
                    break;
                case 9:
                    tens += "ninety";
                    break;
            }
            switch (num % 10) {
                case 1:
                    ones += "one";
                    break;
                case 2:
                    ones += "tow";
                    break;
                case 3:
                    ones += "three";
                    break;
                case 4:
                    ones += "four";
                    break;
                case 5:
                    ones += "five";
                    break;
                case 6:
                    ones += "six";
                    break;
                case 7:
                    ones += "seven";
                    break;
                case 8:
                    ones += "eight";
                    break;
                case 9:
                    ones += "nine";
                    break;
            }
            result = tens + " " + ones;
        }
        System.out.println(result);
    }
}
