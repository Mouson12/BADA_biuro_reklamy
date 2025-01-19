package bdbt_bada_project.SpringApplication.dao;

import bdbt_bada_project.SpringApplication.models.Adresy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class AdresyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all Adresy
    public List<Adresy> getAllAdresy() {
        String sql = "SELECT * FROM Adresy";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Adresy.class));
    }

    // Get a single Adresy by ID
    public Adresy getAdresyById(Integer id) {
        String sql = "SELECT * FROM Adresy WHERE Id_adresu = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Adresy.class), id);
    }

    // Add a new Adresy
    public int saveAdresy(Adresy adresy) {
        String sql = "INSERT INTO Adresy (Id_adresu, Miasto, Ulica, Nr_budynku, Nr_lokalu, Kod_pocztowy) VALUES (SEQ_ADRESY.NEXTVAL, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"Id_adresu"});
            ps.setString(1, adresy.getMiasto());
            ps.setString(2, adresy.getUlica());
            ps.setString(3, adresy.getNrBudynku());
            ps.setString(4, adresy.getNrLokalu());
            ps.setString(5, adresy.getKodPocztowy());
            return ps;
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    // Update Adresy
    public int updateAdresy(Adresy adresy) {
        String sql = "UPDATE Adresy SET Miasto = ?, Ulica = ?, Nr_budynku = ?, Nr_lokalu = ?, Kod_pocztowy = ? WHERE Id_adresu = ?";
        return jdbcTemplate.update(sql, adresy.getMiasto(), adresy.getUlica(), adresy.getNrBudynku(), adresy.getNrLokalu(), adresy.getKodPocztowy(), adresy.getIdAdresu());
    }

    // Delete Adresy
    public int deleteAdresy(Integer id) {
        String sql = "DELETE FROM Adresy WHERE Id_adresu = ?";
        return jdbcTemplate.update(sql, id);
    }
}
