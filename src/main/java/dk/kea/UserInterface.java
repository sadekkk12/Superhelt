package dk.kea;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class UserInterface {
    Database database = new Database();
    Scanner scanner = new Scanner(System.in);
    int menuvalg;

    public void startup() {


        Database database = new Database();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Velkommen til SuperHeroCreator!");
        int menuvalg;
        brugerValg();

    }

    public void brugerValg() {

        database.createTestData();
        do {
            Menu();

            if (menuvalg == 1) {
                opretHero();


            } else if (menuvalg == 2) {
                getAllHeroes();


            } else if (menuvalg == 3) {
                searchHero();


            } else if (menuvalg == 4) {
                searchAndEdit();

            }
            else if(menuvalg == 5){
                searchAndRemove();
            }

            else if (menuvalg == 9) {
                System.out.println("Programmet afsluttes");


            }
        }
        while (menuvalg != 9);


    }

    public void Menu() {
        System.out.println("1) for at oprette ny SuperHero");
        System.out.println("2) for at se alle Superheroes");
        System.out.println("3) for at søge ");
        System.out.println("4) for at EditHero");
        System.out.println("5) for at slette Superhero");

        System.out.println("9) for at afslutte");
        menuvalg = scanner.nextInt();
        scanner.nextLine();

    }

    public void opretHero() {
        boolean humanOrNot = true;
        System.out.println("Opret en superhelt!");
        System.out.println("indtast Superheltens navn");
        String name = scanner.next();
        System.out.println("indtast superheltens virkelige navn");
        String superHeroName = scanner.next();
        System.out.println("indtast superheltens superkraft");
        String superPower = scanner.next();
        System.out.println("indtast superheltens oprindelses år");
        int yearOfOrigin = scanner.nextInt();


        //check om vi har et svar der kan bruges
        boolean checkSvar = true;
        //gentag til vi for et svar der kan bruges
        do {
            System.out.println("Er superhelten menneske? indtast y eller n.");
            //bed om et svar
            String race = scanner.next();

            if (race.equalsIgnoreCase("y")) {
                //y vi humanOrNot er true
                humanOrNot = true;
                //vi har et svar der kan bruges
                checkSvar = false;
            } else if (race.equalsIgnoreCase("n")) {
                //humanOrNot er false
                humanOrNot = false;
                //vi har et svar der kan bruges
                checkSvar = false;
            } else {
                //vi fik ikke et svar der kan bruges, så den skal gentage
                System.out.println("invalid indtastning. prøv igen, indtast y eller n");
            }
        } while (checkSvar == true);

        System.out.println("Indtast superheltens styrke i tal");
        double Strength = scanner.nextDouble();
        database.createSuperhero(name, superHeroName, superPower, yearOfOrigin, humanOrNot, Strength);

    }

    public void getAllHeroes() {
        for (Object Superheroes : database.getSuperheroes()) {
            System.out.println(Superheroes);

        }
    }

    public void searchHero() {
        System.out.println("indtast søgning");
        String searchTerm = scanner.nextLine();
        //vi søger i databasen og ser om findhero er tom og vis den ikke er køre vi den
        if (database.findHero(searchTerm) != null) {
            System.out.println("Superhero fundet:" + database.findHero(searchTerm));
            //vi den er tom køre vi else
        } else {
            System.out.println("kunne ikke finde helt i database");
        }
    }

    public void searchAndEdit() {
        //bed om et søge ord
        System.out.println("Søg efter superhero! indtast navnet på helten du søger");
        //tage søge ord fra scanner
        String searchTerm = scanner.next();
        // giv søge ord til ArraList
        ArrayList<Superhero> searchResult = database.searchEdit(searchTerm);
        //give søge ord til metoden searchEdit
        database.searchEdit(searchTerm);
        //try og catch brugerens valg af superhelt passer med den nye ArrayList
        try {
            //bed om valg af superhelt at redigere
            System.out.println("tryk på nummeret der passer til helten");
            //få nummeret der passer til superhelten i ArrayList
            int nummer = scanner.nextInt();
            //minus brugerens valg med 1 da index starter fra 0
            Superhero editHero = searchResult.get(nummer - 1);
            //angiv den helt brugeren redigere
            System.out.println("rediger helt: " + editHero);
            System.out.println("");

            //kopi her fra
            //bed om et nyt navn til superhelten
            System.out.println("angiv nyt Superhero navn til helten");
            String NewSuperHeroName = scanner.nextLine(); //scanner bug
            NewSuperHeroName = scanner.nextLine(); // få det nye navn
            if (!NewSuperHeroName.isEmpty()) { //hvis det nye navn er tomt lader vi det gamle stå
                editHero.setSuperHeroName(NewSuperHeroName); //overskriv det nye navn til superhelten
            }

            System.out.println("angiv nyt navn til helten");
            String NewName = scanner.nextLine(); //få det nye navn
            if (!NewName.isEmpty()) { //hvis det nye navn er tomt lader vi det gamle stå
                editHero.setName(NewName); //overskriv det nye navn til superhelten
            }


            System.out.println("angiv nyt superrpower");
            String NewSuperPower = scanner.nextLine(); //få det nye navn
            if (!NewSuperPower.isEmpty()) { //hvis det nye navn er tomt lader vi det gamle stå
                editHero.setSuperPower(NewSuperPower); //overskriv det nye navn til superhelten
            }

            System.out.println("angiv nyt YearOfOrigin");
            try {
                String NewYearOfOrigin = scanner.nextLine(); //få det nye navn
                if (!NewYearOfOrigin.isEmpty()) { //hvis det nye navn er tomt lader vi det gamle stå
                    //vi bruger Interher.parseInt til at lave en string om til int
                    editHero.setYearOfOrigin(Integer.parseInt(NewYearOfOrigin)); //overskriv det nye navn til superhelten
                }
            } catch (NumberFormatException e) {
                System.out.println("du angav ikke et årstal");
            }


            System.out.println("er helten menneske? true eller false");
            try {
                String NewHumanOrNot = scanner.next(); //få det nye navn
                if (!NewHumanOrNot.isEmpty()) { //hvis det nye navn er tomt lader vi det gamle stå
                    //vi lave en string om til en boolean
                    editHero.setHumanOrNot(Boolean.parseBoolean(NewHumanOrNot)); //overskriv det nye navn til superhelten
                }
            } catch (NumberFormatException e) {
                System.out.println("du angav ikke true eller false");
            }

            System.out.println("angiv heltens styrke i tal"); //den her manglede
            String NewStrength = scanner.nextLine(); //scanner bug
            NewStrength = scanner.nextLine(); //få ny styrke
            try {
                if (!NewStrength.isEmpty()) { //hvis det nye navn er tomt lader vi det gamle stå
                    //vi bruger Interher.parseInt til at lave en string om til int
                    editHero.setStrength(Integer.parseInt(NewStrength)); //overskriv det nye navn til superhelten
                }
            } catch (NumberFormatException e) {
                System.out.println("du angav ikk et tal");
            }

        } catch (InputMismatchException e) { //hvis brugeren ikke vælger en helt fra ArrayListen kør catch
            System.out.println("kunne ikke bruge værdig");
        }
    }
    public void searchAndRemove(){
        System.out.println("indtast navnet på Superheroen du vil slette");
        String removedSuperhero = scanner.nextLine();
        ArrayList<Superhero> searchRemove = database.searchRemove(removedSuperhero);
        database.searchRemove(removedSuperhero);
        {

        }






    }
}



