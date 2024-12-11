package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();

        Price price = null;
        while (true) {
            view.showPriceRequest();
            String priceCandidate = Console.readLine();
            try {
                price = new Price(priceCandidate);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
        IssuedLotto issuedLotto = new IssuedLotto(price);
        view.show(issuedLotto.getCount());
        view.show(issuedLotto.getIssuedLottos());

        WinningNumber winningNumber = null;
        while (true) {
            view.showWinningNumberRequest();
            String winningNumberCandidate = Console.readLine();
            try {
                winningNumber = new WinningNumber(winningNumberCandidate);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        BonusNumber bonusNumber = null;
        while (true) {
            view.showBonusNumberRequest();
            String bonusNumberCandidate = Console.readLine();
            try {
                bonusNumber = new BonusNumber(bonusNumberCandidate, winningNumber);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        Result result = new Result(issuedLotto, winningNumber, bonusNumber);
        view.showResultHeader();
        view.show(result.getResult());
        view.show(result.getReturnRate(price));
    }
}
