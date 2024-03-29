package AddressBookProgram;
import IO.Input;

final class Mode{
    public static final String END = "0";
    public static final String ADD = "1";
    public static final String REMOVE = "2";
    public static final String SEARCH = "3";
}

public class AddressBookSystem {
    private AddressBook newBook = new AddressBook();
    private String mode;
    private final Input in = new Input();

    private void chooseMode(){
        printUIForModes();
        inputMode();
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
            default -> {System.out.println("Wrong Input, Mode " + mode + " does not exist");}
        }
    }

    private void handleAddMode(){
        AddressBookEntry newEntry = newBookEntryToAdd();
        newBook.addEntry(newEntry);
    }

    private AddressBookEntry newBookEntryToAdd(){
        System.out.println("Name: ");
        String name = in.nextLine();

        System.out.println("Phone: ");
        String phone = in.nextLine();

        System.out.println("Email: ");
        String email = in.nextLine();

        return new AddressBookEntry(name, phone, email);
    }

    private void handleRemoveMode(){
        String name = nameOfEntryToRemove();
        newBook.removeEntry("name", name);
    }

    private String nameOfEntryToRemove(){
        System.out.println("Name of entry to remove: ");
        return in.nextLine();
    }

    private void handleSearchMode(){
        String name = nameToSearch();
        newBook.searchInformation("name", name);
    }

    private String nameToSearch(){
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
        AddressBookSystem newAddressProgram = new AddressBookSystem();
        newAddressProgram.exec();
    }
}
