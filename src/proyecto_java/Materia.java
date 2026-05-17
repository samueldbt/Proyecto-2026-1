package proyecto_java;
import java.util.ArrayList;

public class Materia {
    private String nombre;
    private int codigo;
    private ArrayList<Grupo> grupos;
    
    public Materia(){
        this.nombre = "";
        this.codigo = -1;
        this.grupos = new ArrayList<>();
    }
    
    public Materia(String nombre, int codigo){
        setNombre(nombre);
        setCodigo(codigo);
        this.grupos = new ArrayList<>();
    }
    public void agregarGrupo(Grupo grupo){
        Validacion.validarGrupo(grupo);
        if(!grupos.contains(grupo)){
            grupos.add(grupo);
            grupo.setMateria(this);
        }
    }
    public ArrayList<Grupo> getGrupos(){
        return new ArrayList<>(grupos);
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        Validacion.validarNombre(nombre);
        this.nombre = nombre;
    }
    
    public int getCodigo(){
        return codigo;
    }
    
    public void setCodigo(int codigo){
        Validacion.validarCodigoInt(codigo);
        this.codigo = codigo;
    }
    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}
