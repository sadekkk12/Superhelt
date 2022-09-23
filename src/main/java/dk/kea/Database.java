package dk.kea;

import javax.xml.crypto.Data;
import javax.xml.namespace.QName;
import java.util.ArrayList;

public class Database {

    private ArrayList<Superhero> superheroes = new ArrayList<>();
    private ArrayList<Superhero> searchResult = new ArrayList<>();
    private ArrayList<Superhero> searchRemove = new ArrayList<>();

    private int index = 0;

    public void createTestData() {
        createSuperhero("Bruce Wayne", "Batman", "money", 1939, true, 100);
        createSuperhero("Clark Kent", "Superman", "laser beam", 1950, false, 900000);

    }


    public void createSuperhero(String Name, String superHeroName, String superPower, int yearOfOrigin, boolean humanOrNot, double Strength) {
        Superhero hero = new Superhero(Name, superHeroName, superPower, yearOfOrigin, humanOrNot, Strength);
        superheroes.add(hero);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;

    }

    public Superhero findHero(String superHeroName) {
        // boolean fundet = false;
        for (Superhero searchFor : superheroes) {
            if (searchFor.getSuperHeroName().toLowerCase().contains(superHeroName.toLowerCase()))
                return searchFor;
        }
        return null;
    }

    //vi laver en metoder som skal retunere ArraList searchEdit
    public ArrayList<Superhero> searchEdit(String searchTerm) {
        //for hvert element i superhero skal vi finde sørge ord
        for (Superhero søgehero : superheroes) {
            //tager navne fra Superhero class og gemme dem som string
            String name = søgehero.getSuperHeroName().toLowerCase();
            //ser om superhelten navn passer søgening
            if (name.contains(searchTerm)) {
                //ser om element er i liste før tilførger
                if (!searchResult.contains(søgehero)) {
                    //add element : men add 2 gange?
                    searchResult.add(søgehero);
                }
            }

            for (int i = 0; i < searchResult.size(); i++)
                System.out.println(i + 1 + ":" + searchResult.get(i));
        }
        return searchResult;
    }

    public ArrayList<Superhero> searchRemove(String superHeroName) {
        for (Superhero søgeheroSlet : superheroes) {
            //tager navne fra Superhero class og gemme dem som string
            String name = søgeheroSlet.getSuperHeroName().toLowerCase();
            //ser om superhelten navn passer søgening
            if (name.contains(superHeroName)) {
                //ser om element er i liste før tilførger
                if (!searchRemove.contains(søgeheroSlet)) {
                    //add element : men add 2 gange?
                    searchRemove.remove(søgeheroSlet);
                }
            }
        }
        return searchRemove;
    }
}