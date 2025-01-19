package bdbt_bada_project.SpringApplication.models;

import java.time.LocalDate;
import java.util.Date;

public class Kampanie {
    private Integer idKampanii;
    private String nazwa;
    private String opis;
    private LocalDate  dataRozpoczecia;
    private LocalDate dataZakonczenia;
    private Double budzet;
    private Integer idKlienta;
    private Integer idBiura;

    // Getters and Setters
    public Integer getIdKampanii() {
        return idKampanii;
    }

    public void setIdKampanii(Integer idKampanii) {
        this.idKampanii = idKampanii;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDate  getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(LocalDate  dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public LocalDate  getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDate  dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
    }

    public Double getBudzet() {
        return budzet;
    }

    public void setBudzet(Double budzet) {
        this.budzet = budzet;
    }

    public Integer getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(Integer idKlienta) {
        this.idKlienta = idKlienta;
    }

    public Integer getIdBiura() {
        return idBiura;
    }

    public void setIdBiura(Integer idBiura) {
        this.idBiura = idBiura;
    }
}
