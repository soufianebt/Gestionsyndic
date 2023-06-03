package com.example.applicationgestionsyndic.DAL;

import com.example.applicationgestionsyndic.Metier.Depense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepenseDal {

    private database db;
    public DepenseDal() {
        this.db = new database();
    }

    public void createDepense(Depense depense) {
        try  {
            Connection connection = db.getConnection();
            String query = "INSERT INTO depenses (titre, mois, montant, infos, Syndic_id, Type_depense_id, Corpropriete_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, depense.getTitre());
            statement.setInt(2, depense.getMois());
            statement.setDouble(3, depense.getMontant());
            statement.setString(4, depense.getInfos());
            statement.setInt(5, depense.getSyndic_id());
            statement.setInt(6, depense.getType_depense_id());
            statement.setInt(7, depense.getCorpropriete_id());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDepense(Depense depense) {
        try (Connection connection = db.getConnection();) {
            String query = "UPDATE depenses SET titre = ?, mois = ?, montant = ?, infos = ?, " +
                    "Syndic_id = ?, Type_depense_id = ?, Corpropriete_id = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, depense.getTitre());
            statement.setInt(2, depense.getMois());
            statement.setDouble(3, depense.getMontant());
            statement.setString(4, depense.getInfos());
            statement.setInt(5, depense.getSyndic_id());
            statement.setInt(6, depense.getType_depense_id());
            statement.setInt(7, depense.getCorpropriete_id());
            statement.setInt(8, depense.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Depense selectDepenseById(int id) {
        Depense depense = null;
        try (Connection connection = db.getConnection();) {
            String query = "SELECT * FROM depenses WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                depense = new Depense();
                depense.setId(resultSet.getInt("id"));
                depense.setTitre(resultSet.getString("titre"));
                depense.setMois(resultSet.getInt("mois"));
                depense.setMontant(resultSet.getDouble("montant"));
                depense.setInfos(resultSet.getString("infos"));
                depense.setSyndic_id(resultSet.getInt("Syndic_id"));
                depense.setType_depense_id(resultSet.getInt("Type_depense_id"));
                depense.setCorpropriete_id(resultSet.getInt("Corpropriete_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return depense;
    }

    public void deleteDepense(int id) {
        try (Connection connection = db.getConnection();) {
            String query = "DELETE FROM depenses WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Depense> getAllDepenses() {
        List<Depense> depenses = new ArrayList<>();
        try (Connection connection = db.getConnection();) {
            String query = "SELECT * FROM depenses";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Depense depense = new Depense();
                depense.setId(resultSet.getInt("id"));
                depense.setTitre(resultSet.getString("titre"));
                depense.setMois(resultSet.getInt("mois"));
                depense.setMontant(resultSet.getDouble("montant"));
                depense.setInfos(resultSet.getString("infos"));
                depense.setSyndic_id(resultSet.getInt("Syndic_id"));
                depense.setType_depense_id(resultSet.getInt("Type_depense_id"));
                depense.setCorpropriete_id(resultSet.getInt("Corpropriete_id"));
                depenses.add(depense);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return depenses;
    }
}