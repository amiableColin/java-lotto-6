package lotto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
//        System.out.println(promptPurchaseMoney());
//        System.out.println(promptWinningLottoNumbers());
        System.out.println(promptBonusNumber().getNumber());
    }

    private static int promptPurchaseMoney() {
        while (true) {
            System.out.println("구입금액을 입력해주세요.");
            String money = readLine();
            boolean isInteger = money.chars().allMatch(Character::isDigit);

            try {
                if (!isInteger)
                    throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하셨습니다.");
                if (Integer.parseInt(money) % 1000 != 0)
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto promptWinningLottoNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String inputData = readLine();
            try {
                List<Integer> winningNumbers = Arrays.stream(inputData.split(",")).map(num -> new LottoNumber(num).getNumber()).collect(Collectors.toList());
                return new Lotto(winningNumbers);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static LottoNumber promptBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = readLine();
            try {
                return new LottoNumber(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
