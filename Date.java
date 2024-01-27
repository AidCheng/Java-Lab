import IO.Input;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {
    private int year, day, month;
    private Input in = new Input();
    private void inputDay(){
        System.out.print("Input the day: ");
        this.day = in.nextInt();
    }

    private void inputMonth(){
        System.out.print("Input the month: ");
        this.month = in.nextInt();
    }

    private void inputYear(){
        System.out.print("Input the year: ");
        this.year = in.nextInt();
    } 
    private void inputDate(){
        this.inputDay();
        this.inputMonth();
        this.inputYear();
    }

    private void formatDate(){
        Calendar newDate = Calendar.getInstance();
        DateFormat newFormat = new SimpleDateFormat("dd-MM-yyyy");
        newDate.set(this.year, this.month, this.day); 
        System.out.println("Calendar Class: The Date is " + newDate.getTime());
        String formatedDate = newFormat.format(newDate.getTime());
        System.out.println("DateFormat Class (D/M/Y) : The Date is " + formatedDate);
    }


    private void exec(){
        this.inputDate();
        this.formatDate();
    }

    public static void main(String[] args) {
        Date dates = new Date();
        dates.exec();
    }
}
