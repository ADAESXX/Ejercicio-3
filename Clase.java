
import java.util.ArrayList;

public class Clase {
    private Entrenadores entrenador;
    private ArrayList<Alumnos> alumnos;

    //Constructor
    public Clase(){
        alumnos= new ArrayList<>();
    }

    //setters y getters de cada uno de los atributos
    public void setEntrenador(Entrenadores newentrenador){
        this.entrenador=newentrenador;
    }
    public Entrenadores getEntrenador(){
        return entrenador;
    }


    public void setAlumnos(Alumnos newalumnos){
        alumnos.add(newalumnos);
    }
    public ArrayList<Alumnos> getAlumnos(){
        return alumnos;
    }
}
