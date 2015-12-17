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
     */
    public Astar2(Labyrintti labyrintti) {
        this.labyrintti = labyrintti;
        this.start = this.labyrintti.getStart();
        this.goal = this.labyrintti.getGoal();
        this.open = new PriorityQueue<Solmu>();
        this.open2 = new Keko(this.labyrintti.getSize());
        this.evaluated = new ArrayList<Solmu>();
        this.Came_From = new HashMap<Solmu, Solmu>();
        this.polku = new Pino(this.labyrintti.getSize());
    }

    /**
     * Etsii ja tulostaa lyhimmän reitin labyrintin läpi käyttäen valmiita
     * tietorakenteita.
     *
     * @return
     */
    public boolean searchPriorityQueue() {
        this.open.add(start);
        this.start.set_g_score(0);
        this.start.set_f_score(this.goal);

        while (!this.open.isEmpty()) {
            Solmu current = this.open.poll();

            if (current.equals(goal)) {
                reconstructPath();
                return true;
            }

            current.setVisited();
            handleNeighbours(current);
        }
        return false;

    }

    /**
     * Etsii ja tulostaa lyhimmän reitin labyrintin läpi käyttäen omia
     * tietorakenteita.
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

    private void handleNeighboursOld(Solmu current) {
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

    private void handleNeighbours(Solmu current) {

        ArrayList<Solmu> neighbours = this.labyrintti.getNeighbours(current);

        for (Solmu neighbour : neighbours) {

            if (!neighbour.isVisited()) {

                int arvioAlkuun = current.get_g_score()
                        + labyrintti.dist_between(current, neighbour);

                if (!this.open.contains(neighbour) || arvioAlkuun < neighbour.get_g_score()) {
                    neighbour.setPrevious(current);
                    neighbour.set_g_score(arvioAlkuun);
                    neighbour.set_f_score(goal);

                    if (!this.open.contains(neighbour)) {
                        this.open.add(neighbour);
                    } else {
                        this.open2.update(open2.getIndex(neighbour));
                    }
                }

            }

        }

    }

    private void handleNeighbours2(Solmu current) {
        Keko naapurit = this.labyrintti.getNeighbours2(current);

        for (int i = 0; i < naapurit.getLength(); i++) {
            Solmu naapuri = naapurit.getSolmuIndex(i);

            if (!naapuri.isVisited()) {
                int arvioAlkuun = current.get_g_score()
                        + labyrintti.dist_between(current, naapuri);

                if (!this.open2.contains(naapuri) || arvioAlkuun < naapuri.get_g_score()) {
                    naapuri.setPrevious(current);
                    naapuri.set_g_score(arvioAlkuun);
                    naapuri.set_f_score(goal);

                    if (!this.open2.contains(naapuri)) {
                        this.open2.add(naapuri);
                    }
                }
            }
        }

    }

    /**
     * Palauttaa lasketun polun.
     *
     * @return
     */
    public Pino getPolku() {
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
