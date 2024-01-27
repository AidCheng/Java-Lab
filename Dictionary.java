import IO.Input;
import IO.FileInput;
import java.util.HashMap;

public class Dictionary {
    private final HashMap<String,String> dictionary = new HashMap<>();
    private final String DICT_FILE_NAME = "dictionary";
    private final FileInput inFile = new FileInput(DICT_FILE_NAME);

    private String readWord(){
        return inFile.nextLine();
    }

    private String readDefinition(){
        String definition = "";
        while(inFile.hasNextLine()){
            String newLine = inFile.nextLine();
            definition += newLine + "\n";
            if(newLine.equals("")){
        	break;        
            }
        }
        return definition;
    }

    private void readDictionaryFromFile(){
        while(inFile.hasNextLine()){
            dictionary.put(readWord(),readDefinition());
        }
    }

    private String askWord(){
        Input in = new Input();
        System.out.println("The word to look up is: ");
        return in.nextLine();
    }


    private void running(){
        System.out.println(dictionary.get(askWord()));
    }

    private void exec(){
        this.readDictionaryFromFile();
        while(true){
            this.running();
        }
    }

    public static void main(String[] args){
        Dictionary newDictionaryProgram = new Dictionary();
        newDictionaryProgram.exec();
    }
}
