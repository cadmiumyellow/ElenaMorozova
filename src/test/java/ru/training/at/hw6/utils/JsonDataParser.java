package ru.training.at.hw6.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.training.at.hw6.entities.MetalsAndColorsData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class JsonDataParser {

    public JsonDataParser() throws IOException {
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, MetalsAndColorsData> testData = objectMapper
            .readValue(new File(
                    "src/test/resources/JDI_ex8_metalsColorsDataSet.json"),
                    new TypeReference<Map<String, MetalsAndColorsData>>(){});

    public List<MetalsAndColorsData> getJsonDataSet() {
        List<MetalsAndColorsData> list = new ArrayList<>();
        for (Map.Entry entry : testData.entrySet()) {
            list.add((MetalsAndColorsData) entry.getValue());
        }
        return list;
    }

}

