/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Toteuttaa A*-algoritmiin pohjautuvan lyhimmän reitin etsinnän. Käytetty omia
 * tietorakenteita perustuen Wikipediasta löydettyyn pseudokoodiin.
 * http://en.wikipedia.org/wiki/A*_search_algorithm
 *
 *
 * @author MV
 */
public class Astar2 {

    private Labyrintti labyrintti;
    private Solmu start;
    private Solmu goal;
    private PriorityQueue<Solmu> open;
    private Keko open2;
    private ArrayList<Solmu> evaluated;
    private HashMap<Solmu, Solmu> Came_From;
    private Pino polku;

    /**
     * Konstruktori saa parametreinä labyrintin, lähtö- ja maalisolmun.
     *
     * @param labyrintti
     * @param start
     * @param goal
     */
    public Astar2(Labyrintti labyrintti, Solmu start, Solmu goal) {
        this.labyrintti = labyrintti;
        this.start = start;
        this.goal = goal;
        this.open = new PriorityQueue<Solmu>();
        this.open2 = new Keko(this.labyrintti.getSize());
        this.evaluated = new ArrayList<Solmu>();
        this.Came_From = new HashMap<Solmu, Solmu>();
        this.polku = new Pino(this.labyrintti.getSize());
    }

    /**
     * Etsii ja tulostaa lyhimmän reitin labyrintin läpi.
     */
    public void search() {
        this.open.add(start);
        this.start.set_g_score(0);
        this.start.set_f_score(this.goal);

        while (!this.open.isEmpty()) {
            Solmu current = this.open.poll();

            if (current.equals(goal)) {
                reconstructPath(Came_From, goal);
            }

            this.open.remove(current);
            this.evaluated.add(current);

            handleNeighbours(current);
        }

    }

    /**
     *
     * @return
     */
    public boolean searchKeko() {
        this.open2.add(start);
        this.start.set_g_score(0);
        this.start.set_f_score(this.goal);

        while (!this.open2.isEmpty()) {
            Solmu current = this.open2.poll();

            if (current.equals(goal)) {
                reconstructPath();
                return true;
            }

            current.setVisited();
            handleNeighbours2(current);
        }
        return false;
    }

    private void handleNeighbours(Solmu current) {
        ArrayList<Solmu> neighbours = this.labyrintti.getNeighbours(current);

        for (Solmu neighbour : neighbours) {
            if (!evaluated.contains(neighbour)) {
                int tentative_g_score = current.get_g_score() + labyrintti.dist_between(current, neighbour);

                if (!this.open.contains(neighbour) || tentative_g_score < neighbour.get_g_score()) {
                    Came_From.put(neighbour, current);
                    neighbour.set_g_score(tentative_g_score);
                    neighbour.set_f_score(goal);
                }
                if (!this.open.contains(neighbour)) {
                    this.open.add(neighbour);
                }
            }
        }
    }

    private void reconstructPath(HashMap<Solmu, Solmu> Came_From, Solmu current_node) {
        System.out.println(this.start.toString());

        Solmu current = this.goal;
        //Stack<Solmu> pino = new Stack<Solmu>();
        Pino pino = new Pino(labyrintti.getSize());

        while (!(current.equals(this.start))) {
            pino.push(current);
            current = Came_From.get(current);
        }
        while (!pino.empty()) {
            current = pino.pop();
            System.out.println(current.toString());
        }
    }

    private void handleNeighbours2(Solmu current) {
        Keko naapurit = this.labyrintti.getNeighbours2(current);

        for (int i = 0; i < naapurit.getLength(); i++) {
            Solmu naapuri = naapurit.getIndex(i);

            if (!naapuri.isVisited()) {
                int alkuun = current.get_g_score()
                        + labyrintti.dist_between(current, naapuri);

                if (!this.open2.contains(naapuri) || alkuun < naapuri.get_f_score()) {
                    naapuri.setPrevious(current);
                    naapuri.set_g_score(alkuun);
                    naapuri.set_f_score(goal);

                    if (!this.open2.contains(naapuri)) {
                        this.open2.add(naapuri);
                    }
                }
            }
        }

    }

    Pino getPolku() {
        return this.polku;
    }

    private void reconstructPath() {
        Solmu s = this.goal;

        while (!(s.equals(this.start))) {
            this.polku.push(s);
            s = s.getPrevious();
        }
        this.polku.push(s);
    }
}
