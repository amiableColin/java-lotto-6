package lotto;

public class WinningLotto {
    private Lotto winningLotto;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int[] getResult(Lotto userLotto) {
        int[] result = new int[2];
        result[0] = winningLotto.getMatchCount(userLotto);
        if (userLotto.getNumbers().contains(bonusNumber.getNumber()))
            result[1] = 1;
        return result;
    }
}
