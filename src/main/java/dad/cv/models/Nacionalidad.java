package dad.cv.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Nacionalidad {
    
    private StringProperty denominacion = new SimpleStringProperty();

    public Nacionalidad(final String denominacion){
        this.setdenominacion(denominacion);
    }
    public Nacionalidad(){
    }

    public final StringProperty denominacionProperty() {
        return this.denominacion;
    }
    
    public final String getdenominacion() {
        return this.denominacionProperty().get();
    }
    
    public final void setdenominacion(final String denominacion) {
        this.denominacionProperty().set(denominacion);
    }

    public String toString(){
        return getdenominacion();
    }

}
