package com.jr.level.level33.sandbox;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;



public class TestSerializable implements Serializable {
    private Integer integer;
    private Double aDouble;
    private Date date;

    public TestSerializable(Integer integer, Double aDouble, Date date) {
        this.integer = integer;
        this.aDouble = aDouble;
        this.date = date;
    }

    public Integer getInteger() {
        return integer;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "TestSerializable{" +
                "integer=" + integer +
                ", aDouble=" + aDouble +
                ", date=" + date +
                '}';
    }

    public static void main(String[] args) throws Throwable{
        TestSerializable serializable = new TestSerializable(100, 10.5, new Date());

        System.out.println("Before");
        System.out.println(serializable);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(serializable);

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(is);
        TestSerializable serializable1 = (TestSerializable) ois.readObject();

        System.out.println("After");
        System.out.println(serializable1);

    }

}
