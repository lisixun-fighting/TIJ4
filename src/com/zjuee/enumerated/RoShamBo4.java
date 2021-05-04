package com.zjuee.enumerated;

import static com.zjuee.enumerated.Outcome.*;

public enum RoShamBo4 implements Competitor<RoShamBo4> {
    ROCK {
        public Outcome compete(RoShamBo4 opponent) {
            return compete(SCISSORS, opponent);
        }
    },
    SCISSORS {
        public Outcome compete(RoShamBo4 opponent) {
            return compete(PAPER, opponent);
        }
    },
    PAPER {
        public Outcome compete(RoShamBo4 opponent) {
            return compete(ROCK, opponent);
        }
    };
    Outcome compete(RoShamBo4 loser, RoShamBo4 opponent) {
        return (opponent == this) ? DRAW :
                (opponent == loser) ? WIN : LOSE;
    }
    public abstract Outcome compete(RoShamBo4 competitor);
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo4.class, 20);
    }
}
