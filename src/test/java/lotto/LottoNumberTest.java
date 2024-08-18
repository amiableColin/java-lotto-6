package lotto;

import lotto.entity.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 번호의 입력값이 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoIntegerNumber() {
        assertThatThrownBy(() -> LottoNumber.from("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 양의 정수가 아니면 예외가 발생한다.")
    @Test
    void createLottoPositiveNumber() {
        assertThatThrownBy(() -> LottoNumber.from("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위가 1 이상 45 이하가 아니면 예외가 발생한다.")
    @Test
    void createLottoByOverRange() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
