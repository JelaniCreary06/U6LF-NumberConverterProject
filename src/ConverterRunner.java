import java.util.Scanner;
import java.util.Arrays;

class ConverterRunner {
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number (2, 8 or 10): ");

        Scanner s = new Scanner(System.in);
        String choice = s.nextLine();
        int base = Integer.parseInt(choice);

        System.out.print("Enter your number: ");
        String number = s.nextLine();
        int n = Integer.parseInt(number);

        s.close();

        NumberConverter nc = new NumberConverter(n, base);
        int[] digits = nc.getDigits();
        System.out.println("\n\nDigit array: " + Arrays.toString(digits));
        System.out.println("Number: " + nc.displayOriginalNumber());
        System.out.println(Arrays.toString(nc.convertToBinary()));

        nc.convertToOctal();
    }

    public static boolean isInputValid(String number, int base) {
        boolean validInput = true;

        switch (base) {
            case 2:
                String invalidCharacters[] = {"2", "3", "4", "5", "6", "7", "8", "9"};

                for (int i = 0; i < number.length(); i++) {
                    String c = number.charAt(i)+"";

                    for (String toCompare : invalidCharacters) {
                        if (c.equals(toCompare)) validInput = false;
                    }
                }

                if (validInput && number.length() == 8) validInput = true;
                break;

            case 8:
                break;
            case 10:
                break;
        }

        return validInput;
    }
}
