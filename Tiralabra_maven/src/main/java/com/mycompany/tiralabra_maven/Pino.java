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
public class Pino {

    private Solmu[] taulukko;
    private int top;

    /**
     * Luo uuden pinon, jolle asetetaan koko.
     *
     * @param size
     */
    public Pino(int size) {
        this.top = -1;
        this.taulukko = new Solmu[size];
    }

    /**
     * Lisää annetun Solmun pinon päällimmäiseksi.
     *
     * @param current
     */
    public void push(Solmu current) {
        this.top++;
        taulukko[this.top] = current;
    }

    /**
     * Tarkastaa onko pino tyhjä.
     *
     * @return
     */
    public boolean empty() {
        return this.top == -1;
    }

    /**
     * Poistaa päällimmäisen Solmun pinosta ja palauttaa sen.
     *
     * @return
     */
    public Solmu pop() {
        if (!this.empty()) {
            Solmu pop = taulukko[this.top];
            this.top--;
            return pop;
        }
        return null;
    }

    /**
     * Tarkastaa onko kyseinen Solmu pinossa.
     *
     * @param solmu
     * @return
     */
    public boolean contains(Solmu solmu) {
        for (int i = 0; i < this.top; i++) {
            if (taulukko[i] == solmu) {
                return true;
            }
        }
        return false;
    }
}
