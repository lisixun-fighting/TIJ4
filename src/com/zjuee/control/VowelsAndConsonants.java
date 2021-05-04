package com.zjuee.control;

import java.util.Arrays;

public enum VowelsAndConsonants {
    VOWELS(Letter.Vowels.class), SOMETIME_A_VOWEL(Letter.Consonants.class), CONSONANTS(Letter.Consonants.class);
    interface Letter {
        enum Vowels implements Letter {
            A, E, I, O, U
        }
        enum Consonants implements Letter {
            C, B, N, M, V, Y
        }
        enum SometimesAVowel implements Letter {
            Q, W, T, R
        }
    }
    Letter[] values;
    VowelsAndConsonants(Class<? extends Letter> enumClass) {
        this.values = enumClass.getEnumConstants();
    }

    public static void main(String[] args) {
        for (VowelsAndConsonants vac : VowelsAndConsonants.values()) {
            System.out.println(Arrays.toString(vac.values));
        }
    }
}
