package com.example.personandcolor.utils;

public class ColorUtils {

    public static String getColor(int colorId){
        switch (colorId){
            case 1:
                return "blau";
            case 2:
                return "grün";
            case 3:
                return "violett";
            case 4:
                return "rot";
            case 5:
                return "gelb";
            case 6:
                return "türkis";
            case 7:
                return "weiß";
            default:
                return "unbekannte Farbe";
        }
    }

    public static int getColorId(String color){
        switch (color){
            case "blau":
                return 1;
            case "grün":
                return 2;
            case "violett":
                return 3;
            case "rot":
                return 4;
            case "gelb":
                return 5;
            case "türkis":
                return 6;
            case "weiß":
                return 7;
            default:
                return 0;
        }
    }
}
