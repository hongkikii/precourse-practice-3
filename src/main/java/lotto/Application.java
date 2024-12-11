package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        InputParser inputParser = new InputParser();

        // TODO: 빈 문자열일 경우 예외 처리하는지 검증
        Integer price = null;
        while (true) {
            view.showPriceRequest();
            String priceCandidate = Console.readLine();
            try {
                // TODO: Price 클래스로 분리
                price = inputParser.parse(priceCandidate);
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
    }
}
