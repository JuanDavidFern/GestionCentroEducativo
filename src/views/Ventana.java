package views;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tabedPane = new JTabbedPane();
		tabedPane.add("Cursos", new VentanaGestionCurso());
		tabedPane.add("Estudiantes", new VentanaGestionEstudiante());
		tabedPane.add("Profesores", new VentanaGestionProfesor());
		tabedPane.add("Materias", new VentanaGestionMateria());
		tabedPane.add("Valoracion Materia", new VentanaGestionValoracionMateria());
		this.setContentPane(tabedPane);		
	}

}
