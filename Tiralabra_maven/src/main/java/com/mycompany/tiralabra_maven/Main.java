package com.mycompany.tiralabra_maven;

/**
 * Vastaa ohjelman käynnistämisestä ja suorituskykytestauksesta.
 *
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Labyrintti labyrintti = new Labyrintti();

        omaKekoSuoritus(labyrintti);
        priorityQueueSuoritus(labyrintti);

        tulostaLabyrinttihaku();
    }

    private static void tulostaLabyrinttihaku() {
        Astar2 astar;
        Labyrintti labyrintti = new Labyrintti();
        astar = new Astar2(labyrintti);
        astar.searchKeko();
        labyrintti.visualisoiPolku(astar.getPolku());
    }

    private static void priorityQueueSuoritus(Labyrintti labyrintti) {
        System.out.println();
        System.out.println("Search Javan priority queuella 100000x:");

        long aikaAlussa = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Astar2 astar = new Astar2(labyrintti);
            astar.searchPriorityQueue();
        }
        long aikaLopussa = System.currentTimeMillis();
        System.out.println(aikaLopussa - aikaAlussa + "ms.");
    }

    private static void omaKekoSuoritus(Labyrintti labyrintti) {
        System.out.println();
        System.out.println("Search omalla keolla 100000x:");

        long aikaAlussa = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Astar2 astar = new Astar2(labyrintti);
            astar.searchKeko();
        }
        long aikaLopussa = System.currentTimeMillis();
        System.out.println(aikaLopussa - aikaAlussa + "ms.");
    }
}
