package lotto;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(promptPurchaseMoney());
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
}
