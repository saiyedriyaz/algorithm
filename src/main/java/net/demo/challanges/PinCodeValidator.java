package net.demo.challanges;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.demo.exception.ValidationException;

public class PinCodeValidator {

    private static final PinCodeValidator INSTANCE = new PinCodeValidator();

    private final int BATCH_SIZE = 1000;

    private PinCodeValidator() {
    }

    public static void main(String[] args) throws ValidationException {
        PinCodeValidator movio2 = getInstance();
        List<String> data = movio2.getPINCodeBatch();//282,1000);

        System.err.println("data=" + data);
        System.err.println("size=" + data.size());
    }

    public static PinCodeValidator getInstance() {
        return INSTANCE;
    }

    /**
     * This method is used to generate the single batch of FOUR digit pin code. Pin code will be generated such a way
     * that 1000 < PIN CODE < 9999. This method is guaranteed to return the batch with 1000 pin codes.
     *
     * @return
     * @throws ValidationException
     */
    public List<String> getPINCodeBatch() throws ValidationException {
        return getPINCodeBatch(getRandomStartWith(), BATCH_SIZE);
    }

    /**
     * This method is used to generate the single batch of FOUR digit pin code which MAY start with specified number and
     * has a batch size of X. X is specified with batchSize. Pin code will be generated such a way that 1000 < PIN CODE
     * < 9999. This method is guaranteed to return the batch with specified size if specified batch size is not more
     * than 1000.
     *
     * @param beginWith
     * @param batchSize
     * @return
     * @throws ValidationException
     */
    public List<String> getPINCodeBatch(int beginWith, int batchSize) throws ValidationException {
        if (beginWith < 100 || beginWith > 9999 || batchSize > 1000) {
            throw new ValidationException("Invalid Input");
        }
        List<String> codeList = new ArrayList<>();
        for (int i = beginWith; i <= 9999; i++) {
            int digitOne = ((i) / (1000)) % 10;
            int digitTwo = ((i) / (100)) % 10;
            int digitThree = ((i) / (10)) % 10;
            int digitFour = i % 10;

            if (isValidTwoDigits(digitOne, digitTwo) && isValidTwoDigits(digitTwo, digitThree)
                    && isValidTwoDigits(digitThree, digitFour) && isValidTwoDigits(digitOne, digitTwo)
                    && isValidThreeDigits(digitOne, digitTwo, digitThree)
                    && isValidThreeDigits(digitTwo, digitThree, digitFour)) {

                String generatedCode = digitOne + "" + digitTwo + "" + digitThree + "" + digitFour;

                // we may end up in this situation if user has specified input as 9000, 100
                // and generated random number also around 9000.
                if (!codeList.contains(generatedCode)) {
                    codeList.add(generatedCode);
                }

                if (codeList.size() == batchSize) {
                    break;
                }
            }
        }

        // if input is say 9000 and batch size is 1000, in this case try again with different rando numner
        // and fill the list until we have X number of elements (X=batchSize).
        if (codeList.size() < batchSize) {
            List<String> additionals = getPINCodeBatch(getRandomStartWith(), batchSize - codeList.size());
            codeList.addAll(additionals);
        }

        Collections.shuffle(codeList);
        return codeList;
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

    private int getRandomStartWith() {
        double random = (Math.random() * ((9999 - 100) + 1)) + 100;
        System.err.println(random);
        return (int) random;
    }
}
