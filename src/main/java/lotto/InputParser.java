package lotto;

import static lotto.Constants.ERROR_HEADER;

public class InputParser {
    public int parse(String priceCandidate) {
        validate(priceCandidate);
        return Integer.parseInt(priceCandidate);
    }

    private void validate(String priceCandidate) {
        try {
            int price = Integer.parseInt(priceCandidate);
            if (price % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_HEADER + "구입 금액은 1000원 단위여야 합니다.");
            }
            if (price <= 0 || price > 100000) {
                throw new IllegalArgumentException(ERROR_HEADER + "구입 금액은 1000원 이상 10만원 이하여야 합니다.");
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_HEADER + "구입 금액의 형식이 올바르지 않습니다.");
        }
    }
}
