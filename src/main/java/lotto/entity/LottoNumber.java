package lotto.entity;

public class LottoNumber {
    private int number;
    public LottoNumber(Integer number) {
        validatePositive(number);
        validateInRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber from(String str) {
        validateInteger(str);
        return new LottoNumber(Integer.parseInt(str));
    }

    public static void validateInteger(String str) {
        boolean isInteger = str.matches("^-?\\d+$");
        if (!isInteger) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 정수만 입력하여야 합니다.");
        }
    }
    private static void validatePositive(int number) {
        boolean isPositiveInteger = number > 0;
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
