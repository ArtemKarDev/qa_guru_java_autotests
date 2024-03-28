package utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomGender());
    }

    public static String getRandomGender(){

        String[] GENDER = {"Male", "Female"};

        Random random = new Random();
        int randomIndex = random.nextInt(GENDER.length);
        String randomGender = GENDER[randomIndex];
        return randomGender;

    }

    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min,max+1);
    }
    public static String getRandomPhone(){
        return String.format("%s"+"%s"+"%s",getRandomInt(901,999),getRandomInt(901,999),getRandomInt(1111,9999));
    }


}


