package bdbt_bada_project.SpringApplication.dao;

import bdbt_bada_project.SpringApplication.models.Pracownicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PracownicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all Pracownicy
    public List<Pracownicy> getAllPracownicy() {
        String sql = "SELECT * FROM Pracownicy";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pracownicy.class));
    }

    // Get a single Pracownik by ID
    public Pracownicy getPracownikById(Integer id) {
        String sql = "SELECT * FROM Pracownicy WHERE Id_pracownika = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Pracownicy.class), id);
    }

    // Add a new Pracownik
    public int savePracownik(Pracownicy pracownik) {
        String sql = "INSERT INTO Pracownicy (Id_pracownika, Imie, Nazwisko, Data_urodzenia, PESEL, Plec, Id_biura, Id_placowki, Id_stanowiska) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, pracownik.getIdPracownika(), pracownik.getImie(), pracownik.getNazwisko(),
                pracownik.getDataUrodzenia(), pracownik.getPesel(), pracownik.getPlec(),
                pracownik.getIdBiura(), pracownik.getIdPlacowki(), pracownik.getIdStanowiska());
    }

    // Update an existing Pracownik
    public int updatePracownik(Pracownicy pracownik) {
        String sql = "UPDATE Pracownicy SET Imie = ?, Nazwisko = ?, Data_urodzenia = ?, PESEL = ?, Plec = ?, " +
                "Id_biura = ?, Id_placowki = ?, Id_stanowiska = ? WHERE Id_pracownika = ?";
        return jdbcTemplate.update(sql, pracownik.getImie(), pracownik.getNazwisko(), pracownik.getDataUrodzenia(),
                pracownik.getPesel(), pracownik.getPlec(), pracownik.getIdBiura(),
                pracownik.getIdPlacowki(), pracownik.getIdStanowiska(), pracownik.getIdPracownika());
    }

    // Delete a Pracownik by ID
    public int deletePracownik(Integer id) {
        String sql = "DELETE FROM Pracownicy WHERE Id_pracownika = ?";
        return jdbcTemplate.update(sql, id);
    }
}

