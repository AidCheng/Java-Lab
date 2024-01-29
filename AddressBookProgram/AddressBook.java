package AddressBookProgram;
import java.util.ArrayList;

public class AddressBook {
    private ArrayList<AddressBookEntry> addressBook = new ArrayList<>();
    
    public void addEntry(AddressBookEntry newEntry){
        addressBook.add(newEntry);
    }

    public void removeEntry(String typeOfIdentifier, String identifier){
        AddressBookEntry entryToRemove = entryContainsIdentifier(typeOfIdentifier,identifier);
        if(entryToRemove != null){
            addressBook.remove(entryToRemove);
        } else {
            System.out.println("The given identifier / type is not found");
        }
    } 

    public void searchInformation(String typeOfIdentifier, String identifier){
        AddressBookEntry targetEntry = entryContainsIdentifier(typeOfIdentifier, identifier);
        outputInfoOfTargetEntry(targetEntry);
    }

    private void outputInfoOfTargetEntry(AddressBookEntry targetEntry){
        System.out.println("name: " + targetEntry.getName());
        System.out.println("phone" + targetEntry.getPhone());
        System.out.println("email " + targetEntry.getEmail());
    }

    private AddressBookEntry entryContainsIdentifier(String typeOfIdentifier, String identifier){
        for(AddressBookEntry entry : addressBook){
            switch (typeOfIdentifier) {
                case "name" -> 
                    {if(entry.getName().equals(identifier)){
                        return entry;
                    }}
                case "phone" ->
                    {if(entry.getPhone().equals(identifier)){
                    return entry;
                    }}
                case "email" ->
                    {if(entry.getEmail().equals(identifier)){
                        return entry;
                    }}
            }
        }
        // not found
        return null;
    }
}
