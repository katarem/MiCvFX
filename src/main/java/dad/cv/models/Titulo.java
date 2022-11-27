package dad.cv.models;

import java.time.LocalDate;

public class Titulo{

    private LocalDate desde, hasta;
    private String denominacion, organizador;

    public Titulo(LocalDate desde, LocalDate hasta, String denominacion, String organizador){
        this.desde = desde;
	    this.hasta = hasta;
	    this.denominacion = denominacion;
	    this.organizador = organizador;

    }

    public LocalDate getDesde() {
        return desde;
    }

    public void setDesde(LocalDate desde) {
        this.desde = desde;
    }

    public LocalDate getHasta() {
        return hasta;
    }

    public void setHasta(LocalDate hasta) {
        this.hasta = hasta;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }
    
}
