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
        long aikaAlussa = System.nanoTime();
        astar.search();
        long aikaLopussa = System.nanoTime();
        System.out.println("Aikaa kului: " + (aikaLopussa - aikaAlussa) + "ns.");

        Astar2 astar2;
        astar2 = new Astar2(labyrintti, labyrintti.getStart(), labyrintti.getGoal());
        long aikaAlussa2 = System.nanoTime();
        boolean tulos = astar2.searchKeko();
        labyrintti.visualisoiPolku(astar2.getPolku());
        long aikaLopussa2 = System.nanoTime();
        System.out.println("Aikaa kului: " + (aikaLopussa2 - aikaAlussa2) + "ns.");
    }
}
