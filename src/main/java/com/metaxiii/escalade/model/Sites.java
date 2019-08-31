package com.metaxiii.escalade.model;

import java.util.List;

public class Sites {
    private Long id;
    private String lieu;
    private int secteurs;
    private int voies;
    private int longueurs;
    private int difficulteGenerale;
    private double cotation;
    private List<String> commentaires;
    private boolean officiel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(int secteurs) {
        this.secteurs = secteurs;
    }

    public int getVoies() {
        return voies;
    }

    public void setVoies(int voies) {
        this.voies = voies;
    }

    public int getLongueurs() {
        return longueurs;
    }

    public void setLongueurs(int longueurs) {
        this.longueurs = longueurs;
    }

    public int getDifficulteGenerale() {
        return difficulteGenerale;
    }

    public void setDifficulteGenerale(int difficulteGenerale) {
        this.difficulteGenerale = difficulteGenerale;
    }

    public double getCotation() {
        return cotation;
    }

    public void setCotation(double cotation) {
        this.cotation = cotation;
    }

    public List<String> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<String> commentaires) {
        this.commentaires = commentaires;
    }

    public boolean isOfficiel() {
        return officiel;
    }

    public void setOfficiel(boolean officiel) {
        this.officiel = officiel;
    }
}
