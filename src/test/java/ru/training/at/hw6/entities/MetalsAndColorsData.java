package ru.training.at.hw6.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.training.at.hw6.utils.JsonDataParser;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class MetalsAndColorsData extends DataClass<JsonDataParser> {

    private ArrayList<String> summary;
    private ArrayList<String> elements;
    private String color;
    private String metals;
    private ArrayList<String> vegetables;

    public MetalsAndColorsData(ArrayList<String> summary, ArrayList<String> elements,
                               String color, String metals, ArrayList<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.color = color;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    /*public String dataSetToString() {
        return summary.toString() + "/"
                + elements.toString() + "/"
                + color + "/"
                + metals + "/"
                + vegetables.toString();
    }*/

    public String sumSummaryNumbers() {
        int i = Integer.parseInt(summary.get(0)) + Integer.parseInt(summary.get(1));
        return String.valueOf(i);
    }

    public List<String> setToList() {
        List<String> list = new ArrayList<>();
        list.add("Summary: " + sumSummaryNumbers());
        String els = this.elements.toString();
        list.add("Elements: " + els.substring(1, els.length() - 1));
        list.add("Color: " + color);
        list.add("Metal: " + metals);
        String veggies = vegetables.toString();
        list.add("Vegetables: " + veggies.substring(1, veggies.length() - 1));
        return list;
    }

}
