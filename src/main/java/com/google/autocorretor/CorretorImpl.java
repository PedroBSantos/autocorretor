package com.google.autocorretor;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CorretorImpl implements Corretor {

    private static final int MIN_ACCEPTABLE_SYNTAX_DISTANCE = 2;
    private Levenshtein wordSyntaxDistanceCalculator;
    private Set<String> dictionary;

    public CorretorImpl() {
        this.dictionary = new HashSet<>();
        this.wordSyntaxDistanceCalculator = new Levenshtein();
    }

    public void addToDictionary(String word) {
        this.dictionary.add(word);
    }

    @Override
    public Optional<WordSyntaxDistance> correctWord(String input) {
        if (this.dictionary.contains(input))
            return Optional.of(new WordSyntaxDistance(input, input, 0));
        Optional<WordSyntaxDistance> wordDistance = this.dictionary.stream()
            .map(s -> {
                int[][] operations = this.wordSyntaxDistanceCalculator.calculateDistance(input, s);
                int wordsSyntaxProx = operations[input.length()][s.length()];
                return new WordSyntaxDistance(input, s, wordsSyntaxProx);
            })
            .filter(p -> p.getSyntaxDistance() <= MIN_ACCEPTABLE_SYNTAX_DISTANCE)
            .findFirst();
        return wordDistance;
    }
}
