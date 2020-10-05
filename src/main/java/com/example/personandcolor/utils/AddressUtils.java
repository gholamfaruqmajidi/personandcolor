package com.example.personandcolor.utils;

public class AddressUtils {

    public static String getZipcode(String address){
        String[] values = address.split(" ");
        return values[0].trim();
    }

    public static String getCity(String address){
        return address.trim().substring(6);
    }
}
