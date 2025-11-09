package com.google.autocorretor;

import java.util.Optional;

public class Keyboard {
    
    private Corretor corretor;

    public Keyboard(Corretor corretor) {
        this.corretor = corretor;
    }

    public Optional<String> nextMoreCloserWord(String input) {
        Optional<WordSyntaxDistance> distance = this.corretor.correctWord(input);
        return distance.flatMap(d -> Optional.of(d.getTo()));
    }
}
