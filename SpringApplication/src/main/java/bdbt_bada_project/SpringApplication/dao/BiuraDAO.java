package bdbt_bada_project.SpringApplication.dao;

import bdbt_bada_project.SpringApplication.models.Biura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BiuraDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all Biura
    public List<Biura> getAllBiura() {
        String sql = "SELECT * FROM Biura";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Biura.class));
    }

    // Get a single Biura by ID
    public Biura getBiuraById(Integer id) {
        String sql = "SELECT * FROM Biura WHERE Id_biura = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Biura.class), id);
    }

    // Insert a new Biura
    public int saveBiura(Biura biura) {
        String sql = "INSERT INTO Biura (Id_biura, Nazwa, Data_zalozenia, Id_adresu, Id_pracownika) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, biura.getIdBiura(), biura.getNazwa(), biura.getDataZalozenia(), biura.getIdAdresu(), biura.getIdPracownika());
    }

    // Update Biura
    public int updateBiura(Biura biura) {
        String sql = "UPDATE Biura SET Nazwa = ?, Data_zalozenia = ?, Id_adresu = ?, Id_pracownika = ? WHERE Id_biura = ?";
        return jdbcTemplate.update(sql, biura.getNazwa(), biura.getDataZalozenia(), biura.getIdAdresu(), biura.getIdPracownika(), biura.getIdBiura());
    }

    // Delete Biura
    public int deleteBiura(Integer id) {
        String sql = "DELETE FROM Biura WHERE Id_biura = ?";
        return jdbcTemplate.update(sql, id);
    }
}

