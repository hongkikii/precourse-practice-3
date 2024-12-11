package lotto;

import java.util.List;

public class View {
    public void showPriceRequest() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void show(int issuedLottoCount) {
        System.out.println();
        System.out.println(issuedLottoCount + "개를 구매했습니다.");
    }

    public void show(List<Lotto> issuedLottos) {
        for(Lotto lotto : issuedLottos) {
            System.out.println(lotto.getSortedNumbers());
        }
    }
}
