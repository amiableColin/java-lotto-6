package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    @DisplayName("보너스 번호를 포함하여, 정답 로또와 입력 로또가 몇 개 일치하는지 테스트 1.")
    @Test
    void getResult1() {
        // given
        Lotto correctLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(List.of(1,2,3,4,5,7));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(correctLotto, bonusNumber);

        final List<Integer> EXPECTED_RESULT = List.of(5, 1);

        // when
        List<Integer> result = winningLotto.getResult(userLotto);

        // then
        assertThat(result)
                .isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("보너스 번호를 포함하여, 정답 로또와 입력 로또가 몇 개 일치하는지 테스트 2.")
    @Test
    void getResult2() {
        // given
        Lotto correctLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(List.of(1,2,3,4,7,8));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(correctLotto, bonusNumber);

        final List<Integer> EXPECTED_RESULT = List.of(4, 1);

        // when
        List<Integer> result = winningLotto.getResult(userLotto);

        // then
        assertThat(result)
                .isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("보너스 번호를 포함하여, 정답 로또와 입력 로또가 몇 개 일치하는지 테스트 3.")
    @Test
    void getResult3() {
        // given
        Lotto correctLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(List.of(1,2,12,13,14,15));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(correctLotto, bonusNumber);

        final List<Integer> EXPECTED_RESULT = List.of(2, 0);

        // when
        List<Integer> result = winningLotto.getResult(userLotto);

        // then
        assertThat(result)
                .isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("보너스 번호를 포함하여, 정답 로또와 입력 로또가 몇 개 일치하는지 테스트 4.")
    @Test
    void getResult4() {
        // given
        Lotto correctLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLotto = new Lotto(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(correctLotto, bonusNumber);

        final List<Integer> EXPECTED_RESULT = List.of(6, 0);

        // when
        List<Integer> result = winningLotto.getResult(userLotto);

        // then
        assertThat(result)
                .isEqualTo(EXPECTED_RESULT);
    }

}
