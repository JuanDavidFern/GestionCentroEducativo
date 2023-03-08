package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.Estudiante;
import models.Materia;
import models.Profesor;
import models.ValoracionMateria;


public class ControladorValoracionMateria {
	private static Connection conn = null;

	public static void guardar(ValoracionMateria val) {
		try {

			if (val.getId() != 0) {
				update(val);
			} else {
				guardarNuevo(val);
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

			PreparedStatement ps = conn
					.prepareStatement("insert into centroeducativo.valoracionmateria set id = ?, idProfesor = ?, idEstudiante = ?, idMateria = ?, valoracion = ?");

			ps.setInt(1, nextId());
			
			ps.setInt(2, val.getIdProfesor().getId());
			ps.setInt(3, val.getIdEstudiante().getId());
			ps.setInt(4, val.getIdMateria().getId());
			ps.setFloat(5, val.getValoracion());

			ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @throws NumberForvalException
	 * @throws SQLException
	 */
	public static void update(ValoracionMateria val) throws SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update centroeducativo.valoracionmateria set idProfesor = ?, idEstudiante = ?, idMateria = ?, valoracion = ? where id ="
						+ val.getId());

		ps.setInt(1, val.getIdProfesor().getId());
		ps.setInt(2, val.getIdEstudiante().getId());
		ps.setInt(3, val.getIdMateria().getId());
		ps.setFloat(4, val.getValoracion());

		ps.executeUpdate();
		ps.close();
		conn.close();

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

	public static ValoracionMateria cargarAnteriorRegistro(ValoracionMateria val) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.valoracionmateria where id < "
					+ val.getId() + " order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			ValoracionMateria v = new ValoracionMateria();
			if (rs.next()) {

				v.setId(rs.getInt(1));

				v.setIdProfesor(introducirProfesor(rs.getInt(2)));
				v.setIdEstudiante(introducirEstudiante(rs.getInt(3)));
				v.setIdMateria(introducirMateria(rs.getInt(4)));
				v.setValoracion(rs.getFloat(5));

				rs.close();
				ps.close();
				conn.close();
				return v;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ValoracionMateria cargarSiguienteRegistro(ValoracionMateria val) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.valoracionmateria where id > "
					+ val.getId() + " order by id limit 1");
			ResultSet rs = ps.executeQuery();
			ValoracionMateria v = new ValoracionMateria();
			if (rs.next()) {

				v.setId(rs.getInt(1));

				v.setIdProfesor(introducirProfesor(rs.getInt(2)));
				v.setIdEstudiante(introducirEstudiante(rs.getInt(3)));
				v.setIdMateria(introducirMateria(rs.getInt(4)));
				v.setValoracion(rs.getFloat(5));

				rs.close();
				ps.close();
				conn.close();
				return v;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ValoracionMateria cargarUltimoRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			ValoracionMateria v = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.valoracionmateria order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				v = new ValoracionMateria();
				v.setId(rs.getInt(1));

				v.setIdProfesor(introducirProfesor(rs.getInt(2)));
				v.setIdEstudiante(introducirEstudiante(rs.getInt(3)));
				v.setIdMateria(introducirMateria(rs.getInt(4)));
				v.setValoracion(rs.getFloat(5));

				rs.close();
				ps.close();
				conn.close();
				return v;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ValoracionMateria cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			ValoracionMateria v = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.valoracionmateria order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				v = new ValoracionMateria();
				v.setId(rs.getInt(1));
				v.setIdProfesor(introducirProfesor(rs.getInt(2)));
				v.setIdEstudiante(introducirEstudiante(rs.getInt(3)));
				v.setIdMateria(introducirMateria(rs.getInt(4)));
				v.setValoracion(rs.getFloat(5));

				rs.close();
				ps.close();
				conn.close();
				return v;
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
		conn.close();
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
			conn.close();
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
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return firstID;
	}

	public static Profesor introducirProfesor(int i) {
		Profesor p = new Profesor();
		p.setId(i);
		return p;

	}

	public static Estudiante introducirEstudiante(int i) {
		Estudiante e = new Estudiante();
		e.setId(i);
		return e;

	}

	public static Materia introducirMateria(int i) {
		Materia m = new Materia();
		m.setId(i);
		return m;

	}

}
