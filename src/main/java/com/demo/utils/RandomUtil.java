package com.demo.utils;

import java.util.List;
import java.util.Random;

public class RandomUtil {

    /**
     * @Title: randomResult
     * @Description: get ramdom result from specifiec resultList
     */
    public static <T> T randomResult(List<T> result){
        Random random = new Random();
        int min = 0;
        int randomIndex = (random.nextInt((result.size() - min)) + min);
        return result.get(randomIndex);
    }
}
