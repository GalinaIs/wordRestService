package org.mycompany.db.combination;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.mycompany.db.letter.LettersArray;

import java.util.List;

public class CombinationUtilsTest {
    @Test
    public void test() {
        List<LettersArray> allCombinations = CombinationUtils.getAllCombinations("123");
        Assert.assertEquals(7, allCombinations.size());
        Assert.assertTrue(allCombinations.contains(new LettersArray(Lists.list('1'))));
        Assert.assertTrue(allCombinations.contains(new LettersArray(Lists.list('2'))));
        Assert.assertTrue(allCombinations.contains(new LettersArray(Lists.list('3'))));
        Assert.assertTrue(allCombinations.contains(new LettersArray(Lists.list('1', '2'))));
        Assert.assertTrue(allCombinations.contains(new LettersArray(Lists.list('1', '3'))));
        Assert.assertTrue(allCombinations.contains(new LettersArray(Lists.list('2', '3'))));
        Assert.assertTrue(allCombinations.contains(new LettersArray(Lists.list('1', '2', '3'))));
    }

    /**
     * Ожидаем, что при обработке длинной строки не будет выброшено исключение.
     */
    @Test
    public void test1() {
        CombinationUtils.getAllCombinations("аовфжаоккщшщзецшгафмтмтябаьлввввввввввкщцшзушкцузщкшцзщуаолаомоывапролорпавйцукенгшщзхзждлорпавычсмитьбдлонекуаптьлшгнекуцывсмилщгшорвапва");
    }
}