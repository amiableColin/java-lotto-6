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
        validateInRange(numbers);
        validateDuplicateNumber(numbers);
    }

    private static void validateCountOfNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수는 6개여야 합니다.");
        }
    }

    private void validateInRange(List<Integer> numbers) {
        boolean isInRange = numbers.stream().allMatch(n -> 0 < n && n < 46);
        if(!isInRange) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1부터 45 사이여야 합니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        boolean isDuplicated = new HashSet<>(numbers).size() != 6;
        if(isDuplicated) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없어야만 합니다.");
        }
    }
}
