package com.google.autocorretor;

import java.util.Optional;

public interface Corretor {
    
    Optional<WordSyntaxDistance> correctWord(String input);
}
