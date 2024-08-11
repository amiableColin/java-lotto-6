package lotto.services;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoPurchaser;
import lotto.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;

public class WinningStatistics {
    private WinningLotto winningLotto;
    private List<List<Integer>> userLottoList;
    private static HashMap <List<Integer>, Integer> winningMoneys = new HashMap<>();
    private HashMap<List<Integer>, Integer> matchedData = new HashMap<>();

    public WinningStatistics(Lotto winningLotto, LottoNumber bonusNumber, List<List<Integer>> userLottoList) {
        this.winningLotto = new WinningLotto(winningLotto, bonusNumber);
        this.userLottoList = userLottoList;
        initWinningMoney();
        initMatchedData();
    }

    public void printWinningStatics() {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<List<Integer>> data = userLottoList.stream().map(Lotto::new)
                .map(lotto -> winningLotto.getResult(lotto))
                .map(stream ->
                        Arrays.stream(stream)
                        .boxed().collect(Collectors.toList())
                )
                .toList();
        for (List<Integer> d : data) {
            if (d.get(0) >= 3)
                matchedData.put(d, matchedData.get(d) + 1);
        }

        for (List<Integer> key : matchedData.keySet().stream().sorted(Comparator.comparingInt(d -> d.get(0))).toList()) {
            if (key.get(1) != 0) {
                System.out.println(key.get(0)+"개 일치, 보너스 볼 일치 (" + String.format("%,d", winningMoneys.get(key)) + "원) - " + matchedData.get(key) + "개");
                continue;
            }
            System.out.println(key.get(0)+"개 일치 (" + String.format("%,d", winningMoneys.get(key)) + "원) - " + matchedData.get(key) + "개");
        }
    }

    public void rateOfReturn() {
        double rate = 0.0;
        for (List<Integer> key : matchedData.keySet()) {
            if (matchedData.get(key) != 0) {
                rate += matchedData.get(key) * winningMoneys.get(key);
            }
        }
        rate = rate / (LottoPurchaser.PRICE_PER_LOTTO * userLottoList.size());
        System.out.printf("총 수익률은 %.1f%%입니다.", rate * 100);
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
