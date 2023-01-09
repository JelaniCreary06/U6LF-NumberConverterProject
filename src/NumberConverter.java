public class NumberConverter {
    int digits[], base, number;

    public NumberConverter(int number, int base) {
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i,i+1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
        this.number = number;
    }

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }

    public int[] convertToDecimal() {

        return null;
    }

    public int[] convertToBinary() {
        int binaryArray[], number = this.number;
        boolean converterRunning = true;
        String binaryReturnString = "";

        do {
           int oldNumber = number;
           number /= 2;

           if (number * 2 + 1 == oldNumber) binaryReturnString += 1;
           else binaryReturnString += 0;

           if (number == 0) converterRunning = false;
        } while (converterRunning);

        String tempString = "";
        for (int i = binaryReturnString.length() - 1; i > -1; i--) {
            tempString += binaryReturnString.charAt(i)+"";
        }

        binaryReturnString = tempString;

        binaryArray = new int[binaryReturnString.length()];

        for (int i = binaryReturnString.length() - 1; i > -1; i--) {
            binaryArray[i] = Integer.parseInt(binaryReturnString.charAt(i)+"");
        }

        return binaryArray;
    }

    public int[] convertToOctal() {
        int octalArray[], number = this.number;
        boolean converterRunning = true;
        String octalReturnString = "";

        do {
            octalReturnString += (number % 8);
            number /= 8;

            if (number == 0) converterRunning = false;
        } while (converterRunning);

        String tempString = "";

        for (int i = octalReturnString.length() - 1; i > -1; i--) {
            tempString += octalReturnString.charAt(i)+"";
        }

        octalReturnString = tempString;

        octalArray = new int[octalReturnString.length()];

        for (int i = 0; i < octalReturnString.length(); i++) {
            octalArray[i] = octalReturnString.charAt(i);
        }

        return octalArray;
    }
}
