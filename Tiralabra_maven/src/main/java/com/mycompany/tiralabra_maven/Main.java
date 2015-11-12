package com.mycompany.tiralabra_maven;

/**
 * Vastaa ohjelman käynnistämisestä
 *
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // Luodaan labyrintti
        Labyrintti labyrintti = new Labyrintti(7);

        // Tulostetaan labyrintti luettavasa muodossa
        labyrintti.visualisoi();

        // labyrintti.tulosta();
        Astar astar;
        astar = new Astar(labyrintti, labyrintti.getStart(), labyrintti.getGoal());
        //Etsii ja tulostaa lyhimmän reitin
        astar.search();
    }
}
