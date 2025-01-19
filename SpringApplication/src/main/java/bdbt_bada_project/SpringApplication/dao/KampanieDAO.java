package bdbt_bada_project.SpringApplication.dao;

import bdbt_bada_project.SpringApplication.models.Kampanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KampanieDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all Kampanie
    public List<Kampanie> getAllKampanie() {
        String sql = "SELECT * FROM Kampanie";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Kampanie.class));
    }

    // Get Kampanie for specific Klient
    public List<Kampanie> getAllKampanieByKlientId(Integer Id_klienta) {
        String sql = "SELECT * FROM Kampanie WHERE Id_klienta = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Kampanie.class), Id_klienta);
    }

    // Get a single Kampanie by ID
    public Kampanie getKampanieById(Integer id) {
        String sql = "SELECT * FROM Kampanie WHERE Id_kampanii = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Kampanie.class), id);
    }

    // Add a new Kampanie
    public int saveKampanie(Kampanie kampanie) {
        String sql = "INSERT INTO Kampanie (Id_kampanii, Nazwa, Opis, Data_rozpoczecia, Data_zakonczenia, Budzet, Id_klienta, Id_biura) VALUES (SEQ_KAMPANIE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, kampanie.getNazwa(), kampanie.getOpis(), kampanie.getDataRozpoczecia(), kampanie.getDataZakonczenia(), kampanie.getBudzet(), kampanie.getIdKlienta(), kampanie.getIdBiura());
    }

    // Update Kampanie
    public int updateKampanie(Kampanie kampanie) {
        String sql = "UPDATE Kampanie SET Nazwa = ?, Opis = ?, Data_rozpoczecia = ?, Data_zakonczenia = ?, Budzet = ?, Id_klienta = ?, Id_biura = ? WHERE Id_kampanii = ?";
        return jdbcTemplate.update(sql, kampanie.getNazwa(), kampanie.getOpis(), kampanie.getDataRozpoczecia(), kampanie.getDataZakonczenia(), kampanie.getBudzet(), kampanie.getIdKlienta(), kampanie.getIdBiura(), kampanie.getIdKampanii());
    }

    // Delete Kampanie
    public int deleteKampanie(Integer id) {
        String sql = "DELETE FROM Kampanie WHERE Id_kampanii = ?";
        return jdbcTemplate.update(sql, id);
    }
}
