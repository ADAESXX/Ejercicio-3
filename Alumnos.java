import java.util.*;
public class Alumnos{
    private String nombre;
    private int tipoMebresia;// 1→normal 2→VIP
    private int entrenadorEscogido;
    private ArrayList<Rutina> rutina;

    //Constructor
    public Alumnos(){
       rutina = new ArrayList<>(); 
    }

    //setters y getters de cada uno de los atributos
    public void setNombre(String newnombre){
        this.nombre=newnombre;
    }
    public String getNombre(){
        return nombre;
    }


    public void setTipoMebresia(int newtipoMembresia){
        this.tipoMebresia=newtipoMembresia;
    }
    public int getTipoMembresia(){
        return tipoMebresia;

    }


    public void setEntrenadorEscogido(int newentrenadorEscogido){
        this.entrenadorEscogido=newentrenadorEscogido;
    }
    public int getEntrenadorEscogido(){
        return entrenadorEscogido;
    }

    public void setRutina(Rutina newrutina){
        rutina.add(newrutina);
    }
    public ArrayList<Rutina> getRutina(){
        return rutina;

    }

}