package com.company;
import java.util.ArrayList;
import java.util.*;
import java.time.LocalDate;
import java.time.ZoneId;

public class Chicken {
    //Creates the array that all health conditions are added to
    ArrayList<String> healthConditions = new ArrayList<>();

    //I=List of instance variables
    String name;
    LocalDate Birthday;
    Color color;
    String foodPref;
    int eggsLaid;
    EggColor eggColor;

    //Creates the enum for egg colors
    public enum EggColor{
        WHITE,
        LIGHTBROWN,
        BROWN,
        DARKBROWN,
        BLUE,
        GREEN
    }

    //Creates the enum for chicken colors
    public enum Color{
        WHITE,
        BLACK,
        BROWN,
        SPOTS,
        RED
    }

    //A whole bunch of getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return Birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.Birthday = birthday;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getFoodPref() {
        return foodPref;
    }

    public void setFoodPref(String foodPref) {
        this.foodPref = foodPref;
    }

    public int getEggsLaid() {
        return eggsLaid;
    }

    public void setEggsLaid(int eggsLaid) {
        this.eggsLaid = eggsLaid;
    }

    public EggColor getEggColor() {
        return eggColor;
    }

    public void setEggColor(EggColor eggColor) {
        this.eggColor = eggColor;
    }

    public void addHealthConditions(String condition){
        healthConditions.add(condition);
    }


    //Constructor for a chicken
    public Chicken(String name, LocalDate birthday, Color color, String foodPref, int eggsLaid, EggColor eggColor) {
        this.name = name;
        Birthday = birthday;
        this.color = color;
        this.foodPref = foodPref;
        this.eggsLaid = eggsLaid;
        this.eggColor = eggColor;
    }

    //Function that calculates a chickens age
    public int calculateAge(){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();

        int bYear = Birthday.getYear();
        int bMonth = Birthday.getMonthValue();
        int bDay = Birthday.getDayOfMonth();

        int yearDif = year - bYear;
        if ((month - bMonth) > 0) {
            return yearDif;
        } else if (((month - bMonth) < 0)) {
            return (yearDif - 1);
        } else {
            if (day >= bDay) {
                return yearDif;
            } else {
                return (yearDif - 1);
            }
        }
    }
}
