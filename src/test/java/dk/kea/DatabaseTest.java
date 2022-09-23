package dk.kea;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {



    @Test
     void findHero() {
        // arrange
        Database database = new Database();
        //act
        database.createTestData();
        ArrayList<Superhero> results = database.searchEdit("batman");
        int actualSize = results.size();
        int expectedSize = 1;
        assertEquals(actualSize, expectedSize);


    }

    @Test
    void createTestData() {
        Database database = new Database();
        database.createTestData();
        ArrayList<Superhero> results = database.getSuperheroes();

        int actualSize = results.size();
        int expectedSize= 2;
        assertEquals(actualSize,expectedSize);


    }

    @Test
    void createSuperhero() {
    }

    @Test
    void getSuperheroes() {
    }

    @Test
    void searchEdit() {
    }
    /* @Test
    void deleteSuperHero(){

        ArrayList<Superhero> results = database.getallheroes();
        Superhero superhero = results.get(0);
        boolean actualResult  database.deleteSuperhero (superhero);
        boolean expectedResult = true;
        assertEquals(actualResult,expectedResult);
        int expectedSize = results.size()-1;
        ArrayList<Superhero> resultAfterDelete = database.getAllheroes
                int actualSize = resultAfterDelete.size();
        --
        ArrayList<Superhero> Searhfor (String searchterm){
            ArrayList<Superhero> searchresults = new ArrayList<>();
            for (Superhero superhero: superheroes){
                if (superhero.getName().toLowerCase())


            }


        }

     */
    }
