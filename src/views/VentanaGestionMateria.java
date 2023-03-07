package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;

import controllers.ControladorMateria;
import models.Materia;
import javax.swing.JTextArea;

public class VentanaGestionMateria extends JPanel {
	private JTextField jtfid;
	private JTextField jtfnombre;
	private JTextField jtfacro;
	private JTextField jtfcursoid;
	private JButton btnCargarPrimerRegistro;
	private JButton btnCargarAnteriorRegistro;
	private JButton btnCargarSiguienteRegistro;
	private JButton btnCargarUltimoRegistro;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JTextArea textArea;
	private JLabel lblNewLabel_5;

	/**
	 * Create the panel.
	 */
	public VentanaGestionMateria() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Gestion Materias");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfid = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(jtfid, gbc_textField);
		jtfid.setColumns(10);
		this.jtfid.setEnabled(false);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfnombre = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		add(jtfnombre, gbc_textField_1);
		jtfnombre.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Acrónimo");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfacro = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		add(jtfacro, gbc_textField_2);
		jtfacro.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Curso_Id");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfcursoid = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 4;
		add(jtfcursoid, gbc_textField_3);
		jtfcursoid.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Aiuda");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 5;
		add(textArea, gbc_textArea);
		textArea.setEnabled(false);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
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
				jtfid.setText("0");
				jtfnombre.setText("");
				jtfacro.setText("");
				jtfcursoid.setText("");
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
		this.textArea
				.setText("Las Ids disponibles para curso Id son \n" + controllers.ControladorMateria.cursoSelect());
		try {
			botones();
		} catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void guardar() {
		Materia mat = new Materia();
		mat.setId(Integer.parseInt(this.jtfid.getText()));
		mat.setNombre(this.jtfnombre.getText());
		mat.setAcronimo(this.jtfacro.getText());
		mat.setCurso_id(Integer.parseInt(this.jtfcursoid.getText()));
		ControladorMateria.guardar(mat);
		this.textArea.setText(mat.getText());

	}

	private void delete() {
		Materia mat = new Materia();
		mat.setId(Integer.parseInt(this.jtfid.getText()));
		controllers.ControladorMateria.delete(mat);
	}

	private void cargarSiguienteRegistro() {
		Materia mat = new Materia();
		mat.setId(Integer.parseInt(this.jtfid.getText()));
		Materia mat2 = new controllers.ControladorMateria().cargarSiguienteRegistro(mat);
		if (mat2 != null) {
			this.jtfid.setText("" + (mat2.getId()));
			this.jtfnombre.setText(mat2.getNombre());
			this.jtfacro.setText(mat2.getAcronimo());
			this.jtfcursoid.setText("" + (mat2.getCurso_id()));

		}

	}

	private void cargarAnteriorRegistro() {
		Materia mat = new Materia();
		mat.setId(Integer.parseInt(this.jtfid.getText()));
		Materia mat2 = new controllers.ControladorMateria().cargarAnteriorRegistro(mat);
		if (mat2 != null) {
			this.jtfid.setText("" + (mat2.getId()));
			this.jtfnombre.setText(mat2.getNombre());
			this.jtfacro.setText(mat2.getAcronimo());
			this.jtfcursoid.setText("" + (mat2.getCurso_id()));

		}

	}

	private void cargarUltimoRegistro() {
		Materia mat = new controllers.ControladorMateria().cargarUltimoRegistro();
		if (mat != null) {
			this.jtfid.setText(Integer.toString(mat.getId()));
			this.jtfnombre.setText(mat.getNombre());
			this.jtfacro.setText(mat.getAcronimo());
			this.jtfcursoid.setText(Integer.toString(mat.getCurso_id()));

		}

	}

	private void cargarPrimerRegistro() {
		Materia mat = new controllers.ControladorMateria().cargarPrimerRegistro();
		if (mat != null) {
			this.jtfid.setText(Integer.toString(mat.getId()));
			this.jtfnombre.setText(mat.getNombre());
			this.jtfacro.setText(mat.getAcronimo());
			this.jtfcursoid.setText(Integer.toString(mat.getCurso_id()));

		}

	}

	private boolean haySiguienteRegistro() {
		if (Integer.parseInt(this.jtfid.getText()) < controllers.ControladorMateria.getMaxID()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean hayAnteriorRegistro() {
		if (Integer.parseInt(this.jtfid.getText()) > controllers.ControladorMateria.getFirstID()) {
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
