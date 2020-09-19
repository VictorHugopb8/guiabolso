package com.guiabolso.seletiva.transactionmock.transaction.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class DescriptionGeneratorServiceImpl implements DescriptionGeneratorService {

    @Override
    public String generate(int transactionsQtd, boolean isDuplication, String duplicatedDescription) {
        if (!isDuplication) {
            StringBuilder generatedString = new StringBuilder();
            Random vowelRandom = new Random();
            List<String> vowels = Arrays.asList("97", "101", "105", "111", "117");
            int targetStringLength = 10;
            int qtdWords = 5;

            // Setting words quantity in description
            if (transactionsQtd > 9 && transactionsQtd <= 60) {
                qtdWords = transactionsQtd / targetStringLength;
            } else if (transactionsQtd <= 9) {
                qtdWords = transactionsQtd;
            }

            int leftLimit;
            int rightLimit = 122; // letter 'z'
            for (int num = 0; num < qtdWords * targetStringLength && generatedString.length() <= 60; num++) {
                if (num % 2 != 0) {     // Get vowel
                    leftLimit = new Integer(vowels.get(vowelRandom.nextInt(4)));// letter 'a'
                    generatedString.append(generateLetter(leftLimit, rightLimit, vowels, true));
                } else {     // Get consonant
                    leftLimit = 98;
                    generatedString.append(generateLetter(leftLimit, rightLimit, vowels, false));
                }

                // Setting space character in description words
                String lastLetter = generatedString.substring(generatedString.length() - 1);
                if ((lastLetter.equals("a") || lastLetter.equals("e") || lastLetter.equals("i") ||
                        lastLetter.equals("o") || lastLetter.equals("u")) && num % 4 == 0 && qtdWords > 1
                ) {
                    generatedString.append(" ");
                }
            }
            return generatedString.toString().trim();
        }

        return duplicatedDescription;
    }

    private String generateLetter(int leftLimit, int rightLimit, List<String> vowels, boolean isVowel) {
        Random random = new Random();
        return random.ints(
                vowels.contains(String.valueOf(leftLimit)) && isVowel
                        ? leftLimit
                        : leftLimit + 1,
                isVowel ? leftLimit + 1 : rightLimit + 1
        )
        .limit(1)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    }

}
