package org.mycompany.parser;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class FileToMapWordDefinitionParserTest {
    @Test
    public void testParse() throws IOException {
        FileToMapWordDefinitionParser parser = new FileToMapWordDefinitionParser();
        Map<String, String> map = parser.parse("testDictionary.txt");
        Assert.assertEquals(6, map.size());
        Assert.assertEquals("Колпак для лампы, светильника. Зеленый а. 11 прил. абажурный, -ая, -ое.", map.get("АБАЖУР"));
        Assert.assertEquals("1. см. абазины. 2. Относящийся к абазинам, к их языку, национальному характеру, образу жизни, культуре, а также к территории их проживания, ее внутреннему устройству, истории; такой, как у абазин. А. язык (абхазско-адыгейской группы кавказских языков). По-абазински (нареч.).", map.get("АБАЗИНСКИЙ"));
        Assert.assertEquals("Народ, живущий в Карачаево-Черкесии и в Адыгее. II ж. абазинка, -и. II прил, абазинский, -ая, -ое.", map.get("АБАЗИНЫ"));
        Assert.assertEquals("1. Настоятель мужского католического монастыря. 2. Католический священнослужитель. II прил. аббатский, -ая,-ое.", map.get("АББАТ"));
        Assert.assertEquals("Настоятельница женского католического монастыря.", map.get("АББАТИСА"));
        Assert.assertEquals("Католический монастырь.", map.get("АББАТСТВО"));
    }
}