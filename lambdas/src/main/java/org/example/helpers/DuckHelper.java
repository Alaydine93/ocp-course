package org.example.helpers;

import org.example.interfaces.LearnToSpeak;

public class DuckHelper {

    public static void teacher(String name, LearnToSpeak trainer){
        trainer.speak(name);
    }
}
