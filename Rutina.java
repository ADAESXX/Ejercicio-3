public class Rutina{
    private String rLunes;
    private String rMartes;
    private String rMiercoles;
    private String rJueves;
    private String rViernes;
    private String rSabado;
    private String rDomingo;

    //Constructor
    public Rutina(){

    }

    //setters y getters de cada uno de los atributos
    public void setRLunes(String newrLunes){
        this.rLunes=newrLunes;
    }
    public String getRLunes(){
        return rLunes;
    }

    public void setRMartes(String newrMartes){
        this.rMartes=newrMartes;
    }
    public String getRMartes(){
        return rMartes;
    }

    public void setRMiercoles(String newrMiercoles){
        this.rMiercoles=newrMiercoles;
    }
    public String getRMiercoles(){
        return rMiercoles;
    }

    public void setRJueves(String newrJueves){
        this.rJueves=newrJueves;
    }
    public String getRJueves(){
        return rJueves;
        
    }

    public void setRViernes(String newrViernes){
        this.rViernes=newrViernes;
    }
    public String getRViernes(){
        return rViernes;
    }

    public void setRSabado(String newrSabado){
        this.rSabado=newrSabado;
    }
    public String getRSabado(){
        return rSabado;
        
    }

    public void setRDomingo(String newrDomingo){
        this.rDomingo=newrDomingo;
    }
    public String getRDomingo(){
        return rDomingo;
    }

    //toString
    public String toString() {
        return "Lunes: " + rLunes + ", Martes: " + rMartes + ", Miércoles: " + rMiercoles +
               ", Jueves: " + rJueves + ", Viernes: " + rViernes + ", Sábado: " + rSabado +
               ", Domingo: " + rDomingo;
    }
}