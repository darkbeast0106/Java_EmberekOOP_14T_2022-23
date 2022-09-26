package hu.petrik.emberekoop;

import java.time.LocalDate;
import java.time.Period;

public class Ember {
    private String nev;
    private String szulDatum;
    private String szulHely;

    public Ember(String nev, String szulDatum, String szulHely) {
        this.nev = nev;
        this.szulDatum = szulDatum;
        this.szulHely = szulHely;
    }

    public int getSzuletesiEv() {
        return Integer.parseInt(szulDatum.substring(0, 4));
    }

    public int getSzuletesiHonap() {
        return Integer.parseInt(szulDatum.split("-")[1]);
    }

    public int getSzuletesiNap() {
        return Integer.parseInt(szulDatum.split("-")[2]);
    }

    public int getEletkor() {
        LocalDate maiDatum = LocalDate.now();
        boolean voltESzuletesnapjaIden = maiDatum.getMonth().getValue() > this.getSzuletesiHonap()
                || (maiDatum.getMonth().getValue() == this.getSzuletesiHonap()
                && maiDatum.getDayOfMonth() >= this.getSzuletesiNap());
        int eletkor = maiDatum.getYear() - this.getSzuletesiEv();
        if (!voltESzuletesnapjaIden) {
            eletkor--;
        }
        return eletkor;
    }

    public int getEletkorDatumkent(){
        LocalDate maiDatum = LocalDate.now();
        LocalDate szulDatum = LocalDate.of(this.getSzuletesiEv(), this.getSzuletesiHonap(), this.getSzuletesiNap());
        Period elteltIdo = Period.between(szulDatum, maiDatum);
        return elteltIdo.getYears();
    }

    @Override
    public String toString() {
        return String.format("%-30s %10s (%d) %20s", this.nev, this.szulDatum, this.getEletkorDatumkent(), this.szulHely);
    }
}
