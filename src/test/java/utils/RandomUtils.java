package utils;

import com.github.javafaker.Faker;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    public String[][] cities = {
            {"Delhi", "Gurgaon", "Noida"},
            {"Agra", "Lucknow", "Merrut"},
            {"Karnal", "Panipat"},
            {"Jaipur", "Jaiselmer"}
    };

    Faker faker = new Faker();

    public String getRandomGender(){
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }
    public String getRandomMonth(){
        String[] month = {"May","June","July","October"};
        return faker.options().option(month);
    }
    public String getRandomSubject(){
        String[] subjects = {"Physics", "Chemistry","Math","Computer Science", "Commerce", "Economics"};
        return faker.options().option(subjects);
    }
    public String getRandomHobbies(){
        String[] hobbies = {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }
    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min,max);
    }
    public String getRandomPhone(){
        return String.format("%s"+"%s"+"%s",getRandomInt(901,999),getRandomInt(901,999),getRandomInt(1111,9999));
    }

    public String getRandomItem(String[] array) {
        Random random = new Random();
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
    }


}


