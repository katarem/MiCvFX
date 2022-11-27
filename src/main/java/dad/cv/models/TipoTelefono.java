package dad.cv.models;

public enum TipoTelefono{
    
    DOMICILIO(null),
    MOVIL(null);

    public Integer numero;

    private TipoTelefono(Integer numero){
        this.numero = numero;
    }
}