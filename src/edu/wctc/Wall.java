package edu.wctc;

import java.io.Serializable;

public class Wall implements Serializable
{
    private final double width;
    private final double height;

    public Wall (double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public double getArea()
    {
        return getWidth() * getHeight();
    }
}
