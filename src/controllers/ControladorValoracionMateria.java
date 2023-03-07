package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.ValoracionMateria;


public class ControladorValoracionMateria {
	
private static Connection conn = null;
	
	public static String materiaSelect() {
		String str = "";
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps;
			ps = conn.prepareStatement("select id from centroeducativo.materia");
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
	

	
	
	public static boolean materiaExits(int id) throws SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement("select id from centroeducativo.materia where id = " + id);
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

	public static void guardar(ValoracionMateria val) {
		try {

			if (!exits(val.getCurso_id())) {
				val.setText("La id curso no existe usa una de las siguientes \n" + cursoSelect());

			} else {

				if (val.getId() != 0) {
					update(val);
				} else {
					guardarNuevo(val);
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
	private static void guardarNuevo(ValoracionMateria val) {
		try {

			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps2 = conn.prepareStatement(
					"insert into centroeducativo.valoracionmateria set id = ?, nombre = ?, acronimo = ?, curso_id = ?");

			ps2.setInt(1, nextId());

			ps2.setString(2, val.getNombre());
			ps2.setString(3, val.getAcronimo());
			ps2.setInt(4, val.getCurso_id());

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
	public static void update(ValoracionMateria val) throws NumberFormatException, SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update centroeducativo.valoracionmateria set nombre = ?, acronimo = ?, curso_id = ? where id =" + val.getId());

		ps.setString(1, val.getNombre());
		ps.setString(2, val.getAcronimo());
		ps.setInt(3, val.getCurso_id());

		ps.executeUpdate();

		ps.close();

	}

	public static void delete(ValoracionMateria val) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("delete from centroeducativo.valoracionmateria where id = " + val.getId());
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

	public ValoracionMateria cargarAnteriorRegistro(ValoracionMateria val) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.valoracionmateria where id < " + val.getId() + " order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				val.setId(rs.getInt(1));

				val.setIdProfesor(rs.getInt(2));
				val.setIdEstudiante(rs.getInt(3));
				val.setIdMateria(rs.getInt(4));
				val.setValoracion(rs.getFloat(5));

			}

			rs.close();
			ps.close();
			conn.close();
			return val;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ValoracionMateria cargarSiguienteRegistro(ValoracionMateria val) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.valoracionmateria where id > " + val.getId() + " order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				val.setId(rs.getInt(1));

				val.setIdProfesor(rs.getInt(2));
				val.setIdEstudiante(rs.getInt(3));
				val.setIdMateria(rs.getInt(4));
				val.setValoracion(rs.getFloat(5));

			}

			rs.close();
			ps.close();
			conn.close();
			return val;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ValoracionMateria cargarUltimoRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			ValoracionMateria val = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.valoracionmateria order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				val = new ValoracionMateria();
				val.setId(rs.getInt(1));
				val.setIdProfesor(rs.getInt(2));
				val.setIdEstudiante(rs.getInt(3));
				val.setIdMateria(rs.getInt(4));
				val.setValoracion(rs.getFloat(5));
				
				
				rs.close();
				ps.close();
				conn.close();
				return val;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ValoracionMateria cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			ValoracionMateria val = null;
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.valoracionmateria order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				val = new ValoracionMateria();
				val.setId(rs.getInt(1));
				val.setIdProfesor(rs.getInt(2));
				val.setIdEstudiante(rs.getInt(3));
				val.setIdMateria(rs.getInt(4));
				val.setValoracion(rs.getFloat(5));
				

				rs.close();
				ps.close();
				conn.close();
				return val;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static int nextId() throws SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.valoracionmateria");
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
			PreparedStatement ps = conn.prepareStatement("select max(ID) FROM centroeducativo.valoracionmateria;");

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
			PreparedStatement ps = conn.prepareStatement("select min(id) FROM centroeducativo.valoracionmateria;");

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
