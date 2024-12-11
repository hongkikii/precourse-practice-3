package lotto;

import java.util.List;
import java.util.Map;

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

    public void showWinningNumberRequest() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showBonusNumberRequest() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showResultHeader() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void show(Map<Prize, Integer> result) {
        for(Prize prize : result.keySet()) {
            System.out.println(prize.getResultInfo() + result.get(prize) + "개");
        }
    }
}
