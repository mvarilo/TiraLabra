/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

/**
 * Luokka vastaa pino-tietorakenteen toteutuksesta.
 *
 *
 * @author MV
 */
class Pino {

    private Solmu[] taulukko;
    private int top;

    Pino(int size) {
        this.top = -1;
        this.taulukko = new Solmu[size * size];
    }

    void push(Solmu current) {
        this.top++;
        taulukko[this.top] = current;
    }

    boolean empty() {
        return this.top == -1;
    }

    Solmu pop() {
        Solmu pop = taulukko[this.top];
        this.top--;
        return pop;
    }

}
