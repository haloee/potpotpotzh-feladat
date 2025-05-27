package hu.pte.mik.prog4.entity;

import java.util.Objects;

public class TravelEntity {
    private Long uticelid;
    private String nev;
    private String tipus;
    private String leiras;
    private String orszag;
    public TravelEntity(){}

    public TravelEntity(Long uticelid, String nev, String tipus, String leiras, String orszag) {
        this.uticelid = uticelid;
        this.nev = nev;
        this.tipus = tipus;
        this.leiras = leiras;
        this.orszag = orszag;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TravelEntity that = (TravelEntity) o;
        return Objects.equals(uticelid, that.uticelid) && Objects.equals(nev, that.nev) && Objects.equals(tipus, that.tipus) && Objects.equals(leiras, that.leiras) && Objects.equals(orszag, that.orszag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uticelid, nev, tipus, leiras, orszag);
    }

    public Long getUticelid() {
        return uticelid;
    }

    public void setUticelid(Long uticelid) {
        this.uticelid = uticelid;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public String getOrszag() {
        return orszag;
    }

    public void setOrszag(String orszag) {
        this.orszag = orszag;
    }
}
