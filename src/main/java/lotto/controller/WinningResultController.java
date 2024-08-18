package lotto.controller;

import lotto.entity.Lotto;
import lotto.entity.LottoNumber;
import lotto.services.WinningStatistics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class WinningResultController {
    WinningStatistics winningStatistics;
    public WinningResultController(Lotto winningLotto, LottoNumber bonus, List<List<Integer>> lottoList) {
        this.winningStatistics = new WinningStatistics(winningLotto, bonus, lottoList);
    }

    private void printWinningStatics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        Map<List<Integer>, Integer> matchedData = winningStatistics.getMatchedData();
        for (List<Integer> key : matchedData.keySet().stream().sorted(Comparator.comparingInt(d -> d.get(0))).toList()) {
            if (key.get(1) != 0) {
                System.out.println(key.get(0)+"개 일치, 보너스 볼 일치 (" + String.format("%,d", WinningStatistics.winningMoneys.get(key)) + "원) - " + matchedData.get(key) + "개");
                continue;
            }
            System.out.println(key.get(0)+"개 일치 (" + String.format("%,d", WinningStatistics.winningMoneys.get(key)) + "원) - " + matchedData.get(key) + "개");
        }
    }

    private void printRateOfReturn() {
        double rate = winningStatistics.rateOfReturn();
        System.out.printf("총 수익률은 %.1f%%입니다.", rate * 100);
    }

    public void run() {
        winningStatistics.printWinningStatics();
        winningStatistics.printRateOfReturn();
    }
}
