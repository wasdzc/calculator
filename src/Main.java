import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static String calc(String input) throws Exception {
        String[] string = input.split(" ");
        if (string.length != 3) {
            throw new Exception();
        }

        try {
            int n1 = Integer.parseInt(string[0]);
            int n2 = Integer.parseInt(string[2]);
            int result = calculateArabic(n1, n2, string[1]);
            return String.valueOf(result);
        } catch (Exception e1) {
            try {
                int n1 = romanToArabic(string[0]);
                int n2 = romanToArabic(string[2]);
                int result = calculateArabic(n1, n2, string[1]);
                return arabicToRoman(result);
            } catch (Exception e2) {
                throw new Exception();
            }
        }
    }

    static int romanToArabic(String number) throws Exception {

        int arabicNumber = Arrays.binarySearch(romanNumbers, number) + 1;
        if (arabicNumber < 1) {
            throw new Exception();
        } else {
            return arabicNumber;
        }
    }

    static String arabicToRoman(int number) throws Exception {
        String romanNumber;
        try {
            romanNumber = romanNumbers[number - 1];
            return romanNumber;
        } catch (Exception e) {
            throw new Exception();
        }
    }

    static int calculateArabic(int n1, int n2, String operation) throws Exception {
        if (n1 > 10 || n1 < 1 || n2 > 10 || n2 < 1) {
            throw new Exception();
        }
        switch(operation) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            default:
                throw new Exception();
        }
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner in = new Scanner(System.in);
            String result = calc(in.nextLine());
            System.out.println(result);
        }
    }

}
