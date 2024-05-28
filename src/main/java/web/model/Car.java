package web.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private String color;
    private int year;
    private List<Car> carList;

    public Car() {
        carList = new ArrayList<>();
        carList.add(new Car("BMW", "Black", 2002));
        carList.add(new Car("Mercedes", "Blue", 2010));
        carList.add(new Car("Audi", "Red", 2005));
        carList.add(new Car("Toyota", "White", 1999));
        carList.add(new Car("Skoda", "Gray", 2015));
    }

    public Car(String name, String color, int year) {
        this.name = name;
        this.color = color;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
