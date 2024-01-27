import java.math.BigDecimal;
import IO.Input;

class FactorialCalculator{
    /**
     * @param args
     *  Use Big Decimal Class -> Calculate Factorial Numbers of ANY SIZE
     */
    private int targetFactorial;
    private BigDecimal result = new BigDecimal(1);

    private void inputTargetFactorial(){
        Input in = new Input();
        System.out.println("Input the factorial of the number to calculate: ");
        this.targetFactorial = in.nextInt();
        in.close();        
    }

    private void calculateFactorial(){
        for(int i = 2; i <= this.targetFactorial; i++){
            this.result = this.result.multiply(BigDecimal.valueOf(i));
        } 
    }

    private void printResult(){
        System.out.println("The result is: " + this.result);
    }

    private void exec(){
        this.inputTargetFactorial();
        this.calculateFactorial();
        this.printResult();
    }

    public static void main(String[] args){
        FactorialCalculator newFactorial = new FactorialCalculator();
        newFactorial.exec(); 
    }
}
