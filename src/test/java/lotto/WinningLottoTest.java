package lotto;

import lotto.entity.Lotto;
import lotto.entity.LottoNumber;
import lotto.services.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    public static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), List.of(5,1)),
                Arguments.of(List.of(1, 2, 3, 4, 7, 8), List.of(4,1)),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9), List.of(3,1))
        );
    }

    @DisplayName("보너스 번호를 포함하여, 정답 로또와 입력 로또가 몇 개 일치하는지 테스트.")
    @ParameterizedTest
    @MethodSource("provideParameters")
    void getResult1(List<Integer> userLotto, List<Integer> EXPECTED_RESULT) {
        // given
        Lotto correctLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto userLottos = new Lotto(userLotto);
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(correctLotto, bonusNumber);

        // when
        List<Integer> result = winningLotto.getResult(userLottos);

        // then
        assertThat(result)
                .isEqualTo(EXPECTED_RESULT);
    }
}
