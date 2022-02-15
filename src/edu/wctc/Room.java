package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable
{
    private final List<Wall> wallList = new ArrayList<>();

    public Room (double width, double length, double height)
    {
        wallList.add(new Wall(width, height));
        wallList.add(new Wall(width, height));
        wallList.add(new Wall(length, height));
        wallList.add(new Wall(length, height));
    }

    public double getArea()
    {
        return wallList.get(0).getArea() + wallList.get(1).getArea() + wallList.get(2).getArea()
                + wallList.get(3).getArea();
    }

    @Override
    public String toString()
    {
        return "The rooms area is: " + getArea();
    }
}
