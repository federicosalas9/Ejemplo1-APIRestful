public class IntegranteException extends Exception {

    public IntegranteException(){ //lo hago por si quisiera hacer algo en particular en el constructor. Se  agrega porque hay otro cons con params
        super(); //llamo al constructor por defecto de la clase Exception.
    }

    public IntegranteException(String mensaje){
        super(mensaje);
    }
}
