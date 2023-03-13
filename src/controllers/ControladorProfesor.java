package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Profesor;

public class ControladorProfesor {
	private static Connection conn = null;

	public static Profesor guardar(Profesor prof) {
		try {

			if (prof.getId() != 0) {
				update(prof);
				return null;
			} else {
				return guardarNuevo(prof);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

	/**
	 * 
	 */
	private static Profesor guardarNuevo(Profesor prof) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps2 = conn.prepareStatement(
					"insert into centroeducativo.profesor set id = ?, nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, "
							+ "direccion = ?, email = ?,telefono = ? ");

			ps2.setInt(1, nextId());

			ps2.setString(2, prof.getNombre());
			ps2.setString(3, prof.getApellido1());
			ps2.setString(4, prof.getApellido2());
			ps2.setString(5, prof.getDni());
			ps2.setString(6, prof.getDireccion());
			ps2.setString(7, prof.getEmail());
			ps2.setString(8, prof.getTelefono());

			ps2.executeUpdate();

			ps2.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prof;

	}

	/**
	 * 
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	private static void update(Profesor prof) throws NumberFormatException, SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update centroeducativo.profesor set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?,"
						+ "direccion = ?, email = ?,telefono = ?  where id =" + prof.getId());

		ps.setString(1, prof.getNombre());
		ps.setString(2, prof.getApellido1());
		ps.setString(3, prof.getApellido2());
		ps.setString(4, prof.getDni());
		ps.setString(5, prof.getDireccion());
		ps.setString(6, prof.getEmail());
		ps.setString(7, prof.getTelefono());

		ps.executeUpdate();

		ps.close();
		conn.close();
	}

	/**
	 * 
	 */
	public static void delete(Profesor prof) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("delete from centroeducativo.profesor where id = " + prof.getId());
			int conf = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar el registro?");
			if (conf == JOptionPane.YES_OPTION) {
				ps.executeUpdate();
			}

			ps.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	public static Profesor cargarAnteriorRegistro(Profesor prof) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.profesor where id < " + prof.getId() + " order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			Profesor p = new Profesor();
			if (rs.next()) {

				p.setId(rs.getInt(1));

				p.setNombre(rs.getString(2));
				p.setApellido1(rs.getString(3));
				p.setApellido2(rs.getString(4));
				p.setDni(rs.getString(5));
				p.setDireccion(rs.getString(6));
				p.setEmail(rs.getString(7));
				p.setTelefono(rs.getString(8));

				rs.close();
				ps.close();
				conn.close();
				return p;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 */
	public static Profesor cargarSiguienteRegistro(Profesor prof) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.profesor where id > " + prof.getId() + " order by id limit 1");
			ResultSet rs = ps.executeQuery();
			Profesor p = new Profesor();
			if (rs.next()) {

				p.setId(rs.getInt(1));

				p.setNombre(rs.getString(2));
				p.setApellido1(rs.getString(3));
				p.setApellido2(rs.getString(4));
				p.setDni(rs.getString(5));
				p.setDireccion(rs.getString(6));
				p.setEmail(rs.getString(7));
				p.setTelefono(rs.getString(8));

				rs.close();
				ps.close();
				conn.close();
				return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 */
	public static Profesor cargarUltimoRegistro() {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Profesor prof = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.profesor order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				prof = new Profesor();
				prof.setId(rs.getInt(1));

				prof.setNombre(rs.getString(2));
				prof.setApellido1(rs.getString(3));
				prof.setApellido2(rs.getString(4));
				prof.setDni(rs.getString(5));
				prof.setDireccion(rs.getString(6));
				prof.setEmail(rs.getString(7));
				prof.setTelefono(rs.getString(8));
			}

			rs.close();
			ps.close();
			conn.close();
			return prof;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Profesor cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Profesor prof = null;
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.profesor order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				prof = new Profesor();
				prof.setId(rs.getInt(1));
				prof.setNombre(rs.getString(2));
				prof.setApellido1(rs.getString(3));
				prof.setApellido2(rs.getString(4));
				prof.setDni(rs.getString(5));
				prof.setDireccion(rs.getString(6));
				prof.setEmail(rs.getString(7));
				prof.setTelefono(rs.getString(8));
			}

			rs.close();
			ps.close();
			conn.close();
			return prof;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 */
	public static int nextId() throws SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.profesor");
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return rs.getInt(1) + 1;

		}
		ps.close();
		rs.close();
		conn.close();
		return 1;

	}

	
	public static List<Profesor> findAll() {
		List<Profesor> lc = new ArrayList<Profesor>();
		Profesor p = cargarPrimerRegistro();
		do {
			lc.add(p);
			p = cargarSiguienteRegistro(p);
		} while (p != null);
		return lc;
	}

}
