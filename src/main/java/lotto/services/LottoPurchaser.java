package lotto.services;

import lotto.entity.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoPurchaser {
    public static final int PRICE_PER_LOTTO = 1000;
    private final int lottoCount;

    public LottoPurchaser(int price) {
        this.lottoCount = price / PRICE_PER_LOTTO;
    }

    public List<List<Integer>> purchaseLotto() {
        int[] arr = new int[lottoCount];
        return Arrays.stream(arr).mapToObj(n -> new Lotto(generateLotto()).getNumbers()).collect(Collectors.toList());
    }

    private List<Integer> generateLotto() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }
}