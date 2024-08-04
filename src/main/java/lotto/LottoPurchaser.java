package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class LottoPurchaser {
    private static final int PRICE_PER_LOTTO = 1000;
    private final int lottoCount;

    private List<Lotto> lottoList;

    public LottoPurchaser(int price) {
        this.lottoCount = price / PRICE_PER_LOTTO;
    }

    public List<List<Integer>> purchaseLotto() {
        int[] arr = new int[lottoCount];
        return Arrays.stream(arr).mapToObj(n -> new Lotto(generateLotto()).getNumbers()).collect(Collectors.toList());
    }

    private List<Integer> generateLotto() {
        HashSet<Integer> lotto = new HashSet<>();
        while (lotto.size() < 6)
            lotto.add(pickNumberInRange(1, 46));
        return lotto.stream().sorted().collect(Collectors.toList());
    }
}