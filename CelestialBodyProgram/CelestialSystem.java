package CelestialBodyProgram;

import java.util.ArrayList;
import IO.FileInput;

class dataType{
    static int Name = 0;
    static int Mass = 1;
    static int Radius = 2;
    static int RadiusToParent = 3;
    static int Parent= 4;
}

public class CelestialSystem {
    // Features = [Name, Mass, Rad, RadToParent, Parent]
    private final String fileName = "solar_system.csv";
    ArrayList<CelestialBody> newSystem;
    FileInput inFile = new FileInput(fileName);

    private void readFile(){
        // String head = inFile.nextLine();
        readCelestialBodies();
    }

    private void readCelestialBodies(){
        while(inFile.hasNextLine()){
            readCelestialBodyFromLine(inFile.nextLine());
        }
    }

    private void readCelestialBodyFromLine(String line){
        ArrayList<String> newCelestialBodyInList = new ArrayList<>();
        String newLine = line;
        for(int i=0; i < line.length(); i ++){
            String newFeature = "";
            while(newLine.charAt(i) != ','){
                newFeature += newLine.charAt(i);
            }
            newCelestialBodyInList.add(newFeature);
        }
        createNewCelestialBody(newCelestialBodyInList);
    }

    private CelestialBody createNewCelestialBody(ArrayList<String> list){
        String name = list.get(dataType.Name);
        Double mass = Double.parseDouble(list.get(dataType.Mass));
        Double radius = Double.parseDouble(list.get(dataType.Radius));
        Double radiusFromParentAU = Double.parseDouble(list.get(dataType.RadiusToParent));
        
        CelestialBody newBody = new CelestialBody(name, mass, radius, radiusFromParentAU);
        if (list.get(dataType.Parent) != null){
            setOrbitedBody(newBody, list.get(dataType.Parent));
        }
        return newBody;
    }

    private void setOrbitedBody(CelestialBody newCB, String Parent){
        for(CelestialBody eachCB: newSystem){
            if (eachCB.getName().equals(Parent)){
                eachCB.addToOrbit(newCB, newCB.getRadiusFromParentKm());
            } else {
                throw new NullPointerException("Parent not found");
            }
        }
    }

    private void recordSolarSystem(){
        readFile();
    }

    public static void main(String[] args){
        CelestialSystem solarSystem = new CelestialSystem();
        solarSystem.recordSolarSystem();
    }
}
