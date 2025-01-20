package bdbt_bada_project.SpringApplication.dao;

import bdbt_bada_project.SpringApplication.models.Adresy;
import bdbt_bada_project.SpringApplication.models.Biura;
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

    public Adresy getAdresById(int id) {
        String sql = "SELECT * FROM SYSTEM.ADRESY WHERE ID_ADRESU = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Adresy.class));
    }

    public Biura getBiuroById(int id) {
        String sql = "SELECT * FROM SYSTEM.BIURA WHERE ID_BIURA = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Biura.class));
    }

    // Insert a new Klienci
    public int saveKlienci(Klienci klienci) {
        String sql = "INSERT INTO Klienci (Id_klienta, Imie, Nazwisko, Email, Telefon, Id_biura, Id_adresu) VALUES (SEQ_KLIENCI.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, klienci.getImie(), klienci.getNazwisko(), klienci.getEmail(), klienci.getTelefon(), klienci.getIdBiura(), klienci.getIdAdresu());
    }

    // Update Klienci
    public int updateKlienci(Klienci klienci) {
        String sql = "UPDATE Klienci SET Imie = ?, Nazwisko = ?, Id_adresu = ?, Email = ?, Telefon = ?, Id_biura = ? WHERE Id_klienta = ?";
        return jdbcTemplate.update(sql, klienci.getImie(), klienci.getNazwisko(), klienci.getIdAdresu(), klienci.getEmail(), klienci.getTelefon(), klienci.getIdBiura(), klienci.getIdKlienta());
    }

    // Delete Klienci
    public int deleteKlienci(Integer id) {
        String sql = "DELETE FROM Klienci WHERE Id_klienta = ?";
        return jdbcTemplate.update(sql, id);
    }
}