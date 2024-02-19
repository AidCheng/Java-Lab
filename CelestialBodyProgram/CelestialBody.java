package CelestialBodyProgram;

import java.util.ArrayList;

public class CelestialBody {
    private String name;
    private Double massKg;
    private Double radiusKm;
    private Double combinedMassKg = massKg;
    private Double radiusFromParentAU;
    private CelestialBody orbitedBody;

    ArrayList<CelestialBody> bodiesOnOrbit = new ArrayList<>();

    // initialiser
    public CelestialBody(String name, Double massKg, Double radiusKm){
        this.name = name;
        this.massKg = massKg;
        this.radiusKm = radiusKm;
    }    

    public CelestialBody(String name, Double massKg, Double radiusKm, Double radiusFromParentAU){
        this.name = name;
        this.massKg = massKg;
        this.radiusKm = radiusKm;
        this.radiusFromParentAU = radiusFromParentAU;
    }

    // getter
    public String getName(){
        return name;
    }

    public Double getRadiusFromParentKm(){
        return radiusFromParentAU;
    }

    public Double getMassKg(){
        return massKg;
    }

    public Double getCombinedMassKg(){
        return combinedMassKg;
    }

    public String toString(){
        String celestialBodyInformation = 
            "Name: " + name + "  " +
            "Radius " + radiusKm + " km " +
            "Mass: " + massKg + " kg " +
            "Radius from parent " + orbitedBody.name + 
            " is " + radiusFromParentAU + " AU ";
        return celestialBodyInformation;
    }

    public void addToOrbit(CelestialBody newOrbiter, Double radius){
        if (newOrbiter == null){
            throw new IllegalArgumentException("Invalid input parameters");
        }
        bodiesOnOrbit.add(newOrbiter);
        newOrbiter.setBodyOrbited(this);
        combinedMassKg += newOrbiter.combinedMassKg;
    }

    public void removeFromOrbit(CelestialBody bodyToRemove){
        bodiesOnOrbit.remove(bodyToRemove);
    }

    private void setBodyOrbited(CelestialBody bodyOrbited){
        this.orbitedBody = bodyOrbited;
    }

    public void printOrbiters(){
        for (CelestialBody orbiter : bodiesOnOrbit){
            System.out.println(orbiter.toString());
        }
    }
}

