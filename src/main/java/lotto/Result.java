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
    private final Price price;
    private final Map<Prize, Integer> result;

    public Result(IssuedLotto issuedLotto, WinningNumber winningNumber, BonusNumber bonusNumber, Price price) {
        this.issuedLotto = issuedLotto;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.price = price;
        this.result = new LinkedHashMap<>();
        initialize();
    }

    public Map<Prize, Integer> get() {
        return Collections.unmodifiableMap(result);
    }

    public String getReturnRate() {
        double returnRate = ((double) getProfitAmount() / price.get()) * 100;
        return String.format("%.1f", returnRate);
    }

    private void initialize() {
        setBaseValue();
        for (Lotto issuedLotto : issuedLotto.get()) {
            setBy(issuedLotto);
        }
    }

    private void setBaseValue() {
        result.put(Prize.FIFTH, 0);
        result.put(Prize.FOURTH, 0);
        result.put(Prize.THIRD, 0);
        result.put(Prize.SECOND, 0);
        result.put(Prize.FIRST, 0);
    }

    private void setBy(Lotto issuedLotto) {
        List<Integer> issuedLottoNumbers = issuedLotto.getSorted();
        List<Integer> matchNumbers = getMatchNumbersWith(issuedLottoNumbers);

        int matchingCount = matchNumbers.size();
        Prize prize = Prize.getBy(matchingCount);
        if(prize == Prize.THIRD) {
            if (issuedLottoNumbers.contains(bonusNumber.get())) {
                prize = Prize.SECOND;
            }
        }
        result.put(prize, result.get(prize) + 1);
    }

    private List<Integer> getMatchNumbersWith(List<Integer> issuedLottoNumbers) {
        List<Integer> winningNumbers = winningNumber.get();
        return issuedLottoNumbers.stream()
                .filter(o -> winningNumbers.stream()
                        .anyMatch(Predicate.isEqual(o)))
                .toList();
    }

    private long getProfitAmount() {
        long profitAmount = 0;
        for(Prize prize : result.keySet()) {
            profitAmount += ((long) prize.getPrice() * result.get(prize));
        }
        return profitAmount;
    }
}
