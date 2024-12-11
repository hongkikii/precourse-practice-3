package lotto;

import static lotto.Constants.ERROR_HEADER;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumber {
    private final Lotto winningNumber;

    public WinningNumber(String winningNumberCandidate) {
        validate(winningNumberCandidate);
        String[] splitWinningNumberCandidate = split(winningNumberCandidate);
        List<Integer> numbers = parse(splitWinningNumberCandidate);
        this.winningNumber = new Lotto(numbers);
    }

    public boolean isContained(int number) {
        return winningNumber.getSortedNumbers().contains(number);
    }

    private void validate(String winningNumberCandidate) {
        if (Pattern.matches("[0-9,]", winningNumberCandidate)) {
            throw new IllegalArgumentException(ERROR_HEADER + "당첨 번호는 숫자와 쉼표만 입력되어야 합니다.");
        }
        if (Pattern.matches("[0-9],{5}", winningNumberCandidate)) {
            throw new IllegalArgumentException(ERROR_HEADER + "쉼표는 당첨 번호 사이에만 입력되어야 합니다.");
        }
        if (winningNumberCandidate.endsWith(",")) {
            throw new IllegalArgumentException(ERROR_HEADER + "쉼표는 당첨 번호 사이에만 입력되어야 합니다.");
        }
        String[] splitWinningNumberCandidate = split(winningNumberCandidate);
        for (String numberCandidate : splitWinningNumberCandidate) {
            parse(numberCandidate);
        }
    }

    private String[] split(String winningNumberCandidate) {
        return winningNumberCandidate.split(",");
    }

    private List<Integer> parse(String[] splitWinningNumberCandidate) {
        List<Integer> result = new ArrayList<>();
        for(String number : splitWinningNumberCandidate) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }

    private void parse(String numberCandidate) {
        try {
            int number = Integer.parseInt(numberCandidate);
            if (number < 1 || number > 45) {
                throw new NumberFormatException();
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_HEADER + "당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}
