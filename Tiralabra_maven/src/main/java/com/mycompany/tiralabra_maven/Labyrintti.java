/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

/**
 *
 * @author MV
 */
public class Labyrintti {

    private Solmu[][] labyrintti;
    private Solmu start;
    private Solmu goal;

    public Labyrintti(int koko) {
        this.labyrintti = new Solmu[koko][koko];
        for (int i = 0; i < labyrintti.length; i++) {
            for (int j = 0; j < labyrintti.length; j++) {
                Solmu uus = new Solmu(i, j);
                labyrintti[i][j] = uus;
            }
        }
        startAndGoal();
    }

    public void tulosta() {
        for (int i = 0; i < labyrintti.length; i++) {
            for (int j = 0; j < labyrintti.length; j++) {
                System.out.println(labyrintti[i][j].toString());
            }
        }
    }

    public void visualisoi() {
        System.out.println("Labyrintti:");
        System.out.println("start = s");
        System.out.println("goal = g");
        System.out.println("obstacle = # \n");

        for (int j = 0; j < labyrintti.length; j++) {
            for (int i = 0; i < labyrintti.length; i++) {
                if(labyrintti[i][j] == start) {
                    System.out.print("[s]");
                }
                else if(labyrintti[i][j] == goal) {
                    System.out.print("[g]");
                }
                else if(labyrintti[i][j].isObstacle() == true) {
                    System.out.print("[#]");
                }
                else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

    private void startAndGoal() {
        int min = 0;
        int max = this.labyrintti.length - 1;

        start = this.labyrintti[1][1];
        goal = this.labyrintti[4][4];
    }

}
