package views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;

import controllers.ControladorCurso;
import controllers.ControladorMateria;
import models.Curso;
import models.Materia;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class VentanaGestionMateria extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfAcro;
	private JButton btnCargarPrimerRegistro;
	private JButton btnCargarAnteriorRegistro;
	private JButton btnCargarSiguienteRegistro;
	private JButton btnCargarUltimoRegistro;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JComboBox<Curso> jcb;
	private JButton btnNewButton;

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

		jtfId = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(jtfId, gbc_textField);
		jtfId.setColumns(10);
		this.jtfId.setEnabled(false);

		JLabel lblNewLabel_2 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		add(jtfNombre, gbc_textField_1);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Acrónimo");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfAcro = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		add(jtfAcro, gbc_textField_2);
		jtfAcro.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Curso_Id");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jcb = new JComboBox<Curso>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		add(jcb, gbc_comboBox);
		llenarJcb();

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		add(panel, gbc_panel);

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
				jtfNombre.setText("");
				jtfAcro.setText("");

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

		cargarPrimerRegistro();
		panel.add(btnNewButton);

//		cargarPrimerRegistro();

	}

	private void guardar() {
		Materia mat = new Materia();
		mat.setId(Integer.parseInt(this.jtfId.getText()));
		mat.setNombre(this.jtfNombre.getText());
		mat.setAcronimo(this.jtfAcro.getText());
		mat.setCurso((Curso) this.jcb.getSelectedItem());
		ControladorMateria.guardar(mat);

	}

	private void refrescar() {
		try {
			jcb.removeAllItems();
		} catch (Exception e) {
			llenarJcb();
		}

	}

	private void delete() {
		Materia mat = new Materia();
		mat.setId(Integer.parseInt(this.jtfId.getText()));
		controllers.ControladorMateria.delete(mat);
	}

	private void cargarSiguienteRegistro() {
		Materia mat = new Materia();
		mat.setId(Integer.parseInt(this.jtfId.getText()));
		mostrarRegistro(ControladorMateria.cargarSiguienteRegistro(mat));

	}

	private void cargarAnteriorRegistro() {
		Materia mat = new Materia();
		mat.setId(Integer.parseInt(this.jtfId.getText()));
		mostrarRegistro(ControladorMateria.cargarAnteriorRegistro(mat));

	}

	private void cargarUltimoRegistro() {
		mostrarRegistro(ControladorMateria.cargarUltimoRegistro());

	}

	private void cargarPrimerRegistro() {
		mostrarRegistro(ControladorMateria.cargarPrimerRegistro());

	}

	private void mostrarRegistro(Materia mat) {
		this.jtfId.setText(Integer.toString(mat.getId()));
		this.jtfNombre.setText(mat.getNombre());
		this.jtfAcro.setText(mat.getAcronimo());
		this.jcb.setSelectedItem(mat.getCurso());

		try {
			botones();
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void llenarJcb() {
		List<Curso> lc = ControladorCurso.findAll();
		for (Curso curso : lc) {
			jcb.addItem(curso);
		}
	}

	private boolean haySiguienteRegistro() {
		if (Integer.parseInt(this.jtfId.getText()) < controllers.ControladorMateria.getMaxID()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean hayAnteriorRegistro() {
		if (Integer.parseInt(this.jtfId.getText()) > controllers.ControladorMateria.getFirstID()) {
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
	

//  private int index(JComboBox<Curso> jcb, Curso c) {
//  Curso c1 = null;
//  for (int i = 0; i < jcb.getItemCount(); i++) {
//      c1 = jcb.getItemAt(i);
//      if(c1.getId() == c.getId()) 
//          return i;
//  }
//  return 0;
//}

}
