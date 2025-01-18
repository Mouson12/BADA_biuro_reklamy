package bdbt_bada_project.SpringApplication.models;

import java.util.Date;

public class Biura {
    private Integer idBiura;
    private String nazwa;
    private Date dataZalozenia;
    private Integer idAdresu;
    private Integer idPracownika;

    // Getters and Setters
    public Integer getIdBiura() {
        return idBiura;
    }

    public void setIdBiura(Integer idBiura) {
        this.idBiura = idBiura;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getDataZalozenia() {
        return dataZalozenia;
    }

    public void setDataZalozenia(Date dataZalozenia) {
        this.dataZalozenia = dataZalozenia;
    }

    public Integer getIdAdresu() {
        return idAdresu;
    }

    public void setIdAdresu(Integer idAdresu) {
        this.idAdresu = idAdresu;
    }

    public Integer getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(Integer idPracownika) {
        this.idPracownika = idPracownika;
    }
}
