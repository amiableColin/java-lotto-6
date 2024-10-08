package lotto;

import lotto.entity.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("두 로또를 비교해서 일치하는 개수를 반환한다.")
    @Test
    void matchingCountOfTwoLottos() {
        // given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto another = new Lotto(List.of(1,3,4,5,6,7));
        final int EXPECTED_RESULT = 5;

        // when
        int matchCount = lotto1.getMatchCount(another);

        // then
        assertThat(matchCount)
                .isEqualTo(EXPECTED_RESULT);
    }
}