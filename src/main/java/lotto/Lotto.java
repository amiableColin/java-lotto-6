package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateCountOfNumbers(numbers);
        validateDuplicateNumber(numbers);
    }

    private static void validateCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        boolean isDuplicated = new HashSet<>(numbers).size() != 6;
        if(isDuplicated) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야만 합니다.");
        }
    }
}
