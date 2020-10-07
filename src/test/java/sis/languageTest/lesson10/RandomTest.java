package sis.languageTest.lesson10;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomTest {

    Random random = new Random();

    @Test
    public void testCustomRandom() {

        final int start = 1;
        final int end = 50;

        for (int i = 0; i < 50; i++) {
            int value = random(start, end);
            assertTrue(start <= value && value <= end);
        }
    }

    private int random(int start, int end) {

        if (start > end)
            throw new IllegalArgumentException("시작숫자는 끝 숫자보다 작거나 같아야 합니다.");

        if (start == end)
            return start;

        double increase = Math.random() * (end - start);
        int increaseInt = (int) Math.round(increase);
        return start + increaseInt;
    }

    @Test
    public void testRandomSwap() {
        // 초기화 숫자
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }

        Verifier verifier = new Verifier(numbers);

        // Swap 100 times and test
        for (int i = 0; i < 100; i++) {
            randomSwap(numbers);
            verifier.verifySwapping(numbers);
        }
    }

    private void randomSwap(List<Integer> numbers) {
        int bound = numbers.size();
        int indexA = random.nextInt(bound);
        System.out.println(indexA);
        int indexB = indexA;

        while (indexA == indexB)
            indexB = random.nextInt(bound);

        int temp = numbers.get(indexA);
        numbers.set(indexA, numbers.get(indexB));
        numbers.set(indexB, temp);


    }

    class Verifier {

        private List<Integer> oldNumberList;

        public Verifier(List<Integer> number) {
            oldNumberList = new ArrayList<>(number);
        }

        void verifySwapping(List<Integer> newNumberList) {
            assertEquals(oldNumberList.size(), newNumberList.size());

            List<Integer> indexOfDifferences = new ArrayList<>();
            for (int i = 0; i < oldNumberList.size(); i++) {
                if (oldNumberList.get(i) != newNumberList.get(i))
                    indexOfDifferences.add(i);
            }

            assertEquals(2, indexOfDifferences.size());

            int indexA = indexOfDifferences.get(0);
            int indexB = indexOfDifferences.get(1);

            assertEquals(oldNumberList.get(indexA), newNumberList.get(indexB));
            assertEquals(oldNumberList.get(indexB), newNumberList.get(indexA));


            updateOldNumberList(indexA, indexB);
        }

        private void updateOldNumberList(int indexA, int indexB) {
            int temp = oldNumberList.get(indexA);
            oldNumberList.set(indexA, oldNumberList.get(indexB));
            oldNumberList.set(indexB, temp);
        }
    }

}
