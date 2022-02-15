package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main
{
    static private final Scanner keyboard = new Scanner(System.in);
    static private PaintCalculator paintCalculator = new PaintCalculator();

    public static void main(String[] args)
    {
        int answer = 0;
        while (answer != 5)
        {
            printMenu();
            String temp = keyboard.nextLine();
            try
            {
                answer = Integer.parseInt(temp);
            }
            catch (NumberFormatException N)
            {
                System.out.println("Please input a valid number");
            }

            switch (answer)
            {
                case 1: createRoom();
                break;
                case 2: writeFile();
                break;
                case 3: readFile();
                break;
                case 4:
                    System.out.println(paintCalculator.toString());
                break;
                case 5: break;
            }
        }
    }

    static private void printMenu()
    {
        System.out.println("1. Add room");
        System.out.println("2. Write rooms to file");
        System.out.println("3. Read rooms from file");
        System.out.println("4. View rooms");
        System.out.println("5. Exit");
    }


    static private double promptForDimension(String dimensionName)
    {
        Double answer = null;
        while (answer == null)
        {
            try
            {
                answer = Double.parseDouble(dimensionName);
            }
            catch (NumberFormatException N)
            {
                System.out.println("Please input a valid number");
                dimensionName = keyboard.nextLine();
            }
        }
        return answer;
    }

    static private void createRoom()
    {
        System.out.println("Enter the width");
        double width = promptForDimension(keyboard.nextLine());
        System.out.println("Enter the length");
        double length = promptForDimension(keyboard.nextLine());
        System.out.println("Enter the height");
        double height = promptForDimension(keyboard.nextLine());
        paintCalculator.addRoom(width, length, height);
    }

    static private void readFile()
    {
        try
        {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("rooms.obj"));
            paintCalculator = (PaintCalculator) ois.readObject();
            System.out.println("Successfully loaded from file");
        }
        catch (IOException e)
        {
            System.out.println("failed to load file");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("This should never happen");
            e.printStackTrace();
        }
    }

    static private void writeFile()
    {
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("rooms.obj"));
            oos.writeObject(paintCalculator);
            System.out.println("Successfully saved to file");
        }
        catch (IOException e)
        {
            System.out.println("failed to read file");
        }
    }
}
