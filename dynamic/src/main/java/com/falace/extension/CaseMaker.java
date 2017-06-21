package com.falace.extension;

import java.util.List;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public class CaseMaker {

    private static final String SPACE = " ";

    private CaseMode caseMode;


    public String changeCase(String text) {
        List<String> words = asList(text.split(SPACE));
        switch (caseMode) {
            case ALL_UPPERCASE:
                return words.stream()
                        .map(String::toUpperCase)
                        .collect(joining(SPACE));
            case FIRST_CHAR:
            default:
                return words
                        .stream()
                        .map(word -> {
                                    String firstCharUppercase = String.valueOf(word.charAt(0)).toUpperCase();
                                    return firstCharUppercase + word.substring(1);
                                }
                        )
                        .collect(joining(SPACE));
        }
    }


    CaseMode getCaseMode() {
        return caseMode;
    }

    void setCaseMode(CaseMode caseMode) {
        this.caseMode = caseMode;
    }

}