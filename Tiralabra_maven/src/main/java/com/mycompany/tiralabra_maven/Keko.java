/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiralabra_maven;

/**
 * Minimikeon toteutus.
 *
 * @author MV
 */
public class Keko {

    private int keonKoko;
    private int keonPituus;
    private Solmu[] keko;

    /**
     * Konstruktori tekee annetun kokoisen taulukon ja asettaa keon pituudeksi 0
     *
     * @param size
     */
    public Keko(int size) {
        this.keonKoko = size;
        this.keonPituus = 0;
        this.keko = new Solmu[this.keonKoko];
        for (int i = 0; i < this.keonKoko; i++) {
            this.keko[i] = null;
        }
    }

    /**
     * Lisää kekoon uuden solmun
     *
     * @param solmu
     */
    public void add(Solmu solmu) {
        if (this.keonPituus == 0) {
            keko[0] = solmu;
            solmu.setIndex(0);
            this.keonPituus++;
        } else {
            this.keonPituus++;
            int i = this.keonPituus - 1;
            while (i > 0 && keko[vanhempi(i)].get_f_score() > solmu.get_f_score()) {
                keko[i] = keko[vanhempi(i)];
                keko[i].setIndex(i);
                i = vanhempi(i);
            }
            keko[i] = solmu;
            solmu.setIndex(i);
        }
    }

    /**
     * Tarkastaa onko keossa alkioita
     *
     * @return
     */
    public boolean isEmpty() {
        return this.keonPituus == 0;
    }

    /**
     * Poistaa juurena olleen alkion ja korjaa keon
     *
     * @return Solmu min
     */
    public Solmu poll() {
        Solmu min = keko[0];
        keko[0] = keko[this.keonPituus - 1];

        this.keonPituus--;
        heapify(0);

        return min;
    }

    /**
     * Etsii onko keossa annettu solmu.
     *
     * @param neighbour
     * @return
     */
    public boolean contains(Solmu neighbour) {
        int vasen = 0;
        int oikea = this.keonPituus - 1;
        boolean found = false;

        while (vasen <= oikea && found == false) {
            int keski = (vasen + oikea) / 2;
            if (this.keko[keski] == neighbour) {
                found = true;
                return found;
            }
            if (this.keko[keski].get_f_score() > neighbour.get_f_score()) {
                oikea = keski - 1;
            } else {
                vasen = keski + 1;
            }
        }
        return false;
    }

    private int vanhempi(int i) {
        return (((i + 1) / 2) - 1);
    }

    private void heapify(int i) {
        int v = vasen(i);
        int o = right(i);
        int pienin = 0;

        if (o <= this.keonPituus) {
            if (this.keko[v].get_f_score() < this.keko[o].get_f_score()) {
                pienin = v;
            } else {
                pienin = o;
            }
            if (this.keko[i].get_f_score() > this.keko[pienin].get_f_score()) {
                Solmu apu = this.keko[i];
                this.keko[i] = keko[pienin];
                this.keko[pienin] = apu;

                heapify(pienin);
            }
        } else {
            if (o == this.keonPituus && this.keko[i].get_f_score() < this.keko[o].get_f_score()) {
                Solmu apu = keko[i];
                keko[i] = keko[o];
                keko[o] = apu;
            }
        }
    }

    private int vasen(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    /**
     * Palauttaa keon pituuden
     *
     * @return
     */
    public int getLength() {
        return this.keonPituus;
    }

    /**
     * Palauttaa keossa olevan solmun.
     *
     *
     * @param s
     * @return
     */
    public int getIndex(Solmu s) {

        for (int i = 0; i < this.keonPituus; ++i) {
            if (this.keko[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    Solmu getSolmuIndex(int i) {
        return this.keko[i];
    }

    void update(int index) {
        this.heapify(index);
    }

}
