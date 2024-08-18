package lotto;

import lotto.entity.Lotto;
import lotto.entity.LottoNumber;
import lotto.services.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningStatisticsTest {
    public static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(List.of(List.of(1,2,3,8,9,10)), 5.0),
                Arguments.of(List.of(List.of(1,2,3,4,9,10)), 50.0),
                Arguments.of(List.of(List.of(1,2,3,8,9,10), List.of(1,2,3,4,9,10)), 27.5),
                Arguments.of(List.of(List.of(1,2,3,4,5,6)), 2_000_000.0)
        );
    }

    public static Stream<Arguments> provideParameters2() {
        return Stream.of(
                Arguments.of(List.of(List.of(1,2,3,8,9,10)), Map.of(List.of(3, 0), 1, List.of(3, 1), 0, List.of(4, 0), 0, List.of(4, 1), 0, List.of(5, 0), 0, List.of(5, 1), 0, List.of(6, 0), 0)),
                Arguments.of(List.of(List.of(1,2,3,4,9,10)), Map.of(List.of(3, 0), 0, List.of(3, 1), 0, List.of(4, 0), 1, List.of(4, 1), 0, List.of(5, 0), 0, List.of(5, 1), 0, List.of(6, 0), 0)),
                Arguments.of(List.of(List.of(1,2,3,8,9,10), List.of(1,2,3,4,9,10)), Map.of(List.of(3, 0), 1, List.of(3, 1), 0, List.of(4, 0), 1, List.of(4, 1), 0, List.of(5, 0), 0, List.of(5, 1), 0, List.of(6, 0), 0)),
                Arguments.of(List.of(List.of(1,2,3,4,5,6)), Map.of(List.of(3, 0), 0, List.of(3, 1), 0, List.of(4, 0), 0, List.of(4, 1), 0, List.of(5, 0), 0, List.of(5, 1), 0, List.of(6, 0), 1))
        );
    }

    @DisplayName("수익률을 잘 계산한다.")
    @ParameterizedTest
    @MethodSource("provideParameters")
    void rateOfReturn(List<List<Integer>> userLottoList, double EXPECTED_RESULT) {
        // given
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningStatistics winningStatistics = new WinningStatistics(winningLotto, bonusNumber, userLottoList);

        // when
        double result = winningStatistics.rateOfReturn();

        // then
        assertThat(result).isEqualTo(EXPECTED_RESULT);
    }

    @DisplayName("몇 개 당첨되었는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideParameters2")
    void calcWinningCounts(List<List<Integer>> userLottoList, Map<List<Integer>, Integer> EXPECTED_RESULT) {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningStatistics winningStatistics = new WinningStatistics(winningLotto, bonusNumber, userLottoList);

        // when
        Map<List<Integer>, Integer> matchedData = winningStatistics.getMatchedData();

        // then
        assertThat(matchedData).isEqualTo(EXPECTED_RESULT);
    }
}