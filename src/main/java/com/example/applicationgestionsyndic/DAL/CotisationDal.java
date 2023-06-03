package com.example.applicationgestionsyndic.DAL;

import com.example.applicationgestionsyndic.Metier.Cotisation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CotisationDal {
    database db;
    public CotisationDal(){
    db = new database();
    }

    public void createCotisation(Cotisation cotisation) {
        try (Connection connection = db.getConnection()) {
            String query = "INSERT INTO Cotisation (date_pai, dern_mois_pai, nbr_mois, montant_paye, " +
                    "Syndic_id, Corpropriete_id, Unite_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(cotisation.getDate_pai().getTime()));
            statement.setInt(2, cotisation.getDern_mois_pai());
            statement.setInt(3, cotisation.getNbr_mois());
            statement.setDouble(4, cotisation.getMontant_paye());
            statement.setInt(5, cotisation.getSyndic_id());
            statement.setInt(6, cotisation.getCorpropriete_id());
            statement.setInt(7, cotisation.getUnite_id());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCotisation(Cotisation cotisation) {
        try (Connection connection = db.getConnection()) {
            String query = "UPDATE Cotisation SET date_pai = ?, dern_mois_pai = ?, nbr_mois = ?, " +
                    "montant_paye = ?, Syndic_id = ?, Corpropriete_id = ?, Unite_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setDate(1, new java.sql.Date(cotisation.getDate_pai().getTime()));
            statement.setInt(2, cotisation.getDern_mois_pai());
            statement.setInt(3, cotisation.getNbr_mois());
            statement.setDouble(4, cotisation.getMontant_paye());
            statement.setInt(5, cotisation.getSyndic_id());
            statement.setInt(6, cotisation.getCorpropriete_id());
            statement.setInt(7, cotisation.getUnite_id());
            statement.setInt(8, cotisation.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cotisation getCotisationById(int id) {
        Cotisation cotisation = null;
        try (Connection connection = db.getConnection()) {
            String query = "SELECT * FROM Cotisation WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cotisation = new Cotisation();
                cotisation.setId(resultSet.getInt("id"));
                cotisation.setDate_pai(resultSet.getDate("date_pai"));
                cotisation.setDern_mois_pai(resultSet.getInt("dern_mois_pai"));
                cotisation.setNbr_mois(resultSet.getInt("nbr_mois"));
                cotisation.setMontant_paye(resultSet.getDouble("montant_paye"));
                cotisation.setSyndic_id(resultSet.getInt("Syndic_id"));
                cotisation.setCorpropriete_id(resultSet.getInt("Corpropriete_id"));
                cotisation.setUnite_id(resultSet.getInt("Unite_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cotisation;
    }
    public List<Cotisation> getCotisationByCorproprieteId(int corproprieteId) {
        List<Cotisation> cotisations = new ArrayList<>();
        try (Connection connection = db.getConnection()) {
            String query = "SELECT * FROM Cotisation WHERE Corpropriete_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, corproprieteId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cotisation cotisation = new Cotisation();
                cotisation.setId(resultSet.getInt("id"));
                cotisation.setDate_pai(resultSet.getDate("date_pai"));
                cotisation.setDern_mois_pai(resultSet.getInt("dern_mois_pai"));
                cotisation.setNbr_mois(resultSet.getInt("nbr_mois"));
                cotisation.setMontant_paye(resultSet.getDouble("montant_paye"));
                cotisation.setSyndic_id(resultSet.getInt("Syndic_id"));
                cotisation.setCorpropriete_id(resultSet.getInt("Corpropriete_id"));
                cotisation.setUnite_id(resultSet.getInt("Unite_id"));
                cotisations.add(cotisation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cotisations;
    }

    public void deleteCotisation(int id) {
        try (Connection connection = db.getConnection()) {
            String query = "DELETE FROM Cotisation WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


