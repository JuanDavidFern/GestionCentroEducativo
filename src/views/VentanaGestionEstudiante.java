package views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.ControladorEstudiante;
import models.Estudiante;
import models.Estudiante;

public class VentanaGestionEstudiante extends JPanel {

	private JTextField jtfid;
	private JTextField jtfnombre;
	private JTextField jtfape1;
	private JTextField jtfape2;
	private JTextField jtfdni;
	private JTextField jtfdirec;
	private JTextField jtfemail;
	private JTextField jtftelef;
	private JButton btnCargarPrimerRegistro;
	private JButton btnCargarAnteriorRegistro;
	private JButton btnCargarSiguienteRegistro;
	private JButton btnCargarUltimoRegistro;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JButton btnGuardar;

	/**
	 * Create the panel.
	 */
	public VentanaGestionEstudiante() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_8 = new JLabel("Gestion de Estudiantes");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 50));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.gridwidth = 2;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel = new JLabel("Id");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfid = new JTextField();
		GridBagConstraints gbc_jtfid = new GridBagConstraints();
		gbc_jtfid.weightx = 1.0;
		gbc_jtfid.insets = new Insets(0, 0, 5, 0);
		gbc_jtfid.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfid.gridx = 1;
		gbc_jtfid.gridy = 1;
		add(jtfid, gbc_jtfid);
		jtfid.setColumns(10);
		this.jtfid.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfnombre = new JTextField();
		GridBagConstraints gbc_jtfnombre = new GridBagConstraints();
		gbc_jtfnombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfnombre.weightx = 1.0;
		gbc_jtfnombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfnombre.gridx = 1;
		gbc_jtfnombre.gridy = 2;
		add(jtfnombre, gbc_jtfnombre);
		jtfnombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido1");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfape1 = new JTextField();
		GridBagConstraints gbc_jtfape1 = new GridBagConstraints();
		gbc_jtfape1.insets = new Insets(0, 0, 5, 0);
		gbc_jtfape1.weightx = 1.0;
		gbc_jtfape1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfape1.gridx = 1;
		gbc_jtfape1.gridy = 3;
		add(jtfape1, gbc_jtfape1);
		jtfape1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido2");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfape2 = new JTextField();
		GridBagConstraints gbc_jtfape2 = new GridBagConstraints();
		gbc_jtfape2.insets = new Insets(0, 0, 5, 0);
		gbc_jtfape2.weightx = 1.0;
		gbc_jtfape2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfape2.gridx = 1;
		gbc_jtfape2.gridy = 4;
		add(jtfape2, gbc_jtfape2);
		jtfape2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DNI");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfdni = new JTextField();
		GridBagConstraints gbc_jtfdni = new GridBagConstraints();
		gbc_jtfdni.insets = new Insets(0, 0, 5, 0);
		gbc_jtfdni.weightx = 1.0;
		gbc_jtfdni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfdni.gridx = 1;
		gbc_jtfdni.gridy = 5;
		add(jtfdni, gbc_jtfdni);
		jtfdni.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfdirec = new JTextField();
		GridBagConstraints gbc_jtfdirec = new GridBagConstraints();
		gbc_jtfdirec.insets = new Insets(0, 0, 5, 0);
		gbc_jtfdirec.weightx = 1.0;
		gbc_jtfdirec.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfdirec.gridx = 1;
		gbc_jtfdirec.gridy = 6;
		add(jtfdirec, gbc_jtfdirec);
		jtfdirec.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfemail = new JTextField();
		GridBagConstraints gbc_jtfemail = new GridBagConstraints();
		gbc_jtfemail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfemail.weightx = 1.0;
		gbc_jtfemail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfemail.gridx = 1;
		gbc_jtfemail.gridy = 7;
		add(jtfemail, gbc_jtfemail);
		jtfemail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Telefono");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_7.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 8;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtftelef = new JTextField();
		GridBagConstraints gbc_jtftelef = new GridBagConstraints();
		gbc_jtftelef.insets = new Insets(0, 0, 5, 0);
		gbc_jtftelef.weightx = 1.0;
		gbc_jtftelef.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtftelef.gridx = 1;
		gbc_jtftelef.gridy = 8;
		add(jtftelef, gbc_jtftelef);
		jtftelef.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 9;
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
				jtfape1.setText("");
				jtfape2.setText("");
				jtfdni.setText("");
				jtfdirec.setText("");
				jtfemail.setText("");
				jtftelef.setText("");
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
		try {
			botones();
		} catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void guardar() {
		Estudiante estu = new Estudiante();
		estu.setId(Integer.parseInt(this.jtfid.getText()));
		estu.setNombre(this.jtfnombre.getText());
		estu.setApellido1(this.jtfape1.getText());
		estu.setApellido2(this.jtfape2.getText());
		estu.setDni(this.jtfdni.getText());
		estu.setDireccion(this.jtfdirec.getText());
		estu.setEmail(this.jtfemail.getText());
		estu.setTelefono(this.jtftelef.getText());
		ControladorEstudiante.guardar(estu);
		

	}
	
	private void cargarAnteriorRegistro() {
		Estudiante estu = new Estudiante();
		estu.setId(Integer.parseInt(this.jtfid.getText()));
		Estudiante estu2 = new controllers.ControladorEstudiante().cargarAnteriorRegistro(estu);
		if (estu2 != null) {
			this.jtfid.setText(Integer.toString(estu2.getId()));
			this.jtfnombre.setText(estu2.getNombre());
			this.jtfape1.setText(estu2.getApellido1());
			this.jtfape2.setText(estu2.getApellido2());
			this.jtfdni.setText(estu2.getDni());
			this.jtfdirec.setText(estu2.getDireccion());
			this.jtfemail.setText(estu2.getEmail());
			this.jtftelef.setText(estu2.getTelefono());
		}

	}
	
	private void cargarSiguienteRegistro() {
		Estudiante estu = new Estudiante();
		estu.setId(Integer.parseInt(this.jtfid.getText()));
		Estudiante estu2 = new controllers.ControladorEstudiante().cargarSiguienteRegistro(estu);
		if (estu2 != null) {
			this.jtfid.setText(Integer.toString(estu2.getId()));
			this.jtfnombre.setText(estu2.getNombre());
			this.jtfape1.setText(estu2.getApellido1());
			this.jtfape2.setText(estu2.getApellido2());
			this.jtfdni.setText(estu2.getDni());
			this.jtfdirec.setText(estu2.getDireccion());
			this.jtfemail.setText(estu2.getEmail());
			this.jtftelef.setText(estu2.getTelefono());
		}

	}

	
	private void cargarUltimoRegistro() {
		Estudiante estu = new controllers.ControladorEstudiante().cargarUltimoRegistro();
		if (estu != null) {
			this.jtfid.setText(Integer.toString(estu.getId()));
			this.jtfnombre.setText(estu.getNombre());
			this.jtfape1.setText(estu.getApellido1());
			this.jtfape2.setText(estu.getApellido2());
			this.jtfdni.setText(estu.getDni());
			this.jtfdirec.setText(estu.getDireccion());
			this.jtfemail.setText(estu.getEmail());
			this.jtftelef.setText(estu.getTelefono());
			
		}
	}
	
	private void cargarPrimerRegistro() {
		Estudiante estu = new controllers.ControladorEstudiante().cargarPrimerRegistro();
		if (estu != null) {
			this.jtfid.setText(Integer.toString(estu.getId()));
			this.jtfnombre.setText(estu.getNombre());
			this.jtfape1.setText(estu.getApellido1());
			this.jtfape2.setText(estu.getApellido2());
			this.jtfdni.setText(estu.getDni());
			this.jtfdirec.setText(estu.getDireccion());
			this.jtfemail.setText(estu.getEmail());
			this.jtftelef.setText(estu.getTelefono());
			
		}
		
	}
	
	private void delete() {
		Estudiante estu = new Estudiante();
		estu.setId(Integer.parseInt(this.jtfid.getText()));
		controllers.ControladorEstudiante.delete(estu);
	}

	private boolean haySiguienteRegistro() {
		if (Integer.parseInt(this.jtfid.getText()) < controllers.ControladorEstudiante.getMaxID()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean hayAnteriorRegistro() {
		if (Integer.parseInt(this.jtfid.getText()) > controllers.ControladorEstudiante.getFirstID()) {
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
