package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controllers.ControladorCurso;
import models.Curso;

public class VentanaGestionCurso extends JPanel {

	private JTextField jtfId;
	private JLabel lblNewLabel_1;
	private JTextField jtfDesc;
	private JLabel lblNewLabel_2;
	private JPanel panel;
	private JButton btnCargarPrimerRegistro;
	private JButton btnCargarAnteriorRegistro;
	private JButton btnCargarSiguienteRegistro;
	private JButton btnCargarUltimoRegistro;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnEliminar;

	/**
	 * Create the frame.
	 */
	public VentanaGestionCurso() {

		GridBagLayout gridBagLayout = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		lblNewLabel_2 = new JLabel("Gestión de Cursos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 50));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 20, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.weightx = 1.0;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		// Desabilitar boton
		this.jtfId.setEnabled(false);

		lblNewLabel_1 = new JLabel("Descripción");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfDesc = new JTextField();
		GridBagConstraints gbc_jtfDesc = new GridBagConstraints();
		gbc_jtfDesc.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDesc.gridx = 1;
		gbc_jtfDesc.gridy = 2;
		add(jtfDesc, gbc_jtfDesc);
		jtfDesc.setColumns(10);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
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
				jtfDesc.setText("");
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

	private void delete() {
		Curso curs = new Curso();
		curs.setId(Integer.parseInt(this.jtfId.getText()));
		controllers.ControladorCurso.delete(curs);

	}

	private void guardar() {
		Curso curs = new Curso();
		curs.setId(Integer.parseInt(this.jtfId.getText()));
		curs.setDescri(this.jtfDesc.getText());
		ControladorCurso.guardar(curs);

	}

	private void cargarAnteriorRegistro() {
		Curso curs = new Curso();
		curs.setId(Integer.parseInt(this.jtfId.getText()));
		Curso curs2 = new controllers.ControladorCurso().cargarAnteriorRegistro(curs);
		if (curs2 != null) {
			this.jtfId.setText(Integer.toString(curs2.getId()));

			this.jtfDesc.setText(curs2.getDescri());
		}

	}

	private void cargarSiguienteRegistro() {
		Curso curs = new Curso();
		curs.setId(Integer.parseInt(this.jtfId.getText()));
		Curso curs2 = new controllers.ControladorCurso().cargarSiguienteRegistro(curs);
		if (curs2 != null) {
			this.jtfId.setText(Integer.toString(curs2.getId()));

			this.jtfDesc.setText(curs2.getDescri());
		}

	}

	private void cargarPrimerRegistro() {
		Curso curs = new controllers.ControladorCurso().cargarPrimerRegistro();
		if (curs != null) {
			this.jtfId.setText(Integer.toString(curs.getId()));

			this.jtfDesc.setText(curs.getDescri());
		}
	}

	private void cargarUltimoRegistro() {
		Curso curs = new controllers.ControladorCurso().cargarUltimoRegistro();

		if (curs != null) {
			this.jtfId.setText(Integer.toString(curs.getId()));

			this.jtfDesc.setText(curs.getDescri());
		}

	}

	private boolean haySiguienteRegistro() {
		if (Integer.parseInt(this.jtfId.getText()) < controllers.ControladorCurso.getMaxID()) {
			return true;
		} else {
			return false;
		}
	}

	private boolean hayAnteriorRegistro() {
		if (Integer.parseInt(this.jtfId.getText()) > controllers.ControladorCurso.getFirstID()) {
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
