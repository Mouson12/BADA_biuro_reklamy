package bdbt_bada_project.SpringApplication.models;

import java.util.Date;

public class Kampanie {
    private Integer idKampanii;
    private String nazwa;
    private String opis;
    private Date dataRozpoczecia;
    private Date dataZakonczenia;
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

    public Date getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(Date dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public Date getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(Date dataZakonczenia) {
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
