package com.cquacmer.task.hust.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by xuwei on 15/11/1.
 */
public class ContestItem {
    private ArrayList<Object[]> data;
    private String draw;
    private int recordsFiltered;
    private int recordsTotal;

    public ArrayList<Object[]> getData() {
        return data;
    }

    public void setData(ArrayList<Object[]> data) {
        this.data = data;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    @Override
    public String toString() {
        return "ContestItem{" +
                "data=" + data +
                ", draw='" + draw + '\'' +
                ", recordsFiltered=" + recordsFiltered +
                ", recordsTotal=" + recordsTotal +
                '}';
    }
}
