package AddressBookRecordVer;
import IO.Input;

final class Mode{
    public static final String END = "0";
    public static final String ADD = "1";
    public static final String REMOVE = "2";
    public static final String SEARCH = "3";
}

public class AddressBookSystemR{
    private AddressBookR newBook = new AddressBookR();
    private String mode;
    private final Input in = new Input();

    private void chooseMode(){
        printUIForModes();
        inputMode();
        System.out.println();
    }

    private void printUIForModes(){
        System.out.println(
            """
            Please choose your operation (input by number):
            0. Exit Program
            1. Add new entry to the address book
            2. Remove entry from program
            3. Search for an existing entry info. in the book
            """);
    }

    private void inputMode(){
        mode = in.nextLine();
    }

    private void handleDifferentMode(){
        switch (mode) {
            case Mode.ADD -> handleAddMode();
            case Mode.REMOVE -> handleRemoveMode();
            case Mode.SEARCH -> handleSearchMode();
            default -> {System.out.println("Wrong Input, Mode " + mode + " does not exist\n");}
        }
    }

    private void handleAddMode(){
        System.out.print("Name: ");
        String name = in.nextLine();

        System.out.print("Phone: ");
        String phone = in.nextLine();

        System.out.print("Email: ");
        String email = in.nextLine();

        AddressBookEntryR newEntry = new AddressBookEntryR(name, phone, email);
        newBook.addEntry(newEntry);
    }

    private void handleRemoveMode(){
        String name = getNameOfEntryToRemove();
        newBook.removeEntry(name);
    }

    private String getNameOfEntryToRemove(){
        System.out.println("Name of entry to remove: ");
        return in.nextLine();
    }

    private void handleSearchMode(){
        String name = getNameToSearch();
        newBook.searchInformation(name);
    }

    private String getNameToSearch(){
        System.out.println("Name of entry to seach: ");
        return in.nextLine();
    }
    
    private void exec(){
        while(true){
            chooseMode();
            if (mode.equals(Mode.END)){
                break;
            } else {
                handleDifferentMode();
            }
        }
    }

    public static void main(String[] args){
        AddressBookSystemR newAddressProgram = new AddressBookSystemR();
        newAddressProgram.exec();
    }
}
