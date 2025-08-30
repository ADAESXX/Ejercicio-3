import java.io.*;
import java.util.*;

public class Archivo {
    public Archivo(){
        
    }
    public boolean escribir(ArrayList<Clase> clases) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("gimnasio.csv"))) {
            for (Clase c : clases) {
                for (Alumnos a : c.getAlumnos()) {
                    pw.println(a.getNombre() + ";" + a.getTipoMembresia() + ";" + a.getRutina().toString() + 
                               c.getEntrenador().getNombre());
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean leer() {
        try (BufferedReader br = new BufferedReader(new FileReader("gimnasio.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
