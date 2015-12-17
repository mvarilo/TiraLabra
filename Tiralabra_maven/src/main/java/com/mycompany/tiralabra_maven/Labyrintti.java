/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

import java.util.ArrayList;

/**
 * Labyrintin muodostus
 *
 * @author MV
 */
public class Labyrintti {

    private Solmu[][] labyrintti;
    private Solmu start;
    private Solmu goal;

    /**
     * Konstruktori luo pyydetyn kokoisen labyrintin, arpoo sille lähdön,
     * maalin, sekä esteet.
     *
     * @param koko labyrintin koko
     */
    public Labyrintti(int koko) {
        this.labyrintti = new Solmu[koko][koko];
        luoSolmut();
        arvoLahtoJaMaali();
        arvoEsteet(koko);
    }

    private void luoSolmut() {
        for (int i = 0; i < labyrintti.length; i++) {
            for (int j = 0; j < labyrintti.length; j++) {
                Solmu uus = new Solmu(i, j);
                labyrintti[i][j] = uus;
            }
        }
    }

    /**
     * Konstruktori luo testeihin tarkoitetun labyrintin.
     *
     * [v][v][s][v][v][v][ ]
     *
     * [v][v][p][v][v][v][ ]
     *
     * [v][v][p][p][p][p][p]
     *
     * [v][#][#][#][#][#][p]
     *
     * [ ][ ][ ][ ][g][p][p]
     *
     * [ ][ ][ ][ ][ ][ ][ ]
     *
     * [ ][ ][ ][ ][ ][ ][ ]
     *
     */
    public Labyrintti() {
        this.labyrintti = new Solmu[7][7];
        luoSolmut();

        this.start = this.labyrintti[2][0];
        this.goal = this.labyrintti[4][4];

        Solmu s;
        for (int i = 1; i < 6; i++) {
            s = this.labyrintti[i][3];
            s.setObstacle();
        }
    }

    /**
     * Tulostaa labyrintin solmujen koordinaatit
     *
     */
    public void tulosta() {
        for (Solmu[] labyrintti1 : labyrintti) {
            for (int j = 0; j < labyrintti.length; j++) {
                System.out.println(labyrintti1[j].toString());
            }
        }
    }

    /**
     * Visualisoi labyrintin helposti luettavassa muodossa.
     *
     */
    public void visualisoi() {
        System.out.println("Labyrintti:");
        System.out.println("start = s");
        System.out.println("goal = g");
        System.out.println("obstacle = # \n");

        for (int j = 0; j < labyrintti.length; j++) {
            for (Solmu[] labyrintti1 : labyrintti) {
                if (labyrintti1[j] == start) {
                    System.out.print("[s]");
                } else if (labyrintti1[j] == goal) {
                    System.out.print("[g]");
                } else if (labyrintti1[j].isObstacle() == true) {
                    System.out.print("[#]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    /**
     * Palauttaa algoritmin laskeman polun kohteeseen.
     *
     * @param polku
     */
    public void visualisoiPolku(Pino polku) {
        System.out.println("\nLabyrintti:");
        System.out.println("start = S");
        System.out.println("goal = G");
        System.out.println("obstacle = #");
        System.out.println("path = p");
        System.out.println("visited = v \n");

        for (int j = 0; j < labyrintti.length; j++) {
            for (int i = 0; i < labyrintti.length; i++) {
                if (labyrintti[i][j] == start) {
                    System.out.print("[S]");
                } else if (labyrintti[i][j] == goal) {
                    System.out.print("[G]");
                } else if (labyrintti[i][j].isObstacle()) {
                    System.out.print("[#]");
                } else if (polku.contains(this.getSolmu(i, j))) {
                    System.out.print("[p]");
                } else if (this.getSolmu(i, j).isVisited()) {
                    System.out.print("[v]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    /**
     * Arpoo esteitä labyrintille
     *
     */
    private void arvoEsteet(int koko) {
        Solmu s;

        for (int i = 0; i < koko * (0.3 * koko); i++) {
            int x = random();
            int y = random();
            if (this.labyrintti[x][y] != goal && this.labyrintti[x][y] != start
                    && !this.labyrintti[x][y].isObstacle()) {
                s = this.labyrintti[x][y];
                s.setObstacle();
            }
        }
    }

    /**
     * Palauttaa solmun labyrintin koordinaateissa.
     *
     * @param x
     * @param y
     * @return
     */
    public Solmu getSolmu(int x, int y) {
        return this.labyrintti[x][y];
    }

    /**
     * Palauttaa aloitusarvon labyrintissä.
     *
     * @return
     */
    public Solmu getStart() {
        return this.start;
    }

    /**
     * Palauttaa maalisolmun labyrintissä.
     *
     * @return
     */
    public Solmu getGoal() {
        return this.goal;
    }

    /**
     * Etsii solmun naapurit, joissa ei ole estettä Javan valmiilla
     * tietorakenteella.
     *
     * @param current
     * @return
     */
    public ArrayList<Solmu> getNeighbours(Solmu current) {
        ArrayList<Solmu> naapurit = new ArrayList<Solmu>();

        if (vasen(current)) {
            Solmu naapuri = this.labyrintti[current.getX() - 1][current.getY()];
            lisaaNaapuri2(naapurit, naapuri);
        }

        if (oikea(current)) {
            Solmu naapuri = this.labyrintti[current.getX() + 1][current.getY()];
            lisaaNaapuri2(naapurit, naapuri);
        }

        if (ylos(current)) {
            Solmu naapuri = this.labyrintti[current.getX()][current.getY() - 1];
            lisaaNaapuri2(naapurit, naapuri);
        }

        if (alas(current)) {
            Solmu naapuri = this.labyrintti[current.getX()][current.getY() + 1];
            lisaaNaapuri2(naapurit, naapuri);
        }
        return naapurit;
    }

    /**
     * Palauttaa etäisyyden solmujen välillä (tällä hetkellä etäisyys voi olla
     * vain 1)
     *
     * @param current
     * @param neighbour
     * @return
     */
    public int dist_between(Solmu current, Solmu neighbour) {
        return 1;
    }

    /**
     * Palauttaa labyrintin koon.
     *
     * @return
     */
    public int getSize() {
        return this.labyrintti.length * this.labyrintti.length;
    }

    /**
     * Etsii solmun naapurit, joissa ei ole estettä. Omalla tietorakenteella.
     *
     * @param current
     * @return
     */
    public Keko getNeighbours2(Solmu current) {
        Keko naapurit = new Keko(4);

        if (vasen(current)) {
            Solmu naapuri = this.labyrintti[current.getX() - 1][current.getY()];
            lisaaNaapuri(naapurit, naapuri);
        }

        if (oikea(current)) {
            Solmu naapuri = this.labyrintti[current.getX() + 1][current.getY()];
            lisaaNaapuri(naapurit, naapuri);
        }

        if (ylos(current)) {
            Solmu naapuri = this.labyrintti[current.getX()][current.getY() - 1];
            lisaaNaapuri(naapurit, naapuri);
        }

        if (alas(current)) {
            Solmu naapuri = this.labyrintti[current.getX()][current.getY() + 1];
            lisaaNaapuri(naapurit, naapuri);
        }

        return naapurit;
    }

    private int random() {
        int min = 0;
        int max = this.labyrintti.length - 1;

        int x = min + (int) (Math.random() * (max - min));
        return x;
    }

    private void arvoLahtoJaMaali() {
        this.start = this.labyrintti[random()][random()];
        this.goal = this.labyrintti[random()][random()];

        while (this.goal.getX() == this.start.getX() && this.goal.getY() == this.start.getY()
                || this.getNeighbours2(start).contains(goal)) {
            this.goal = this.labyrintti[random()][random()];
        }
    }

    private void lisaaNaapuri(Keko naapurit, Solmu naapuri) {
        if (naapuri.isObstacle() != true && naapuri.isVisited() != true) {
            naapurit.add(naapuri);
        }
    }

    private void lisaaNaapuri2(ArrayList<Solmu> naapurit, Solmu naapuri) {
        if (naapuri.isObstacle() != true && naapuri.isVisited() != true) {
            naapurit.add(naapuri);
        }

    }

    private boolean vasen(Solmu current) {
        return current.getX() > 0;
    }

    private boolean oikea(Solmu current) {
        return current.getX() < this.labyrintti.length - 1;
    }

    private boolean ylos(Solmu current) {
        return current.getY() > 0;
    }

    private boolean alas(Solmu current) {
        return current.getY() < this.labyrintti.length - 1;
    }
}
