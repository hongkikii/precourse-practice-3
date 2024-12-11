package lotto;

import static lotto.Constants.ERROR_HEADER;

public class Price {
    private final int price;

    public Price(String priceCandidate) {
        validate(priceCandidate);
        this.price = parse(priceCandidate);
    }

    public int get() {
        return this.price;
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

    private int parse(String priceCandidate) {
        return Integer.parseInt(priceCandidate);
    }
}
