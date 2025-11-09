package com.google.autocorretor;

public class WordSyntaxDistance {
    
    private String from;
    private String to;
    private int syntaxDistance;

    public WordSyntaxDistance(String from, String to, int syntaxDistance) {
        this.from = from;
        this.to = to;
        this.syntaxDistance = syntaxDistance;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getSyntaxDistance() {
        return syntaxDistance;
    }
}
