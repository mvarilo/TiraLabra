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
     * Konstruktori luo pyydetyn kokoisen labyrintin ja antaa sille lähtö ja
     * maaliarvot
     *
     * @param koko labyrintin koko
     */
    public Labyrintti(int koko) {
        this.labyrintti = new Solmu[koko][koko];
        for (int i = 0; i < labyrintti.length; i++) {
            for (int j = 0; j < labyrintti.length; j++) {
                Solmu uus = new Solmu(i, j);
                labyrintti[i][j] = uus;
            }
        }
        testiLabyrintti();
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
     * Visualisoi labyrintin helposti luettavassa muodossa
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
     * Arpoo (todo) lähtö ja maaliarvot labyrintille
     *
     */
    private void testiLabyrintti() {
        int min = 0;
        int max = this.labyrintti.length - 1;

        start = this.labyrintti[0][0];
        goal = this.labyrintti[4][4];

        Solmu s = this.labyrintti[0][3];
        s.setObstacle();
        s = this.labyrintti[1][3];
        s.setObstacle();
        s = this.labyrintti[2][3];
        s.setObstacle();
        s = this.labyrintti[3][3];
        s.setObstacle();
        s = this.labyrintti[4][3];
        s.setObstacle();
        s = this.labyrintti[5][3];
        s.setObstacle();
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public Solmu getSolmu(int x, int y) {
        return this.labyrintti[x][y];
    }

    /**
     *
     * @return
     */
    public Solmu getStart() {
        return this.start;
    }

    /**
     *
     * @return
     */
    public Solmu getGoal() {
        return this.goal;
    }

    /**
     * Etsii solmun naapurit, joissa ei ole estettä.
     * 
     * @param current
     * @return
     */
    public ArrayList<Solmu> getNeighbours(Solmu current) {
        ArrayList<Solmu> naapurit = new ArrayList<Solmu>();

        if (current.getX() > 0 && current.isObstacle() != true) {
            naapurit.add(this.labyrintti[current.getX() - 1][current.getY()]);
        }

        if (current.getX() < this.labyrintti.length - 1 && current.isObstacle() != true) {
            naapurit.add((this.labyrintti[current.getX() + 1][current.getY()]));
        }

        if (current.getY() > 0 && current.isObstacle() != true) {
            naapurit.add(this.labyrintti[current.getX()][current.getY() - 1]);
        }

        if (current.getY() < this.labyrintti.length - 1 && current.isObstacle() != true) {
            naapurit.add((this.labyrintti[current.getX()][current.getY() + 1]));
        }
        return naapurit;
    }

    /**
     * Palauttaa etäisyyden solmujen välillä 
     * (tällä hetkellä etäisyys voi olla vain 1)
     * 
     * @param current
     * @param neighbour
     * @return
     */
    public int dist_between(Solmu current, Solmu neighbour) {
        return 1;
    }
}
