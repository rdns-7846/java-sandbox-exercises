package nl.codecraftr.sandbox.yahtzee;

import java.util.List;

public class Die {

    private List<Integer> roll;

    public Die(List<Integer> roll) {
        this.roll = roll;
    }

    public List<Integer> getRoll() {
        return roll;
    }
}
