package proyecto_java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class Lector {
    private Lector(){
    }
    
    public static ArrayList<Materia> lectorMaterias(String filePath){
        ArrayList<Materia> Materias = new ArrayList<>();
        String line;
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();
            
            while((line = reader.readLine())!= null){
                String [] parts = line.split(",");
                
                try{
                    if(parts.length>=2){
                        String nombre = parts[0].trim();
                        int codigo = Integer.parseInt(parts[1].trim());
                        
                        Materias.add(new Materia(nombre,codigo));
                    }else{
                        System.out.println("Informacion incompleta para crear el objeto");
                    }
                }catch(Exception e){
                    System.out.println("Error creando el objeto: " + e.getMessage());
                }
            }
        }catch(IOException e){
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
        return Materias;
    }
    public static ArrayList<Grupo> lectorGrupos(String filePath, ArrayList<Materia> materias){
        ArrayList<Grupo> grupos = new ArrayList<>();       
        String line;
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();
            
            while((line = reader.readLine())!= null){
                String [] parts = line.split(",");
                
                try{
                    if(parts.length>=4){
                        String codigo = parts[0].trim();
                        int capacidad = Integer.parseInt(parts[1].trim());
                        String profesor = parts[2].trim();
                        int codigoMateria = Integer.parseInt(parts[3].trim());
                        Materia materia = null;
                        
                        for(Materia m: materias){
                            if(m.getCodigo() == codigoMateria){
                                materia = m;
                            }
                        }
                        grupos.add(new Grupo(codigo,capacidad,profesor,materia));
                    }else{
                        System.out.println("Informacion incompleta para crear el objeto");
                    }
                }catch(Exception e){
                    System.out.println("Error creando el objeto: " + e.getMessage());
                }
            }
        }catch(IOException e){
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
        return grupos;
    }
    public static ArrayList<Horario> lectorHorarios(String filePath, ArrayList<Grupo> grupos){
        ArrayList<Horario> horarios = new ArrayList<>();
        String line;
        
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            reader.readLine();
            
            while((line = reader.readLine())!= null){
                String [] parts = line.split(",");
                
                try{
                    if(parts.length>=6){
                        String dia = parts[0].trim();
                        int horaInicio = Integer.parseInt(parts[1].trim());
                        int horaFin = Integer.parseInt(parts[2].trim());
                        String edificio = parts[3].trim();
                        String salon = parts[4].trim();
                        String codigoGrupo = parts[5].trim();
                        Grupo grupo = null;
                        
                        for(Grupo g: grupos){
                            if(g.getCodigo().equals(codigoGrupo)){
                                grupo = g;
                            }
                        }
                        horarios.add(new Horario(dia, horaInicio, horaFin, edificio, salon, grupo));                        
                    }else{
                        System.out.println("Informacion incompleta para crear el objeto");
                    }
                }catch(Exception e){
                    System.out.println("Error leyendo el archivo: " + e.getMessage());
                }
            }
        }catch(IOException e){
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        }
        return horarios;
    }
}
