package lotto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Result {
    private final IssuedLotto issuedLotto;
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;
    private final Map<Prize, Integer> result;

    public Result(IssuedLotto issuedLotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.issuedLotto = issuedLotto;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.result = new LinkedHashMap<>();
        initialize();
    }

    private void initialize() {
        result.put(Prize.FIFTH, 0);
        result.put(Prize.FOURTH, 0);
        result.put(Prize.THIRD, 0);
        result.put(Prize.SECOND, 0);
        result.put(Prize.FIRST, 0);

        for (Lotto issuedLotto : issuedLotto.getIssuedLottos()) {
            List<Integer> issuedLottoNumbers = issuedLotto.getSortedNumbers();
            List<Integer> winningNumbers = winningNumber.getWinningNumber();
            List<Integer> matchNumbers = issuedLottoNumbers.stream()
                    .filter(o -> winningNumbers.stream()
                            .anyMatch(Predicate.isEqual(o)))
                            .toList();

            if (matchNumbers.size() == Prize.FIRST.getCount()) {
                result.put(Prize.FIRST, result.get(Prize.FIRST) + 1);
                break;
            }
            if (matchNumbers.size() == Prize.SECOND.getCount()) {
                if(issuedLottoNumbers.contains(bonusNumber.getBonusNumber())) {
                    result.put(Prize.SECOND, result.get(Prize.SECOND) + 1);
                    break;
                }
                result.put(Prize.THIRD, result.get(Prize.THIRD) + 1);
                break;
            }
            if (matchNumbers.size() == Prize.FOURTH.getCount()) {
                result.put(Prize.FOURTH, result.get(Prize.FOURTH) + 1);
                break;
            }
            if (matchNumbers.size() == Prize.FIFTH.getCount()) {
                result.put(Prize.FIFTH, result.get(Prize.FIFTH) + 1);
                break;
            }
        }
    }

    public Map<Prize, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public String getReturnRate(int purchasePrice) {
        double returnRate = (double) (getProfitAmount() / purchasePrice) / 100;
        return String.format("%.1f", returnRate);
    }

    private long getProfitAmount() {
        long profitAmount = 0;
        for(Prize prize : result.keySet()) {
            profitAmount += ((long) prize.getPrice() * result.get(prize));
        }
        return profitAmount;
    }
}
