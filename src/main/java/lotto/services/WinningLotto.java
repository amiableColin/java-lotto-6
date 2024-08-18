package lotto.services;

import lotto.entity.Lotto;
import lotto.entity.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getResult(Lotto userLotto) {
        List<Integer> result = new ArrayList<>();
        result.add(winningLotto.getMatchCount(userLotto));
        if (userLotto.getNumbers().contains(bonusNumber.getNumber())) {
            result.add(1);
            return result;
        }
        result.add(0);
        return result;
    }
}