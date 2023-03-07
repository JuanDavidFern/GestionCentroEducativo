package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import models.ValoracionMateria;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextArea;

public class VentagaGestionValoracionMateria extends JPanel {
	private JTextField jtfId;
	private JTextField jtfIdProfesor;
	private JTextField jtfIdEstudiante;
	private JTextField jtfIdMateria;
	private JTextField jtfValoracion;
	private JButton btnCargarPrimerRegistro;
	private JButton btnCargarAnteriorRegistro;
	private JButton btnCargarSiguienteRegistro;
	private JButton btnCargarUltimoRegistro;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public VentagaGestionValoracionMateria() {
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
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(jtfId, gbc_textField);
		jtfId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("IdProfesor");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfIdProfesor = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		add(jtfIdProfesor, gbc_textField_1);
		jtfIdProfesor.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("IdEstudiante");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfIdEstudiante = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		add(jtfIdEstudiante, gbc_textField_2);
		jtfIdEstudiante.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("IdMateria");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfIdMateria = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 4;
		add(jtfIdMateria, gbc_textField_3);
		jtfIdMateria.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Valoracion");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfValoracion = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 5;
		add(jtfValoracion, gbc_textField_4);
		jtfValoracion.setColumns(10);

		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 6;
		add(textArea, gbc_textArea);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);

		btnCargarPrimerRegistro = new JButton("<<");
		btnCargarPrimerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarPrimerRegistro();
				try {
					botones();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnCargarPrimerRegistro);

		btnCargarAnteriorRegistro = new JButton("<");
		btnCargarAnteriorRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarAnteriorRegistro();
				try {
					botones();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnCargarAnteriorRegistro);

		btnCargarSiguienteRegistro = new JButton(">");
		btnCargarSiguienteRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarSiguienteRegistro();
				try {
					botones();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnCargarSiguienteRegistro);

		btnCargarUltimoRegistro = new JButton(">>");
		btnCargarUltimoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarUltimoRegistro();
				try {
					botones();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
				jtfIdProfesor.setText("");
				jtfIdEstudiante.setText("");
				jtfIdMateria.setText("");
				jtfValoracion.setText("");
				textArea.setText("");

			}
		});
		panel.add(btnNuevo);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
				cargarAnteriorRegistro();
				try {
					botones();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnEliminar);

		cargarPrimerRegistro();
		this.textArea.setText(
				"Las Ids disponibles para curso Id son \n" + controllers.ControladorValoracionMateria.cursoSelect());
		try {
			botones();
		} catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void guardar() {
		ValoracionMateria val = new ValoracionMateria();
		val.setId(Integer.parseInt(this.jtfId.getText()));
		val.setIdProfesor(Integer.parseInt(this.jtfIdProfesor.getText()));
		val.setIdEstudiante(Integer.parseInt(this.jtfIdEstudiante.getText()));
		val.setIdMateria(Integer.parseInt(this.jtfIdMateria.getText()));
		val.setValoracion();
		controllers.ControladorValoracionMateria.guardar(val);
		this.textArea.setText(val.getText());

	}

	private void delete() {
		ValoracionMateria val = new ValoracionMateria();
		val.setId(Integer.parseInt(this.jtfId.getText()));
		controllers.ControladorValoracionMateria.delete(val);
	}

	private void cargarSiguienteRegistro() {
		ValoracionMateria val = new ValoracionMateria();
		val.setId(Integer.parseInt(this.jtfId.getText()));
		ValoracionMateria val2 = new controllers.ControladorValoracionMateria().cargarSiguienteRegistro(val);
		if (val2 != null) {
			this.jtfId.setText("" + (val2.getId()));
			this.jtfIdProfesor.setText("" +val2.getIdProfesor());
			this.jtfIdEstudiante.setText("" +val2.getIdEstudiante());
			this.jtfIdMateria.setText("" + (val2.getIdMateria()));

		}

	}

	private void cargarAnteriorRegistro() {
		ValoracionMateria val = new ValoracionMateria();
		val.setId(Integer.parseInt(this.jtfId.getText()));
		ValoracionMateria val2 = new controllers.ControladorValoracionMateria().cargarAnteriorRegistro(val);
		if (val2 != null) {
			this.jtfId.setText("" + val2.getId());
			this.jtfIdProfesor.setText("" + val2.getIdProfesor());
			this.jtfIdEstudiante.setText("" + val2.getIdEstudiante());
			this.jtfIdMateria.setText("" + val2.getIdMateria());
			this.jtfValoracion.setText("" + val2.getValoracion());

		}

	}

	private void cargarUltimoRegistro() {
		ValoracionMateria val = new controllers.ControladorValoracionMateria().cargarUltimoRegistro();
		if (val != null) {
			this.jtfId.setText(Integer.toString(val.getId()));
			this.jtfIdEstudiante.setText("" + val.getIdEstudiante());
			this.jtfIdMateria.setText("" + val.getIdMateria());
			this.jtfIdProfesor.setText("" + val.getIdProfesor());
			this.jtfValoracion.setText("" + val.getValoracion());

		}

	}

	private void cargarPrimerRegistro() {
		ValoracionMateria val = new controllers.ControladorValoracionMateria().cargarPrimerRegistro();
		if (val != null) {
			this.jtfId.setText(Integer.toString(val.getId()));
			this.jtfIdEstudiante.setText("" + val.getIdEstudiante());
			this.jtfIdMateria.setText("" + val.getIdMateria());
			this.jtfIdProfesor.setText("" + val.getIdProfesor());
			this.jtfValoracion.setText("" + val.getValoracion());

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

}
