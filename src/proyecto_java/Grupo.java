package proyecto_java;

import java.util.ArrayList;

public class Grupo{
    private String codigo;
    private int capacidad;
    private String profesor;
    private Materia materia;
    private ArrayList<Horario> horarios;
    
    public Grupo(){
        this.codigo = "";
        this.capacidad = 0;
        this.profesor = "";
        this.materia = null;
        this.horarios = new ArrayList<>();
    }
    
    public Grupo(String codigo, int capacidad, String profesor, Materia materia) {
        setCodigo(codigo);
        setCapacidad(capacidad);
        setProfesor(profesor);
        setMateria(materia);
        this.horarios = new ArrayList<>();
    }
    
    public void agregarHorario(Horario horario){
        Validacion.validarHorario(horario);
        if(!horarios.contains(horario)){
            horarios.add(horario);
            horario.setGrupo(this);
        }
    }
    
    public ArrayList<Horario> getHorarios(){
        return new ArrayList<>(horarios);
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setCodigo(String codigo){
        Validacion.validarCodigoStr(codigo);
        this.codigo = codigo;
    }
    
    public int getCapacidad(){
        return capacidad;
    }
    
    public void setCapacidad(int capacidad){
        Validacion.validarCapacidad(capacidad);
        this.capacidad = capacidad;
    }
    
    public String getProfesor(){
        return profesor;
    }
    
    public void setProfesor(String profesor){
        Validacion.validarNombre(profesor);
        this.profesor = profesor;
    }
    
    public Materia getMateria(){
        return materia;
    }
    
    public void setMateria(Materia materia){
        Validacion.validarMateria(materia);
        this.materia = materia;
    }
    
    @Override
    public String toString() {
        return "Grupo " + codigo + "-> Capacidad: " + capacidad + "-> Profesor: " + profesor;
    }
}
