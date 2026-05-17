package proyecto_java;
public class Horario {
    private String dia;
    private int horaInicio;
    private int horaFin;
    private String edificio;
    private String salon;
    private Grupo grupo;
    
    public Horario(){
        this.dia = "";
        this.horaInicio = 0;
        this.horaFin = 0;
        this.edificio = "";
        this.salon = "";
        this.grupo = null;
    }

    public Horario(String dia, int horaInicio, int horaFin, String edificio, String salon, Grupo grupo) {
        setDia(dia);
        setRangoHorario(horaInicio, horaFin);
        setEdificio(edificio);
        setSalon(salon);
        setGrupo(grupo);
    }
    
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        Validacion.validarDia(dia);
        this.dia = dia;
    }

    public int getHoraInicio() {
        return horaInicio;
    }
    
    public int getHoraFin() {
        return horaFin;
    }
    
    public void setRangoHorario(int horaInicio, int horaFin) {
        Validacion.validarRangoHorario(horaInicio, horaFin);
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        Validacion.validarNombre(edificio);
        this.edificio = edificio;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        Validacion.validarCodigoStr(salon);
        this.salon = salon;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    @Override
    public String toString() {
        return "Dia: " + dia + " -> " + "Edificio: " + edificio + " -> Salon: " + salon + " -> " + horaInicio + "-" + horaFin;
    }
}
