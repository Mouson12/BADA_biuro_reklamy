package bdbt_bada_project.SpringApplication.models;

import java.util.Date;

public class Pracownicy {
    private Integer idPracownika;
    private String imie;
    private String nazwisko;
    private Date dataUrodzenia;
    private String pesel;
    private String plec;
    private Integer idBiura;
    private Integer idPlacowki;
    private Integer idStanowiska;

    // Getters and Setters
    public Integer getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(Integer idPracownika) {
        this.idPracownika = idPracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Integer getIdBiura() {
        return idBiura;
    }

    public void setIdBiura(Integer idBiura) {
        this.idBiura = idBiura;
    }

    public Integer getIdPlacowki() {
        return idPlacowki;
    }

    public void setIdPlacowki(Integer idPlacowki) {
        this.idPlacowki = idPlacowki;
    }

    public Integer getIdStanowiska() {
        return idStanowiska;
    }

    public void setIdStanowiska(Integer idStanowiska) {
        this.idStanowiska = idStanowiska;
    }
}
