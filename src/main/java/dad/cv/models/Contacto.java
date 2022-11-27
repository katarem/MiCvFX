package dad.cv.models;

import java.util.List;

import javafx.beans.binding.ListExpression;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Contacto {
    
    ListProperty<Telefono> telefonos = new SimpleListProperty<Telefono>(FXCollections.observableArrayList());
    ListProperty<Email> emails = new SimpleListProperty<Email>(FXCollections.observableArrayList());
    ListProperty<Web> webs = new SimpleListProperty<Web>(FXCollections.observableArrayList());

    public final ListProperty<Telefono> telefonosProperty() {
        return this.telefonos;
    }
    
    public final ObservableList<Telefono> getTelefonos() {
        return telefonos.get();
    }
    
    public final void addTelefono(final Telefono telefono) {
        this.getTelefonos().add(telefono);
    }

    public final ListProperty<Email> emailsProperty() {
        return this.emails;
    }
    
    public final List<Email> getEmails() {
        return ListExpression.listExpression(emails);
    }
    
    public final void addEmail(final Email email) {
        this.emails.add(email);
    }

    public final ListProperty<Web> websProperty() {
        return this.webs;
    }
    
    public final List<Web> getWebs() {
        return ListExpression.listExpression(webs);
    }
    
    public final void addWeb(final Web web) {
        this.webs.add(web);
    }
}
