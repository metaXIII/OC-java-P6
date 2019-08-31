package com.metaxiii.escalade.model;

public class Voie {
    private Long id;
    private int difficulte;
    private int longueurs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }

    public int getLongueurs() {
        return longueurs;
    }

    public void setLongueurs(int longueurs) {
        this.longueurs = longueurs;
    }
}
