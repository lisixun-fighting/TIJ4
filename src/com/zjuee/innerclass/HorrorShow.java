package com.zjuee.innerclass;

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    public void menace() {}
    public void destroy() {}
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    public void menace() {}
    public void destroy() {}
    public void kill() {}
    public void drinkBlood() {}
}


public class HorrorShow {
    DangerousMonster dm = new DangerousMonster() {
        public void destroy() {}
        public void menace() {}
    };
    Vampire v = new Vampire() {
        public void drinkBlood() {}
        public void destroy() {}
        public void kill() {}
        public void menace() {}
    };
}
