package com.example.applicationgestionsyndic.DAL;


import com.example.applicationgestionsyndic.Metier.Corpropriete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CorproprieteDal {

    private database db;

    public CorproprieteDal() {
        this.db = new database();
    }

    public List<Corpropriete> getCorproprietesBySyndicId(int syndicId) {
        List<Corpropriete> corproprietes = new ArrayList<>();

        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Corpropriete WHERE Syndic_id = ?")) {
            stmt.setInt(1, syndicId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Corpropriete corpropriete = mapResultSetToCorpropriete(rs);
                    corproprietes.add(corpropriete);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return corproprietes;
    }

    public void updateCorpropriete(Corpropriete corpropriete) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE Corpropriete SET nom = ?, ville = ?, code_postal = ?, nbr_unite = ?, montant_cotis = ?, montant_dispo = ?, adresse = ?, Syndic_id = ?, Type_corpropriete_id = ? WHERE id = ?")) {
            stmt.setString(1, corpropriete.getNom());
            stmt.setString(2, corpropriete.getVille());
            stmt.setInt(3, corpropriete.getCodePostal());
            stmt.setInt(4, corpropriete.getNbrUnite());
            stmt.setDouble(5, corpropriete.getMontantCotis());
            stmt.setDouble(6, corpropriete.getMontantDispo());
            stmt.setString(7, corpropriete.getAdresse());
            stmt.setInt(8, corpropriete.getSyndicId());
            stmt.setInt(9, corpropriete.getTypeCorproprieteId());
            stmt.setInt(10, corpropriete.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCorpropriete(int corproprieteId) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM Corpropriete WHERE id = ?")) {
            stmt.setInt(1, corproprieteId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCorpropriete(Corpropriete corpropriete) {
        try (Connection conn = db.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO Corpropriete (nom, ville, code_postal, nbr_unite, montant_cotis, montant_dispo, adresse, Syndic_id, Type_corpropriete_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, corpropriete.getNom());
            stmt.setString(2, corpropriete.getVille());
            stmt.setInt(3, corpropriete.getCodePostal());
            stmt.setInt(4, corpropriete.getNbrUnite());
            stmt.setDouble(5, corpropriete.getMontantCotis());
            stmt.setDouble(6, corpropriete.getMontantDispo());
            stmt.setString(7, corpropriete.getAdresse());
            stmt.setInt(8, corpropriete.getSyndicId());
            stmt.setInt(9, corpropriete.getTypeCorproprieteId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Corpropriete mapResultSetToCorpropriete(ResultSet rs) throws SQLException {
        Corpropriete corpropriete = new Corpropriete();
        corpropriete.setId(rs.getInt("id"));
        corpropriete.setNom(rs.getString("nom"));
        corpropriete.setVille(rs.getString("ville"));
        corpropriete.setCodePostal(rs.getInt("code_postal"));
        corpropriete.setNbrUnite(rs.getInt("nbr_unite"));
        corpropriete.setMontantCotis(rs.getDouble("montant_cotis"));
        corpropriete.setMontantDispo(rs.getDouble("montant_dispo"));
        corpropriete.setAdresse(rs.getString("adresse"));
        corpropriete.setSyndicId(rs.getInt("Syndic_id"));
        corpropriete.setTypeCorproprieteId(rs.getInt("Type_corpropriete_id"));

        return corpropriete;
    }
}
