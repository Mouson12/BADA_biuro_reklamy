package bdbt_bada_project.SpringApplication.dao;

import bdbt_bada_project.SpringApplication.models.Klienci;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KlienciDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all Klienci
    public List<Klienci> getAllKlienci() {
        String sql = "SELECT * FROM Klienci";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Klienci.class));
    }

    // Get a single Klienci by ID
    public Klienci getKlienciById(Integer id) {
        String sql = "SELECT * FROM Klienci WHERE Id_klienta = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Klienci.class), id);
    }

    // Insert a new Klienci
    public int saveKlienci(Klienci klienci) {
        String sql = "INSERT INTO Klienci (Id_klienta, Imie, Nazwisko, Email, Telefon, Id_biura, Id_adresu) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, klienci.getImie(), klienci.getNazwisko(), klienci.getEmail(), klienci.getTelefon(), klienci.getIdBiura(), klienci.getIdAdresu());
    }

    // Update Klienci
    public int updateKlienci(Klienci klienci) {
        String sql = "UPDATE Klienci SET Imie = ?, Nazwisko = ?, Id_adresu = ?, Email = ?, Telefon = ? WHERE Id_klienta = ?";
        return jdbcTemplate.update(sql, klienci.getImie(), klienci.getNazwisko(), klienci.getIdAdresu(), klienci.getEmail(), klienci.getTelefon());
    }

    // Delete Klienci
    public int deleteKlienci(Integer id) {
        String sql = "DELETE FROM Klienci WHERE Id_klienta = ?";
        return jdbcTemplate.update(sql, id);
    }
}