package main.java;

import data_access.APIDataAccessObject;

public class Main {
    public static void main(String[] args) {
        APIDataAccessObject spot = new APIDataAccessObject();
        //System.out.println(spot.getData("11vYnWjFxgXBgw2aC6Rb8"));
        System.out.println(spot.getMe());
    }
}