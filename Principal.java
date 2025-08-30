import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Principal {

    private JFrame frame;


    private ArrayList<Clase> clases = new ArrayList<>();
    private ArrayList<Entrenadores> entrenadores = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Principal window = new Principal();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Principal() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Sistema Gimnasio");
        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Menú Alumno
        JMenu menuAlumno = new JMenu("Alumno");
        menuBar.add(menuAlumno);

        JMenuItem nuevoAlumno = new JMenuItem("Nuevo Alumno");
        menuAlumno.add(nuevoAlumno);
        nuevoAlumno.addActionListener(e -> mostrarFormularioAlumno());

        // Menú Entrenador
        JMenu menuEntrenador = new JMenu("Entrenador");
        menuBar.add(menuEntrenador);

        JMenuItem nuevoEntrenador = new JMenuItem("Nuevo Entrenador");
        menuEntrenador.add(nuevoEntrenador);
        nuevoEntrenador.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog(frame, "Nombre del Entrenador:");
            if (nombre != null && !nombre.isEmpty()) {
                Entrenadores ent = new Entrenadores();
                ent.setNombre(nombre);
                entrenadores.add(ent);
                JOptionPane.showMessageDialog(frame, "Entrenador " + nombre + " creado.");
            }
        });

        // Menú Reportes
        JMenu menuReportes = new JMenu("Reportes");
        menuBar.add(menuReportes);

        JMenuItem verReportes = new JMenuItem("Ver Reportes");
        menuReportes.add(verReportes);
        verReportes.addActionListener(e -> mostrarReportes());

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        menuBar.add(menuArchivo);

        JMenuItem guardarCSV = new JMenuItem("Guardar CSV");
        menuArchivo.add(guardarCSV);
        guardarCSV.addActionListener(e -> {
            Archivo archivo = new Archivo();
            if(archivo.escribir(clases)) {
                JOptionPane.showMessageDialog(frame,"Archivo guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(frame,"Error al guardar archivo");
            }
        });

        JMenuItem abrirCSV = new JMenuItem("Abrir CSV");
        menuArchivo.add(abrirCSV);
        abrirCSV.addActionListener(e -> {
            Archivo archivo = new Archivo();
            if(archivo.leer()) {
                JOptionPane.showMessageDialog(frame,"Archivo leído correctamente (revisa consola)");
            } else {
                JOptionPane.showMessageDialog(frame,"Error al leer archivo");
            }
        });

        frame.getContentPane().setLayout(null);
    }

    private void mostrarFormularioAlumno() {
        if(entrenadores.isEmpty()) {
            JOptionPane.showMessageDialog(frame,"Primero agrega un entrenador.");
            return;
        }

        JDialog dialog = new JDialog(frame,"Nuevo Alumno",true);
        dialog.setSize(400,500);
        dialog.setLayout(null);

        // Datos del alumno
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20,20,100,25);
        dialog.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(140,20,200,25);
        dialog.add(txtNombre);

        JLabel lblMembresia = new JLabel("Tipo Membresía (1→Normal 2→VIP):");
        lblMembresia.setBounds(20,60,250,25);
        dialog.add(lblMembresia);

        JTextField txtTipo = new JTextField();
        txtTipo.setBounds(250,60,50,25);
        dialog.add(txtTipo);

        JLabel lblEntrenador = new JLabel("Selecciona Entrenador:");
        lblEntrenador.setBounds(20,100,200,25);
        dialog.add(lblEntrenador);

        String[] nombresEntrenadores = entrenadores.stream().map(Entrenadores::getNombre).toArray(String[]::new);
        JComboBox<String> comboEntrenador = new JComboBox<>(nombresEntrenadores);
        comboEntrenador.setBounds(180,100,160,25);
        dialog.add(comboEntrenador);

        // Rutina con ComboBox
        JLabel lblRutina = new JLabel("Rutina semanal:");
        lblRutina.setBounds(20,140,200,25);
        dialog.add(lblRutina);

        String[] ejercicios = {"Piernas", "Brazos", "Abdomen", "Gluteos", "Cardio", "Espalda", "Descanso"};

        JComboBox<String> comboLunes = new JComboBox<>(ejercicios);
        comboLunes.setBounds(20,170,150,25); dialog.add(comboLunes);

        JComboBox<String> comboMartes = new JComboBox<>(ejercicios);
        comboMartes.setBounds(200,170,150,25); dialog.add(comboMartes);

        JComboBox<String> comboMiercoles = new JComboBox<>(ejercicios);
        comboMiercoles.setBounds(20,210,150,25); dialog.add(comboMiercoles);

        JComboBox<String> comboJueves = new JComboBox<>(ejercicios);
        comboJueves.setBounds(200,210,150,25); dialog.add(comboJueves);

        JComboBox<String> comboViernes = new JComboBox<>(ejercicios);
        comboViernes.setBounds(20,250,150,25); dialog.add(comboViernes);

        JComboBox<String> comboSabado = new JComboBox<>(ejercicios);
        comboSabado.setBounds(200,250,150,25); dialog.add(comboSabado);

        JComboBox<String> comboDomingo = new JComboBox<>(ejercicios);
        comboDomingo.setBounds(20,290,150,25); dialog.add(comboDomingo);

        // Botón guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(140,340,100,30);
        dialog.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            int tipo;
            try { tipo = Integer.parseInt(txtTipo.getText()); } 
            catch(Exception ex) { JOptionPane.showMessageDialog(dialog,"Tipo de membresía inválido"); return; }

            int idxEntrenador = comboEntrenador.getSelectedIndex();
            Entrenadores ent = entrenadores.get(idxEntrenador);

            Alumnos alumno = new Alumnos();
            alumno.setNombre(nombre);
            alumno.setTipoMebresia(tipo);
            alumno.setEntrenadorEscogido(idxEntrenador);

            Rutina rutina = new Rutina();
            rutina.setRLunes((String)comboLunes.getSelectedItem());
            rutina.setRMartes((String)comboMartes.getSelectedItem());
            rutina.setRMiercoles((String)comboMiercoles.getSelectedItem());
            rutina.setRJueves((String)comboJueves.getSelectedItem());
            rutina.setRViernes((String)comboViernes.getSelectedItem());
            rutina.setRSabado((String)comboSabado.getSelectedItem());
            rutina.setRDomingo((String)comboDomingo.getSelectedItem());

            alumno.setRutina(rutina);

            // Buscar clase existente para el entrenador
            Clase clase = null;
            for(Clase c: clases) {
                if(c.getEntrenador().getNombre().equals(ent.getNombre())) {
                    clase = c; break;
                }
            }
            if(clase==null) {
                clase = new Clase();
                clase.setEntrenador(ent);
                clases.add(clase);
            }
            clase.setAlumnos(alumno);

            JOptionPane.showMessageDialog(dialog,"Alumno agregado exitosamente");
            dialog.dispose();
        });

        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    private void mostrarReportes() {
        if(clases.isEmpty()) {
            JOptionPane.showMessageDialog(frame,"No hay clases registradas");
            return;
        }
        String opcionStr = JOptionPane.showInputDialog(frame,
                "Selecciona reporte:\n1-Total Alumnos\n2-Entrenador con más alumnos\n3-Cantidad de alumnos por maestro\n4-Ejercicio más frecuente\n5-Rutinas activas\n6-Reporte por clase");
        int opcion;
        try { opcion = Integer.parseInt(opcionStr); } catch(Exception e) { return; }

        Reporte reporte = new Reporte(clases);
        String resultado = reporte.reportePorOpcion(opcion);

        JTextArea textArea = new JTextArea(resultado);
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(500,300));

        JOptionPane.showMessageDialog(frame, scroll,"Reporte",JOptionPane.INFORMATION_MESSAGE);
    }
}
