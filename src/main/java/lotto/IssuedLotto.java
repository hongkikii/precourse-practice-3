package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IssuedLotto {
    private final List<Lotto> issuedLottos;

    public IssuedLotto(Price price) {
        issuedLottos = new ArrayList<>();
        int count = price.get() / 1000;
        for (int i = 1; i <= count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            issuedLottos.add(lotto);
        }
    }

    public List<Lotto> get() {
        return Collections.unmodifiableList(issuedLottos);
    }

    public int getCount() {
        return issuedLottos.size();
    }
}
