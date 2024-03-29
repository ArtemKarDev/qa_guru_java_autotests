package utils;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {


    public static void main(String[] args) {

    }

    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min,max+1);
    }
    public static String getRandomPhone(){
        return String.format("%s"+"%s"+"%s",getRandomInt(901,999),getRandomInt(901,999),getRandomInt(1111,9999));
    }

    public static String getRandomItem(String[] array) {
        Random random = new Random();
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
    }


}


