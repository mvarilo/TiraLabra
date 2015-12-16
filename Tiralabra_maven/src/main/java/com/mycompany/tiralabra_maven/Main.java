package com.mycompany.tiralabra_maven;

import java.util.Scanner;

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
        lukija();

//        omaKekoSuoritus(labyrintti);
//        priorityQueueSuoritus(labyrintti);
//
//        tulostaLabyrinttihaku();
    }

    private static void tulostaKeko() {
        Astar2 astar;
        Labyrintti labyrintti = new Labyrintti();
        astar = new Astar2(labyrintti);
        astar.searchKeko();
        labyrintti.visualisoiPolku(astar.getPolku());
    }

    private static void tulostaPriority() {
        Astar2 astar;
        Labyrintti labyrintti = new Labyrintti();
        astar = new Astar2(labyrintti);
        astar.searchPriorityQueue();
        labyrintti.visualisoiPolku(astar.getPolku());
    }

    private static void tulostaRandomLabyrintti(int koko) {
        Astar2 astar;
        Labyrintti labyrintti = new Labyrintti(koko);
        astar = new Astar2(labyrintti);
        astar.searchKeko();
        labyrintti.visualisoiPolku(astar.getPolku());
    }

    private static void priorityQueueSuoritus() {
        Labyrintti labyrintti = new Labyrintti();
        System.out.println();
        System.out.println("Search Javan priority queuella 1000000x:");

        long aikaAlussa = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Astar2 astar = new Astar2(labyrintti);
            astar.searchPriorityQueue();
        }
        long aikaLopussa = System.currentTimeMillis();
        System.out.println(aikaLopussa - aikaAlussa + "ms.");
    }

    private static void omaKekoSuoritus() {
        Labyrintti labyrintti = new Labyrintti();
        System.out.println();
        System.out.println("Search omalla keolla 1000000x:");

        long aikaAlussa = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Astar2 astar = new Astar2(labyrintti);
            astar.searchKeko();
        }
        long aikaLopussa = System.currentTimeMillis();
        System.out.println(aikaLopussa - aikaAlussa + "ms.");
    }

    private static void lukija() {
        Scanner lukija = new Scanner(System.in);
        int valinta = 0;
        int koko = 7;

        String vastaus = "";
        while (!vastaus.equalsIgnoreCase("Q")) {
            System.out.println("\nRatkaise satunnainen labyrintti: S");
            System.out.println("Suorituskykytestejä: T");
            System.out.println("Lopeta: Q");
            if (valinta != 0) {
                System.out.println("Toista edellinen: R");
            }
            System.out.println();
            vastaus = lukija.nextLine();

            if (vastaus.equalsIgnoreCase("S") || (vastaus.equalsIgnoreCase("R") && valinta == 1)) {
                if ((vastaus.equalsIgnoreCase("R") && valinta == 1)) {
                    tulostaRandomLabyrintti(koko);
                } else {
                    valinta = 1;
                    boolean numero = false;
                    while (!numero) {
                        System.out.println("\nValitse labyrintin koko:");
                        vastaus = lukija.nextLine();
                        try {
                            koko = Integer.parseInt(vastaus);
                            if (koko > 2) {
                                numero = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Anna kokonaisluku (suurempi kuin 2, pienempi kuin malttisi).");
                        }
                    }
                    tulostaRandomLabyrintti(koko);
                }
            } else if (vastaus.equalsIgnoreCase("T") || (vastaus.equalsIgnoreCase("R") && valinta == 2)) {
                valinta = 2;
                omaKekoSuoritus();
                priorityQueueSuoritus();

            }
        }
    }
}
