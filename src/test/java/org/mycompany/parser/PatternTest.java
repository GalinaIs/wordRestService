package org.mycompany.parser;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;

import static org.mycompany.parser.FileToMapWordDefinitionParser.PATTERN;

public class PatternTest {
    @Test
    public void testValidPattern() {
        String string = "АБАЖУР, -а, м. Колпак для лампы, светильника. Зеленый а. 11 прил. абажурный, -ая, -ое. ";
        Matcher matcher = PATTERN.matcher(string);
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("АБАЖУР", matcher.group(1));
        Assert.assertEquals("Колпак для лампы, светильника. Зеленый а. 11 прил. абажурный, -ая, -ое. ", matcher.group(3));
    }

    @Test
    public void testValidPattern1() {
        String string = "АГА[aha]. 1. межд. Восклицание с торжествующей интонацией. Ага! попался! 2. частица. Выражает подтверждение, а также уяснение или догадку (прост.). Ага, вот в чем дело-то! Видишь? - Ага, вижу.";
        Matcher matcher = PATTERN.matcher(string);
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("АГА", matcher.group(1));
        Assert.assertEquals("1. межд. Восклицание с торжествующей интонацией. Ага! попался! 2. частица. Выражает подтверждение, а также уяснение или догадку (прост.). Ага, вот в чем дело-то! Видишь? - Ага, вижу.", matcher.group(3));
    }

    @Test
    public void testValidPattern2() {
        String string = "АБАЗИНЫ, -ин, ед. -инец, -нца, м. Народ, живущий в Карачаево-Черкесии и в Адыгее. II ж. абазинка, -и. II прил, абазинский, -ая, -ое.";
        Matcher matcher = PATTERN.matcher(string);
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("АБАЗИНЫ", matcher.group(1));
        Assert.assertEquals("Народ, живущий в Карачаево-Черкесии и в Адыгее. II ж. абазинка, -и. II прил, абазинский, -ая, -ое.", matcher.group(3));
    }

    @Test
    public void testValidPatternWithMultiPoint() {
        String string = "АГРО... Первая часть сложных слов со знач.: 1) относящийся к агрономии, напр. агрофизика, агроэкология, агрохимия; 2) относящийся к сельскому хозяйству, к обработке земли, напр. агротехника, агролабора-тория; 3) относящийся к сельской местности, напр. агрокомплекс, агрорайон, агро-климат.";
        Matcher matcher = PATTERN.matcher(string);
        Assert.assertTrue(matcher.find());
        Assert.assertEquals("АГРО", matcher.group(1));
        Assert.assertEquals("Первая часть сложных слов со знач.: 1) относящийся к агрономии, напр. агрофизика, агроэкология, агрохимия; 2) относящийся к сельскому хозяйству, к обработке земли, напр. агротехника, агролабора-тория; 3) относящийся к сельской местности, напр. агрокомплекс, агрорайон, агро-климат.", matcher.group(3));
    }

    @Test
    public void testInvalidPattern() {
        String string = "invalid";
        Matcher matcher = PATTERN.matcher(string);
        Assert.assertFalse(matcher.find());
    }

    @Test
    public void testInvalidPattern1() {
        String string = "123, -ая, -ое. 1. см. американцы. 2. Относящийся к народам Соединенных Штатов Америки, к их языку, национальному характеру, образу жизни, культуре, а также к Соединенным Штатам Америки, их территории, внутреннему устройству, истории; такой, как у американцев, как в США. А. вариант английского языка. А. доллар (денежная единица). 3. Относящийся к народам континента Америка, к его странам, флоре и фауне; такой, как на континенте Америка. Американские индейцы: Американские народы. Американские страны. Американские широконосые обезьяны (секция человекоподобных приматов). Американские олени (род олене-вых). По-американски (нареч.). \n";
        Matcher matcher = PATTERN.matcher(string);
        Assert.assertFalse(matcher.find());
    }

    @Test
    public void testTestWithColonSeparator() {
        String string = "АВТОГЕННЫЙ, -ая, -ое: автогенная сварка, резка - то же, что газовая сварка, резка.";
        Matcher matcher = PATTERN.matcher(string);
        Assert.assertTrue(matcher.find());
    }
}