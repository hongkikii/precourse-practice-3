package lotto;

import static lotto.Constants.ERROR_HEADER;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String bonusNumberCandidate, WinningNumber winningNumber) {
        validate(bonusNumberCandidate, winningNumber);
        this.bonusNumber = parse(bonusNumberCandidate);
    }

    private void validate(String bonusNumberCandidate, WinningNumber winningNumber) {
        try {
            int number = parse(bonusNumberCandidate);
            if(number < 1 || number > 45) {
                throw new NumberFormatException();
            }
            if (winningNumber.isContained(number)) {
                throw new IllegalArgumentException(ERROR_HEADER + "보너스 번호는 당첨 번호와 중복되어서는 안 됩니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_HEADER + "보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private int parse(String bonusNumberCandidate) {
        return Integer.parseInt(bonusNumberCandidate);
    }
}
