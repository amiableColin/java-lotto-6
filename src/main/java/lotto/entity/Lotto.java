package lotto.entity;

import java.util.HashSet;
import java.util.List;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(Lotto another) {
        HashSet<Integer> set = new HashSet<>(this.numbers);
        set.retainAll(new HashSet<Integer>(another.getNumbers()));
        return set.size();
    }
}
