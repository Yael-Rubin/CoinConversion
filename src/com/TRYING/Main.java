package com.TRYING;

import MeasurementsConversion.NIS;
import MeasurementsConversion.USD;
import MeasurementsConversion.coin;

import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object for user input
        System.out.println("Enter full path file:");
        String pathname= myObj.nextLine();//"C:/Users/Yael-PC/Documents/newTxtFile.txt"
        try{
            File file=new File(pathname);
            Scanner sc = new Scanner(file);     //file to be scanned
            double value=0;
            double fromChangeRate=1;
            double toChangeRate=1;
            //coin c=new coin(1);
            coin C=null;
            if (sc.hasNextLine()){
                switch (sc.nextLine()){
                    case "USD":
                        C=new USD(3.5);
                        break;
                    case "NIS":
                        C=new NIS(1);
                        break;
                }
                fromChangeRate=C.getChangeRate();
            }
            if (sc.hasNextLine()){
                switch (sc.nextLine()){
                    case "USD":
                        C=new USD(3.5);
                        break;
                    case "NIS":
                        C=new NIS(1);
                        break;
                }
                toChangeRate=C.getChangeRate();
            }
            while (sc.hasNextLine()) {      //returns true if and only if scanner has another token
                value= Double.parseDouble(sc.nextLine());
                double change=(value*fromChangeRate)/toChangeRate;
                System.out.println(change);
            }

        }
        catch (Exception e)
        {
            System.out.println("Exception");
            e.printStackTrace();
        }
        
    }
}
