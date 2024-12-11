package lotto;

public enum Prize {
    FIRST("6개 일치 (2,000,000,000원) - ", 2_000_000_000, 6),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30_000_000, 5),
    THIRD("5개 일치 (1,500,000원) - ", 1_500_000, 5),
    FOURTH("4개 일치 (50,000원) - ", 50_000, 4),
    FIFTH("3개 일치 (5,000원) - ", 5_000, 3);

    private final String resultInfo;
    private final int price;
    private final int count;

    Prize(String resultInfo, int price, int count) {
        this.resultInfo = resultInfo;
        this.price = price;
        this.count = count;
    }

    public static Prize getBy(int count) {
        if(count == FIRST.count) {
            return FIRST;
        }
        if(count == THIRD.count) {
            return THIRD;
        }
        if(count == FOURTH.count) {
            return FOURTH;
        }
        if(count == FIFTH.count) {
            return FIFTH;
        }
        return null;
    }

    public String getResultInfo() {
        return this.resultInfo;
    }

    public int getPrice() {
        return this.price;
    }

}
