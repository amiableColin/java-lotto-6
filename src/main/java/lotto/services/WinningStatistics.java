package lotto.services;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoPurchaser;
import lotto.WinningLotto;

import java.util.*;

public class WinningStatistics {
    private final WinningLotto winningLotto;
    private final List<List<Integer>> userLottoList;
    private static final HashMap <List<Integer>, Integer> winningMoneys = new HashMap<>();
    private final HashMap<List<Integer>, Integer> matchedData = new HashMap<>();

    public WinningStatistics(Lotto winningLotto, LottoNumber bonusNumber, List<List<Integer>> userLottoList) {
        this.winningLotto = new WinningLotto(winningLotto, bonusNumber);
        this.userLottoList = userLottoList;
        initWinningMoney();
        initMatchedData();
        calcWinningCounts();
    }

    public void printWinningStatics() {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (List<Integer> key : matchedData.keySet().stream().sorted(Comparator.comparingInt(d -> d.get(0))).toList()) {
            if (key.get(1) != 0) {
                System.out.println(key.get(0)+"개 일치, 보너스 볼 일치 (" + String.format("%,d", winningMoneys.get(key)) + "원) - " + matchedData.get(key) + "개");
                continue;
            }
            System.out.println(key.get(0)+"개 일치 (" + String.format("%,d", winningMoneys.get(key)) + "원) - " + matchedData.get(key) + "개");
        }
    }

    public void printRateOfReturn() {
        double rate = rateOfReturn();
        System.out.printf("총 수익률은 %.1f%%입니다.", rate * 100);
    }

    private double rateOfReturn() {
        double rate = matchedData.keySet().stream()
                .map(key -> matchedData.get(key) * winningMoneys.get(key))
                .mapToDouble(Integer::doubleValue)
                .sum();

        return rate / (LottoPurchaser.PRICE_PER_LOTTO * userLottoList.size());
    }

    private void calcWinningCounts() {
        List<List<Integer>> data = userLottoList.stream()
                .map(Lotto::new)
                .map(winningLotto::getResult)
                .toList();

        data.stream().filter(d -> d.get(0) >= 3)
        .forEach(d -> matchedData.put(d, matchedData.get(d) + 1));
    }

    private void initWinningMoney() {
        winningMoneys.put(List.of(3,0), 5_000);
        winningMoneys.put(List.of(4,0), 50_000);
        winningMoneys.put(List.of(5,0), 1_500_000);
        winningMoneys.put(List.of(5,1), 30_000_000);
        winningMoneys.put(List.of(6,0), 2_000_000_000);
    }

    private void initMatchedData() {
        matchedData.put(List.of(3, 0), 0);
        matchedData.put(List.of(4, 0), 0);
        matchedData.put(List.of(5, 0), 0);
        matchedData.put(List.of(5, 1), 0);
        matchedData.put(List.of(6, 0), 0);
    }
}
