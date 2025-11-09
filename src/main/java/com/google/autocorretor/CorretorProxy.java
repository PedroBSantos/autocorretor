package com.google.autocorretor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CorretorProxy implements Corretor {

    private CorretorImpl corretor;
    private Map<String, Optional<WordSyntaxDistance>> previousCalculatedDistances;

    public CorretorProxy(CorretorImpl corretor) {
        this.corretor = corretor;
        this.previousCalculatedDistances = new HashMap<>();
    }

    @Override
    public Optional<WordSyntaxDistance> correctWord(String input) {
        Optional<WordSyntaxDistance> previousDistance = this.previousCalculatedDistances.get(input);
        if (previousDistance != null)
            return previousDistance;
        Optional<WordSyntaxDistance> distance = this.corretor.correctWord(input);
        this.previousCalculatedDistances.put(input, distance);
        return distance;
    }
}
