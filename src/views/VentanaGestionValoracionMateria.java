package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import controllers.ControladorEstudiante;
import controllers.ControladorMateria;
import controllers.ControladorProfesor;
import controllers.ControladorValoracionMateria;

import models.Estudiante;
import models.Materia;
import models.Profesor;
import models.ValoracionMateria;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;


import javax.swing.JComboBox;

public class VentanaGestionValoracionMateria extends JPanel {
	private JTextField jtfId;
	private JButton btnCargarPrimerRegistro;
	private JButton btnCargarAnteriorRegistro;
	private JButton btnCargarSiguienteRegistro;
	private JButton btnCargarUltimoRegistro;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnNewButton;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Estudiante> jcbEstudiante;
	private JComboBox<Materia> jcbMateria;
	private JTextField jtfVal;

	/**
	 * Create the panel.
	 */
	public VentanaGestionValoracionMateria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0 };
		gridBagLayout.columnWidths = new int[] { 69, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabeltt = new JLabel("Gestion Valoracion Materias");
		lblNewLabeltt.setFont(new Font("Tahoma", Font.PLAIN, 34));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabeltt, gbc_lblNewLabel);

		JLabel lblNewLabel = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel1 = new GridBagConstraints();
		gbc_lblNewLabel1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel1.gridx = 0;
		gbc_lblNewLabel1.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel1);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfVal = new GridBagConstraints();
		gbc_jtfVal.insets = new Insets(0, 0, 5, 0);
		gbc_jtfVal.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfVal.gridx = 1;
		gbc_jtfVal.gridy = 1;
		add(jtfId, gbc_jtfVal);
		jtfId.setColumns(10);
		jtfId.setEnabled(false);

		JLabel lblNewLabel_1 = new JLabel("Profesor");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 2;
		add(jcbProfesor, gbc_jcbProfesor);

		JLabel lblNewLabel_2 = new JLabel("Estudiante");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbEstudiante = new JComboBox<Estudiante>();
		GridBagConstraints gbc_jcbEstudiante = new GridBagConstraints();
		gbc_jcbEstudiante.insets = new Insets(0, 0, 5, 0);
		gbc_jcbEstudiante.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbEstudiante.gridx = 1;
		gbc_jcbEstudiante.gridy = 3;
		add(jcbEstudiante, gbc_jcbEstudiante);

		JLabel lblNewLabel_3 = new JLabel("Materia");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 4;
		add(jcbMateria, gbc_jcbMateria);

		JLabel lblNewLabel_4 = new JLabel("Valoracion");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfVal = new JTextField();
		GridBagConstraints gbc_jtfVal1 = new GridBagConstraints();
		gbc_jtfVal1.insets = new Insets(0, 0, 5, 0);
		gbc_jtfVal1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfVal1.gridx = 1;
		gbc_jtfVal1.gridy = 5;
		add(jtfVal, gbc_jtfVal1);
		jtfVal.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);

		llenarJcbs();

		btnCargarPrimerRegistro = new JButton("<<");
		btnCargarPrimerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimerRegistro();
			}
		});
		panel.add(btnCargarPrimerRegistro);

		btnCargarAnteriorRegistro = new JButton("<");
		btnCargarAnteriorRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnteriorRegistro();
			}
		});
		panel.add(btnCargarAnteriorRegistro);

		btnCargarSiguienteRegistro = new JButton(">");
		btnCargarSiguienteRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguienteRegistro();
			}
		});
		panel.add(btnCargarSiguienteRegistro);

		btnCargarUltimoRegistro = new JButton(">>");
		btnCargarUltimoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimoRegistro();
			}
		});
		panel.add(btnCargarUltimoRegistro);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfId.setText("0");
				jtfVal.setText("");
			}
		});
		panel.add(btnNuevo);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				cargarAnteriorRegistro();
			}
		});
		panel.add(btnEliminar);

		btnNewButton = new JButton("Refresh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescar();
			}
		});
		panel.add(btnNewButton);

		cargarPrimerRegistro();
	}

	private void guardar() {
		ValoracionMateria val = new ValoracionMateria();
		val.setId(Integer.parseInt(this.jtfId.getText()));
		val.setIdProfesor((Profesor) this.jcbProfesor.getSelectedItem());
		val.setIdEstudiante((Estudiante) this.jcbEstudiante.getSelectedItem());
		val.setIdMateria((Materia) this.jcbMateria.getSelectedItem());
		val.setValoracion(Float.parseFloat(this.jtfVal.getText()));
		ControladorValoracionMateria.guardar(val);

	}

	private void delete() {
		ValoracionMateria val = new ValoracionMateria();
		val.setId(Integer.parseInt(this.jtfId.getText()));
		controllers.ControladorValoracionMateria.delete(val);
	}

	private void cargarSiguienteRegistro() {
		ValoracionMateria val = new ValoracionMateria();
		val.setId(Integer.parseInt(this.jtfId.getText()));
		mostrarRegistro(ControladorValoracionMateria.cargarSiguienteRegistro(val));

	}

	private void cargarAnteriorRegistro() {
		ValoracionMateria val = new ValoracionMateria();
		val.setId(Integer.parseInt(this.jtfId.getText()));
		mostrarRegistro(ControladorValoracionMateria.cargarAnteriorRegistro(val));
	}

	private void cargarUltimoRegistro() {
		mostrarRegistro(ControladorValoracionMateria.cargarUltimoRegistro());

	}

	private void cargarPrimerRegistro() {
		mostrarRegistro(ControladorValoracionMateria.cargarPrimerRegistro());

	}

	private void mostrarRegistro(ValoracionMateria val) {
		this.jtfId.setText(Integer.toString(val.getId()));
		this.jcbProfesor.setSelectedItem(val.getIdProfesor());
		this.jcbEstudiante.setSelectedItem(val.getIdEstudiante());
		this.jcbMateria.setSelectedItem(val.getIdMateria());
		this.jtfVal.setText(Float.toString(val.getValoracion()));

		try {
			botones();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean haySiguienteRegistro() {
		if (Integer.parseInt(this.jtfId.getText()) < controllers.ControladorValoracionMateria.getMaxID()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean hayAnteriorRegistro() {
		if (Integer.parseInt(this.jtfId.getText()) > controllers.ControladorValoracionMateria.getFirstID()) {
			return true;
		} else {
			return false;
		}
	}

	public void botones() throws NumberFormatException, SQLException {
		if (!hayAnteriorRegistro()) {
			this.btnCargarAnteriorRegistro.setEnabled(false);
			this.btnCargarPrimerRegistro.setEnabled(false);
		} else {
			this.btnCargarAnteriorRegistro.setEnabled(true);
			this.btnCargarPrimerRegistro.setEnabled(true);
		}
		if (!haySiguienteRegistro()) {
			this.btnCargarSiguienteRegistro.setEnabled(false);
			this.btnCargarUltimoRegistro.setEnabled(false);
		} else {
			this.btnCargarSiguienteRegistro.setEnabled(true);
			this.btnCargarUltimoRegistro.setEnabled(true);
		}
	}

	private void llenarJcbMateria() {
		List<Materia> lc = ControladorMateria.findAll();
		for (Materia materia : lc) {
			jcbMateria.addItem(materia);
		}
	}

	private void llenarJcbEstudiante() {
		List<Estudiante> lc = ControladorEstudiante.findAll();
		for (Estudiante estudiante : lc) {
			jcbEstudiante.addItem(estudiante);
		}
	}

	private void llenarJcbProfesor() {
		List<Profesor> lc = ControladorProfesor.findAll();
		for (Profesor profesor : lc) {
			jcbProfesor.addItem(profesor);
		}
	}

	private void llenarJcbs() {
		llenarJcbEstudiante();
		llenarJcbMateria();
		llenarJcbProfesor();
	}

	private void refrescar() {
		try {
			jcbEstudiante.removeAllItems();
		} catch (Exception e) {
		
		}
		try {
			jcbMateria.removeAllItems();
		} catch (Exception e) {

		}
		try {
			jcbProfesor.removeAllItems();
		} catch (Exception e) {
			llenarJcbs();
		}

	}

}
