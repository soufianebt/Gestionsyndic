package com.example.applicationgestionsyndic.Metier;

public class Depense {
    private int id;
    private String titre;
    private int mois;
    private double montant;
    private String infos;
    private int Syndic_id;
    private int Type_depense_id;
    private int Corpropriete_id;

    public Depense(int id, String titre, int mois, double montant, String infos, int syndic_id, int type_depense_id, int corpropriete_id) {
        this.id = id;
        this.titre = titre;
        this.mois = mois;
        this.montant = montant;
        this.infos = infos;
        Syndic_id = syndic_id;
        Type_depense_id = type_depense_id;
        Corpropriete_id = corpropriete_id;
    }
    public Depense(String titre, double montant, String infos) {

        this.titre = titre;

        this.montant = montant;
        this.infos = infos;

    }
    public Depense() {

    }
    public Depense(String titre, int mois, double montant, String infos, int syndic_id, int type_depense_id, int corpropriete_id) {
        this.titre = titre;
        this.mois = mois;
        this.montant = montant;
        this.infos = infos;
        Syndic_id = syndic_id;
        Type_depense_id = type_depense_id;
        Corpropriete_id = corpropriete_id;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public int getMois() {
        return mois;
    }

    public double getMontant() {
        return montant;
    }

    public String getInfos() {
        return infos;
    }

    public int getSyndic_id() {
        return Syndic_id;
    }

    public int getType_depense_id() {
        return Type_depense_id;
    }

    public int getCorpropriete_id() {
        return Corpropriete_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    public void setSyndic_id(int syndic_id) {
        Syndic_id = syndic_id;
    }

    public void setType_depense_id(int type_depense_id) {
        Type_depense_id = type_depense_id;
    }

    public void setCorpropriete_id(int corpropriete_id) {
        Corpropriete_id = corpropriete_id;
    }
}
