package com.zjuee.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}

public class AsListInterface {
    public static void main(String[] args) {
        List<Snow> snows = Arrays.<Snow>asList(new Light(), new Heavy());
        List<Snow> snows2 = new ArrayList<>(Arrays.asList(new Light(), new Heavy()));
    }
}
