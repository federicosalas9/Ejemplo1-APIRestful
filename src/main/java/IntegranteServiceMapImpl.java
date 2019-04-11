import java.util.Collection;
import java.util.HashMap;

public class IntegranteServiceMapImpl implements IntegranteService{

    private HashMap<String,Integrante> integranteMap;

    public IntegranteServiceMapImpl(){ //inicializo el map para evitar errores

        integranteMap=new HashMap<String, Integrante>();
    }

    @Override
    public void addIntegrante(Integrante integrante) {
        integranteMap.put(integrante.getId(),integrante);
    }

    @Override
    public Collection<Integrante> getIntegrantes() {

        return integranteMap.values();
    }

    @Override
    public Integrante getIntegrante(String id) {

        return integranteMap.get(id);
    }

    @Override
    public Integrante editIntegrante(Integrante integrante) throws IntegranteException {
        try{
            if(integrante.getId()==null){
                throw new IntegranteException("el id del integrante no puede ser nulo");
            }
            Integrante integranteEditar=integranteMap.get(integrante.getId());
            //a partir de ahora modifico
            if(integrante.getNombre()!=null){
                integranteEditar.setNombre(integrante.getNombre());
            }
            if(integrante.getApellido()!=null){
                integranteEditar.setApellido(integrante.getApellido());
            }
            if(integrante.getCorreo()!=null){
                integranteEditar.setCorreo(integrante.getCorreo());
            }
            return integranteEditar;
        }catch (Exception exception){
            throw new IntegranteException(exception.getMessage());
        }
    }

    @Override
    public void deleteIntegrante(String id) {
        integranteMap.remove(id);
    }

    @Override
    public boolean integranteExist(String id) {
        return integranteMap.containsKey(id);
    }
}
