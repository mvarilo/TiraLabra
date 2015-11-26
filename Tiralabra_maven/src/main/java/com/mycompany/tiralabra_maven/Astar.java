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
 * Toteuttaa A*-algoritmiin pohjautuvan lyhimmän reitin etsinnän. Käytetty javan
 * valmista kalustoa perustuen Wikipediasta löydettyyn pseudokoodiin.
 * 
 * Tällä hetkellä ei ole aivan kaikkea mitä Astar2:sta löytyy.
 * 
 * http://en.wikipedia.org/wiki/A*_search_algorithm
 *
 *
 * @author MV
 */
public class Astar {

    private Labyrintti labyrintti;
    private Solmu start;
    private Solmu goal;
    private PriorityQueue<Solmu> open;
    private ArrayList<Solmu> evaluated;
    private HashMap<Solmu, Solmu> Came_From;

    /**
     * Konstruktori saa parametreinä labyrintin, lähtö- ja maalisolmun.
     *
     * @param labyrintti
     * @param start
     * @param goal
     */
    public Astar(Labyrintti labyrintti, Solmu start, Solmu goal) {
        this.labyrintti = labyrintti;
        this.start = start;
        this.goal = goal;
        this.open = new PriorityQueue<Solmu>();
        this.evaluated = new ArrayList<Solmu>();
        this.Came_From = new HashMap<Solmu, Solmu>();
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
        Stack<Solmu> pino = new Stack<Solmu>();

        while (!(current.equals(this.start))) {
            pino.push(current);
            current = Came_From.get(current);
        }
        while (!pino.empty()) {
            current = pino.pop();
            System.out.println(current.toString());
        }
    }
}
