package AddressBookProgram;
import IO.Input;

public class AddressBookMain {
    private Boolean exit = false;
    private AddressBook newBook = new AddressBook();

    private Boolean checkExit(){
        
    }

    private void exec(){
        while(true){
            
            exit = checkExit();
            if(exit){
                break;
            }
        }
    }

    public static void main(String[] args){
        AddressBookMain newAddressProgram = new AddressBookMain();
        newAddressProgram.exec();
    }
}
