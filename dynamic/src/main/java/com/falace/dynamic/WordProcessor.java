package com.falace.dynamic;

class WordProcessor {

    String capitalize(String word) {
        String firstCharUppercase = String.valueOf(word.charAt(0)).toUpperCase();
        return firstCharUppercase + word.substring(1);
    }

}