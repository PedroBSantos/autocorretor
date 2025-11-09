package com.google.autocorretor;

import java.util.Optional;

public class Application {

    public static void main(String[] args) {
        var corretor = new CorretorImpl();
        corretor.addToDictionary("casa");
        corretor.addToDictionary("cama");
        corretor.addToDictionary("carro");
        corretor.addToDictionary("gato");
        corretor.addToDictionary("pato");
        var proxy = new CorretorProxy(corretor);
        var keyboard = new Keyboard(proxy);
        Optional<String> closerWord = keyboard.nextMoreCloserWord("tapa");
        closerWord.ifPresent(w -> System.out.println(w));
    }
}
