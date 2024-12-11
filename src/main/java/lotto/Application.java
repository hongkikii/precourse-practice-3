package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View();
        InputParser inputParser = new InputParser();

        Integer price = null;
        while (true) {
            view.showPriceRequest();
            String priceCandidate = Console.readLine();
            try {
                price = inputParser.parse(priceCandidate);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        IssuedLotto issuedLotto = new IssuedLotto(price);

    }
}
