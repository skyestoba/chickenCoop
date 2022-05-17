package com.company;
import java.io.IOException;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) throws IOException {
        //Creates an instance of the class Chicken called specky and creates her birthday
        LocalDate SpeckysBDay = LocalDate.of(2020, 4, 15);
        Chicken Specky = new Chicken("Specky", SpeckysBDay, Chicken.Color.SPOTS, "bugs", 1, Chicken.EggColor.LIGHTBROWN);

        //Claculates and prints speckys age based on her birthday
        System.out.println(Specky.calculateAge());

        //Adds speckys health conditions and prints these health conditions out
        Specky.addHealthConditions("curly toes");
        System.out.println(Specky.healthConditions);

        //Creates todays file for specky
        LocalDate today = LocalDate.now();
        FileCreate specky = new FileCreate(today,"specky");
        specky.createFile();

        //Creates the String speckyStats that can eaisly be added to file. This is then added to file. Additional text is then added with String mes.
        String speckyStats = "Name: "+ Specky.getName() + ", Birthday: " + Specky.getBirthday() + ", Eggs Laid Today: " + Specky.getEggsLaid() + ", Egg Color: " + Specky.getEggColor() + ", Color: " + Specky.getColor() + ", Food Preference: "+ Specky.getFoodPref();
        String mes = specky.writeToFile("/Users/mandigo.skyler/IdeaProjects/chickenCoop/specky.txt");
        specky.finalWrite("specky",speckyStats,mes);
        String mes2 = specky.writeToFile("/Users/mandigo.skyler/IdeaProjects/chickenCoop/specky.txt");
        specky.finalWrite("specky",mes2,"End of day 1.");
    }
}
