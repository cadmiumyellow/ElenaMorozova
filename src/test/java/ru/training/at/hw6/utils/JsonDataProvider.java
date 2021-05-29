
package ru.training.at.hw6.utils;

import org.testng.annotations.DataProvider;
import ru.training.at.hw6.entities.MetalsAndColorsData;

import java.io.IOException;
import java.util.List;

public class JsonDataProvider {
    public JsonDataProvider() throws IOException {
    }

    public JsonDataParser jsonDataParser = new JsonDataParser();

    @DataProvider
    public Object[] data() throws IOException {
        List<MetalsAndColorsData> list = jsonDataParser.getJsonDataSet();
        return list.toArray();
    }

}

