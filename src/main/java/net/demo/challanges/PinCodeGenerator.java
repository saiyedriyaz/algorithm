package net.demo.challanges;

import java.util.ArrayList;
import java.util.List;

public class PinCodeGenerator {

    public static void main(String[] args) throws Exception {
        PinCodeGenerator movio2 = new PinCodeGenerator();
        List<String> data = movio2.getFourDigitCode(1900);
        for (String datum : data) {
            System.err.println(datum);
        }
    }

    public List<String> getFourDigitCode(int beginWith) throws Exception {
        if (beginWith < 1000 || beginWith > 9999) {
            throw new Exception("Invalid Input");
        }
        List<String> twoDigitList = new ArrayList<>();
        for (int i = beginWith; i <= 9999; i++) {
            int digitOne = ((i) / (1000)) % 10;
            int digitTwo = ((i) / (100)) % 10;
            int digitThree = ((i) / (10)) % 10;
            int digitFour = i % 10;

            if (isValidTwoDigits(digitOne, digitTwo) && isValidTwoDigits(digitTwo, digitThree)
                    && isValidTwoDigits(digitThree, digitFour) && isValidTwoDigits(digitOne, digitTwo)
                    && isValidThreeDigits(digitOne, digitTwo, digitThree)
                    && isValidThreeDigits(digitTwo, digitThree, digitFour)) {

                // System.err.println(digitOne + ":" + digitTwo + ":" + digitThree + ":" + digitFour);
                System.err.println(digitOne + "" + digitTwo + "" + digitThree + "" + digitFour);
            }
        }
        return twoDigitList;
    }

    private boolean isValidTwoDigits(int digitOne, int digitTwo) {
        boolean isValid = true;
        if (digitOne == digitTwo) {
            isValid = false;
        }
        return isValid;
    }

    private boolean isValidThreeDigits(int digitOne, int digitTwo, int digitThree) {
        boolean isValid = true;
        if (digitTwo - digitOne == 1 && digitThree - digitTwo == 1) {

            isValid = false;
        }
        return isValid;
    }
}
