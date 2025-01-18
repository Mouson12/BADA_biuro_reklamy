package bdbt_bada_project.SpringApplication.models;

public class Adresy {
    private Integer idAdresu;
    private String miasto;
    private String ulica;
    private String nrBudynku;
    private String nrLokalu;
    private String kodPocztowy;

    // Getters and Setters
    public Integer getIdAdresu() {
        return idAdresu;
    }

    public void setIdAdresu(Integer idAdresu) {
        this.idAdresu = idAdresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrBudynku() {
        return nrBudynku;
    }

    public void setNrBudynku(String nrBudynku) {
        this.nrBudynku = nrBudynku;
    }

    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }
}
