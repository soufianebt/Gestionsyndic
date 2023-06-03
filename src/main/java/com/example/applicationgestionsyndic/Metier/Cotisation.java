package com.example.applicationgestionsyndic.Metier;

import java.util.Date;

public class Cotisation {
    private int id;
    private Date date_pai;
    private int dern_mois_pai;
    private int nbr_mois;
    private double montant_paye;
    private int Syndic_id;
    private int Corpropriete_id;
    private int Unite_id;

    public Cotisation(int id, Date date_pai, int dern_mois_pai, int nbr_mois, double montant_paye, int syndic_id, int corpropriete_id, int unite_id) {
        this.id = id;
        this.date_pai = date_pai;
        this.dern_mois_pai = dern_mois_pai;
        this.nbr_mois = nbr_mois;
        this.montant_paye = montant_paye;
        Syndic_id = syndic_id;
        Corpropriete_id = corpropriete_id;
        Unite_id = unite_id;
    }
    public Cotisation(){

    }

public Cotisation(int Id, int unite, Date date, int dern_mois, int nbrmois, double montant ){
    id=Id;
    Unite_id=unite;
    date_pai=date;
    dern_mois_pai=dern_mois;
    nbr_mois=nbrmois;
    montant_paye=montant;
}
    public int getId() {
        return id;
    }

    public Date getDate_pai() {
        return date_pai;
    }

    public int getDern_mois_pai() {
        return dern_mois_pai;
    }

    public int getNbr_mois() {
        return nbr_mois;
    }

    public double getMontant_paye() {
        return montant_paye;
    }

    public int getSyndic_id() {
        return Syndic_id;
    }

    public int getCorpropriete_id() {
        return Corpropriete_id;
    }

    public int getUnite_id() {
        return Unite_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_pai(Date date_pai) {
        this.date_pai = date_pai;
    }

    public void setDern_mois_pai(int dern_mois_pai) {
        this.dern_mois_pai = dern_mois_pai;
    }

    public void setNbr_mois(int nbr_mois) {
        this.nbr_mois = nbr_mois;
    }

    public void setMontant_paye(double montant_paye) {
        this.montant_paye = montant_paye;
    }

    public void setSyndic_id(int syndic_id) {
        Syndic_id = syndic_id;
    }

    public void setCorpropriete_id(int corpropriete_id) {
        Corpropriete_id = corpropriete_id;
    }

    public void setUnite_id(int unite_id) {
        Unite_id = unite_id;
    }

    @Override
    public String toString() {
        return "Cotisation{" +
                "id=" + id +
                ", date_pai=" + date_pai +
                ", dern_mois_pai=" + dern_mois_pai +
                ", nbr_mois=" + nbr_mois +
                ", montant_paye=" + montant_paye +
                ", Syndic_id=" + Syndic_id +
                ", Corpropriete_id=" + Corpropriete_id +
                ", Unite_id=" + Unite_id +
                '}';
    }
}
