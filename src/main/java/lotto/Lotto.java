package lotto;

import static lotto.Constants.ERROR_HEADER;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_HEADER + "로또 번호가 중복되어서는 안 됩니다.");
        }
        // TODO: 로또 번호 범위 예외 처리
    }

    // TODO: 추가 기능 구현
    public List<Integer> getSortedNumbers() {
        return this.numbers.stream()
                .sorted()
                .toList();
    }
}
