package com.zjuee.enumerated;

import static com.zjuee.enumerated.Outcome.*;

public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW, LOSE, WIN),
    SCISSORS(WIN, DRAW, LOSE),
    ROCK(LOSE, WIN, DRAW);
    Outcome vPAPER;
    Outcome vSCISSORS;
    Outcome vROCK;
    private RoShamBo2(Outcome paper, Outcome scissors, Outcome rock) {
        vPAPER = paper;
        vSCISSORS = scissors;
        vROCK = rock;
    }
    @Override
    public Outcome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER: return vPAPER;
            case SCISSORS: return vSCISSORS;
            case ROCK: return vROCK;
        }
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
