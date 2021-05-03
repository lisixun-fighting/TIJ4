package com.zjuee.exceptions;

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}
abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    public StormyInning() throws BaseballException, RainedOut {
    }
    public void event() {}
    public void atBat() throws PopFoul {}
    public void rainHard() throws RainedOut {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            e.printStackTrace();
        } catch (RainedOut e) {
            e.printStackTrace();
        } catch (BaseballException e) {
            e.printStackTrace();
        }
    }
}
