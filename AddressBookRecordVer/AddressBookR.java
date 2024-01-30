package AddressBookRecordVer;
import java.util.ArrayList;

public class AddressBookR {
    private ArrayList<AddressBookEntryR> addressBook = new ArrayList<>();
    
    public void addEntry(AddressBookEntryR newEntry){
        addressBook.add(newEntry);
    }

    public void removeEntry(String identifier){
        AddressBookEntryR entryToRemove = entryContainsIdentifier(identifier);
        if(entryToRemove != null){
            addressBook.remove(entryToRemove);
        } else {
            System.out.println("The given identifier / type is not found\n");
        }
    } 

    public void searchInformation(String identifier){
        AddressBookEntryR targetEntry = entryContainsIdentifier(identifier);
        if (targetEntry != null){
            outputInfoOfTargetEntry(targetEntry);
        } else {
            System.out.println("The entry is not found in the book, plaese try again\n");
        }
    }

    private void outputInfoOfTargetEntry(AddressBookEntryR targetEntry){
        System.out.println("name: " + targetEntry.name());
        System.out.println("phone: " + targetEntry.phone());
        System.out.println("email: " + targetEntry.email() + "\n");
    }

    private AddressBookEntryR entryContainsIdentifier(String identifier){
        for(AddressBookEntryR entry : addressBook){
            if(entry.name().equals(identifier)){
                        return entry;
            }
        }
        // not found
        return null;
    }
}
