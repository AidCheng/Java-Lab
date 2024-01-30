package RangeProgram;

import java.util.ArrayList;

public class Range {
    private int lower;
    private int upper;

    public Range(int lower, int upper){
        this.lower = lower;
        this.upper = upper;
    }

    public int getLower(){
        return lower;
    }

    public int getUpper(){
        return upper;
    }

    public boolean contains(int n){
        return (n >= lower && n <= upper);
    }

    public ArrayList<Integer> getValues(){
        ArrayList<Integer> listOfValuesInRange = new ArrayList<>();
        for (int i = lower; i <= upper; i++){
            listOfValuesInRange.add(i);
        }
        return listOfValuesInRange;
    }

}

