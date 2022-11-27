package dad.cv;

import dad.cv.models.Nacionalidad;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

public class prueba {
    public static void main(String[] args) {
        ListProperty<Nacionalidad> nacionalidades = new SimpleListProperty<Nacionalidad>();
        nacionalidades.add(new Nacionalidad("español"));
        System.out.println(nacionalidades);
    }
}
