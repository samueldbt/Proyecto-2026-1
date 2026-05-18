package proyecto_java;
public class Validacion {
    public static void validarNombre(String nombre){
        if(nombre == null || nombre.trim().isEmpty() || !nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
            throw new IllegalArgumentException(nombre + " no es valido");
        }
    }
    public static void validarDia(String dia) {
        if (dia == null || dia.trim().isEmpty()) {
            throw new IllegalArgumentException("Dia invalido");
        }
        String diaMayus = dia.toUpperCase();
        switch (diaMayus) {
        case "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO" -> {
            }
        default -> throw new IllegalArgumentException("Dia invalido");
        }
    }
    public static void validarCodigoStr(String codigo){
        if(codigo == null || codigo.trim().isEmpty()){
            throw new IllegalArgumentException(codigo + " no es valido");
        }
    }
    public static void validarCodigoInt(int codigo){
        if(codigo < 0){
            throw new IllegalArgumentException(codigo + " no es valido");
        }    
    }
    public static void validarCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("Capacidad invalida");
        }
    }
    public static void validarRangoHorario(int horaInicio, int horaFin){
        if (horaInicio < 0 || horaInicio > 23){
            throw new IllegalArgumentException("Hora de Inicio invalida");
        }
        if (horaFin < 0 || horaFin > 23){
            throw new IllegalArgumentException("Hora de Finalizacion invalida");
        }
        if (horaInicio >= horaFin) {
            throw new IllegalArgumentException("El rango horario es invalido");
        }
    }
    public static void validarMateria(Materia materia){
        if (materia == null){
            throw new IllegalArgumentException("Materia null");
        }
    }
    public static void validarGrupo(Grupo grupo) {
        if (grupo == null) {
            throw new IllegalArgumentException("Grupo null");
        }
    }
    public static void validarHorario(Horario horario) {
        if (horario == null) {
            throw new IllegalArgumentException("Horario null");
        }
    }
}