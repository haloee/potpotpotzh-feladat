package hu.pte.mik.prog4.entity;

import java.util.Objects;

public class RoleEntity {
    private Long azonosito;
    private String kod;
    private String leiras;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return Objects.equals(azonosito, that.azonosito) && Objects.equals(kod, that.kod) && Objects.equals(leiras, that.leiras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(azonosito, kod, leiras);
    }

    public Long getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(Long azonosito) {
        this.azonosito = azonosito;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
}
