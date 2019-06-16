package net.demo.challanges;

import java.util.ArrayList;
import java.util.List;

public class PinCodeGeneratorSolutionB {

    public static void main(String[] args) {
        PinCodeGeneratorSolutionB movio2 = new PinCodeGeneratorSolutionB();
        List<String> data = movio2.getFourDigitCode();
        for (String datum : data) {
            System.err.println(datum);
        }
    }

    private List<String> getFourDigitCode() {
        List<String> twoDigitListOne = getTwoDigitCode();
        List<String> twoDigitListTwo = getTwoDigitCode();
        List<String> fourDigitList = new ArrayList<>();

        for (String twoDigitCodeOne : twoDigitListOne) {

            for (String twoDigitCodeTwo : twoDigitListTwo) {
                fourDigitList.add(twoDigitCodeOne + twoDigitCodeTwo);
            }
        }
        return fourDigitList;
    }

    private List<String> getTwoDigitCode() {
        List<String> twoDigitList = new ArrayList<>();
        for (int i = 10; i <= 99; i++) {
            int digitOne = i / 10;
            int digitTwo = i % 10;
            if (digitOne - digitTwo != 0) {
                twoDigitList.add(digitOne + "" + digitTwo);
            }
        }
        return twoDigitList;
    }
}
