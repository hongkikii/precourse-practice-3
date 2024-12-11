package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static View view = new View();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Price price = getPrice();
        IssuedLotto issuedLotto = new IssuedLotto(price);
        view.show(issuedLotto);

        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);

        Result result = new Result(issuedLotto, winningNumber, bonusNumber, price);
        view.show(result);
    }

    private static Price getPrice() {
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
        return price;
    }

    private static WinningNumber getWinningNumber() {
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
        return winningNumber;
    }

    private static BonusNumber getBonusNumber(WinningNumber winningNumber) {
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
        return bonusNumber;
    }
}
