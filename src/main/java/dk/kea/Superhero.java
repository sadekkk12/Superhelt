package dk.kea;

public class Superhero {
    private String name;
    private String superHeroName;
    private String superPower;
    private int yearOfOrigin;
    private boolean humanOrNot;
    private double Strenght;

    public Superhero(String Name, String superHeroName, String superPower, int yearOfOrigin, boolean humanOrNot, double Strength) {
        this.name = Name;
        this.superHeroName = superHeroName;
        this.superPower = superPower;
        this.yearOfOrigin = yearOfOrigin;
        this.humanOrNot = humanOrNot;
        this.Strenght = Strength;

    }

    public String getName() {
        return name;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public String setSuperHeroName(String NewSuperHeroName) {
        this.superHeroName = NewSuperHeroName;
        return superHeroName;
    }

    public String setName(String NewName) {
        this.name = NewName;
        return name;
    }

    public String setSuperPower(String NewSuperPower) {
        this.superPower = NewSuperPower;
        return superPower;
    }

    public int setYearOfOrigin(int NewYearOfOrigin) {
        this.yearOfOrigin = NewYearOfOrigin;
        return yearOfOrigin;
    }

    public boolean setHumanOrNot(boolean NewHumanOrNot) {
        this.humanOrNot = NewHumanOrNot;
        return humanOrNot;

    }

    public double setStrength(double NewStrength) {
        this.Strenght = NewStrength;
        return Strenght;
    }

    public String getSuperPower() {
        return superPower;
    }

    public int getYearOfOrigin() {
        return yearOfOrigin;
    }

    public boolean getHumanOrNot() {

        return humanOrNot;
    }

    public double getStrenght() {
        return Strenght;


    }

    public String toString() {
        return "Name:" + name +
                "\n Superhero Name: " + superHeroName +
                "\n Superpower: " + superPower +
                " \n Year Of Origin: " + yearOfOrigin +
                "\n Human Or Not: " + humanOrNot +
                " \n Strengt:" + Strenght;
    }
}
