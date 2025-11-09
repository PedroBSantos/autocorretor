package com.google.autocorretor;

public class Levenshtein {

    public int[][] calculateDistance(String origin, String target) {
        int[][] operations = new int[origin.length() + 1][target.length() + 1];
        for (int i = 0; i <= origin.length(); i++)
            operations[i][0] = i;
        for (int i = 0; i <= target.length(); i++)
            operations[0][i] = i;
        int cost = 0;
        for (int i = 1; i <= origin.length(); i++) {
            for (int j = 1; j <= target.length(); j++) {
                cost = (origin.charAt(i - 1) == target.charAt(j - 1)) ? 0 : 1;
                int deletion = operations[i - 1][j] + 1;
                int insertion = operations[i][j - 1] + 1;
                int substitution = operations[i - 1][j - 1] + cost;
                operations[i][j] = Math.min(Math.min(deletion, insertion), substitution);
            }
        }
        return operations;
    }
}
