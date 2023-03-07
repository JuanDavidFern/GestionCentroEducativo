package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.Materia;

public class ControladorMateria {
	private static Connection conn = null;
	
	public static String cursoSelect() {
		String str = "";
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps;
			ps = conn.prepareStatement("select id from centroeducativo.curso");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				str += rs.getString(1) + "\n";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return str;
	}

	public static boolean exits(int id) throws SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement("select id from centroeducativo.curso where id = " + id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			ps.close();
			rs.close();
			return true;
		}
		ps.close();
		rs.close();
		return false;
	}

	public static void guardar(Materia mat) {
		try {

			if (!exits(mat.getCurso_id())) {
				mat.setText("La id curso no existe usa una de las siguientes \n" + cursoSelect());

			} else {

				if (mat.getId() != 0) {
					update(mat);
				} else {
					guardarNuevo(mat);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	private static void guardarNuevo(Materia mat) {
		try {

			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps2 = conn.prepareStatement(
					"insert into centroeducativo.materia set id = ?, nombre = ?, acronimo = ?, curso_id = ?");

			ps2.setInt(1, nextId());

			ps2.setString(2, mat.getNombre());
			ps2.setString(3, mat.getAcronimo());
			ps2.setInt(4, mat.getCurso_id());

			ps2.executeUpdate();

			ps2.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public static void update(Materia mat) throws NumberFormatException, SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update centroeducativo.materia set nombre = ?, acronimo = ?, curso_id = ? where id =" + mat.getId());

		ps.setString(1, mat.getNombre());
		ps.setString(2, mat.getAcronimo());
		ps.setInt(3, mat.getCurso_id());

		ps.executeUpdate();

		ps.close();

	}

	public static void delete(Materia mat) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("delete from centroeducativo.materia where id = " + mat.getId());
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

	public Materia cargarAnteriorRegistro(Materia mat) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.materia where id < " + mat.getId() + " order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				mat.setId(rs.getInt(1));

				mat.setNombre(rs.getString(2));
				mat.setAcronimo(rs.getString(3));
				mat.setCurso_id(rs.getInt(4));

			}

			rs.close();
			ps.close();
			conn.close();
			return mat;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Materia cargarSiguienteRegistro(Materia mat) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.materia where id > " + mat.getId() + " order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				mat.setId(rs.getInt(1));

				mat.setNombre(rs.getString(2));
				mat.setAcronimo(rs.getString(3));
				mat.setCurso_id(rs.getInt(4));

			}

			rs.close();
			ps.close();
			conn.close();
			return mat;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Materia cargarUltimoRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Materia mat = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.materia order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				mat = new Materia();
				mat.setId(rs.getInt(1));
				mat.setNombre(rs.getString(2));
				mat.setAcronimo(rs.getString(3));
				mat.setCurso_id(rs.getInt(4));

				rs.close();
				ps.close();
				conn.close();
				return mat;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Materia cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Materia mat = null;
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.materia order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				mat = new Materia();
				mat.setId(rs.getInt(1));
				mat.setNombre(rs.getString(2));
				mat.setAcronimo(rs.getString(3));
				mat.setCurso_id(rs.getInt(4));

				rs.close();
				ps.close();
				conn.close();
				return mat;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static int nextId() throws SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.materia");
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return rs.getInt(1) + 1;

		}
		ps.close();
		rs.close();
		return 1;

	}

	public static int getMaxID() {
		int maxID = 0;
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement("select max(ID) FROM centroeducativo.materia;");

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				maxID = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxID;
	}

	public static int getFirstID() {
		int firstID = 0;
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement("select min(id) FROM centroeducativo.materia;");

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				firstID = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return firstID;
	}

}
