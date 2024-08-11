package lotto;

import java.util.List;

public class LottoNumber {
    private int number;
    public LottoNumber(String number) {
        validatePositiveInteger(number);
        validateInRange(Integer.parseInt(number));
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }


    private static void validatePositiveInteger(String number) {
        boolean isPositiveInteger = number.chars().allMatch(Character::isDigit);
        if (!isPositiveInteger) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 이상의 정수만 입력하여야 합니다.");
        }
    }

    private void validateInRange(int number) {
        if(!(0 < number && number < 46)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1부터 45 사이여야 합니다.");
        }
    }
}
