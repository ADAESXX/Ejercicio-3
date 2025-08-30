import java.util.ArrayList;

public class Reporte {
    private ArrayList<Clase> clases = new ArrayList<>();
    
    //Constructor
    public Reporte(ArrayList<Clase> clases){
        this.clases=clases;
    }
    //Se muestra el reporte de la opcion que se escoja
    // Total de personas inscritas → 1
    // Entrenadores con más alumnos → 2
    // Cantidad de alumnos por maestro → 3
    // Ejercicio realizado con mayor frecuencia → 4
        //Piernas
        //Brazo
        //Abdomen
        //Gluteos
        //Cardio
        //Espalda
        //Descanso
    // Rutinas/ Ejercicio activo en determinado momento → 5
    // Reporte por clase (entrenador y sus alumnos )  → 6
    public String reportePorOpcion(int newopcion){
        String reporte="";
        // en la mayoría de los casos se recorren los arreglos para obtener la información de las clases
        switch (newopcion) {
            //total de alumnos inscritos
            case 1:
            int total=0;
                for (Clase c: clases){
                    total+=c.getAlumnos().size();
        
                }
                reporte= "El total de alumnos inscritos es de: "+ total;
                break;
            // entrenador con mas alumnos
            case 2:
                String nombreEntrenadorMax="";
                int maxAlumnos=0;
                for (Clase c: clases){
                    if(c.getAlumnos().size()>maxAlumnos){
                        maxAlumnos=c.getAlumnos().size();
                        nombreEntrenadorMax=c.getEntrenador().getNombre();

                    }
                }
                reporte= "El entrenador " + nombreEntrenadorMax + " es el que más alumnos tiene, con un total de: " + maxAlumnos;
                break;
            //cantidad de alumnos por maestro
            case 3:
                for (Clase c: clases){
                    reporte+= "El entrenador " + c.getEntrenador().getNombre() + " tiene un total de " + c.getAlumnos().size()+" de alumnos\n";
                }
                break;
            //ejercicio realizado con mayor frecuencia
            case 4:
                int piernas = 0, brazos = 0, abdomen = 0, gluteos = 0, cardio = 0, espalda = 0, descanso = 0;
                
                for(Clase c: clases){
                    for(Alumnos a: c.getAlumnos()){
                        for (Rutina r: a.getRutina()){
                            //esto permite contar la cantidad de veces que se repetien las opciones de ejercicios
                            String[] ejercicios = {r.getRLunes(), r.getRMartes(), r.getRMiercoles(),r.getRJueves(), r.getRViernes(), r.getRSabado(), r.getRDomingo()};
                            for( String e: ejercicios){
                                if(e==null){
                                    continue;
                                }
                                else{
                                    switch (e.toLowerCase()) {
                                        case "piernas": 
                                            piernas++; 
                                            break;
                                        case "brazos": 
                                            brazos++; 
                                            break;
                                        case "abdomen": 
                                            abdomen++; 
                                            break;
                                        case "gluteos": 
                                            gluteos++; 
                                            break;
                                        case "cardio": 
                                            cardio++; 
                                            break;
                                        case "espalda": 
                                            espalda++; 
                                            break;
                                        case "descanso": 
                                            descanso++; 
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
                int[] valores = {piernas, brazos, abdomen, gluteos, cardio, espalda, descanso};
                String[] nombres = {"Piernas", "Brazos", "Abdomen", "Gluteos", "Cardio", "Espalda", "Descanso"};
                
                int max=0;
                String ejercicioMasFrecuente="";
                for (int i=0; i<valores.length; i++){
                    if (valores[i]> max){
                        max=valores[i];
                        ejercicioMasFrecuente= nombres[i];
                    }
                }
                reporte="Ejercicio más frecuente: " + ejercicioMasFrecuente + "\ncon un total de " + max + "repeticiones";
                break;
            //rutinas activas
            case 5:
                int activas=0;
                for (Clase c: clases){
                    for (Alumnos a: c.getAlumnos()){
                        activas+=a.getRutina().size();
                    }
                }
                reporte="Total de rutinas activas: " + activas;
                break;
            // reporte por clase
            case 6:
                for (Clase c: clases){
                    reporte+="*****************************************\nEntrendor: " + c.getEntrenador().getNombre();
                    for (Alumnos a: c.getAlumnos()){
                        reporte+="- Alumno: " + a.getNombre() + "rutina: " + a.getRutina() + "\n";
                    }
                    reporte+="*****************************************";
                }
                break;
            
            default:
                throw new AssertionError();
        }
        return reporte;
    }
}
