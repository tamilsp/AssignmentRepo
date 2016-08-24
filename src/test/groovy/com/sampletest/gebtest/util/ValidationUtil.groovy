package com.sampletest.gebtest.util

/**
 * Created by tamils on 12/08/2016.
 */
class ValidationUtil {

    private ArrayList<String> results = new ArrayList<String>()

    public  def validate(boolean condition, String message) {
        if (!condition) results.add(message)
        return this
    }
}
