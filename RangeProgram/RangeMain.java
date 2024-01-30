package RangeProgram;
import java.util.ArrayList;

import IO.Input;

public class RangeMain {
    Input in = new Input();
    private Range range;


    private void setRange(){
        System.out.println("Lower bound: ");
        int low = in.nextInt();
        System.out.println("upper bound: ");
        int upper = in.nextInt(); 
        range = new Range(low, upper);
    }

    private void getRange(){
        System.out.println(range.getLower());
        System.out.println(range.getUpper());
    }

    private void checkContains(){
        System.out.println("Enter the number you want to check");
        int val = in.nextInt();
        if (range.contains(val)){
            System.out.println("In range\n");
        } else {
            System.out.println("Not in range\n");
        }
    }

    private void getValues(){
        ArrayList<Integer> listOfRange = range.getValues();
        for (int val: listOfRange){
            System.out.print(val + " ");
        }
    }

    private void exec(){
        setRange();
        getRange();
        checkContains();
        getValues();
    }
    public static void main(String[] args){
        RangeMain newRangeProgram = new RangeMain();
        newRangeProgram.exec();
    }    
}
