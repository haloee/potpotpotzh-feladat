package hu.pte.mik.prog4.entity;

import java.util.Objects;

public class UserEntity {
    private Long azonosito;
    private String felhasznalonev;
    private String jelszo;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(azonosito, that.azonosito) && Objects.equals(felhasznalonev, that.felhasznalonev) && Objects.equals(jelszo, that.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(azonosito, felhasznalonev, jelszo);
    }

    public Long getAzonosito() {
        return azonosito;
    }

    public void setAzonosito(Long azonosito) {
        this.azonosito = azonosito;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }
}
