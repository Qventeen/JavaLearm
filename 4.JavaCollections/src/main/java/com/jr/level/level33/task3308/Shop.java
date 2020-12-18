package com.jr.level.level33.task3308;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData=" + secretData +
                '}';
    }

    @XmlType(name = "goods")
    public static class Goods {
        public List<String> names;

        @Override
        public String toString() {
            return "Goods{" +
                    "names=" + names +
                    '}';
        }
    }
}
