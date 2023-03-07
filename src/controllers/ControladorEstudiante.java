package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.Estudiante;

public class ControladorEstudiante {
	private static Connection conn = null;

	public static void guardar(Estudiante estu) {
		try {

			if (estu.getId() != 0) {
				update(estu);
			} else {
				guardarNuevo(estu);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 
	 */
	private static void guardarNuevo(Estudiante estu) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into centroeducativo.estudiante set id = ?, nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?, "
							+ "direccion = ?, email = ?,telefono = ? ");

			ps.setInt(1, nextId());

			ps.setString(2, estu.getNombre());
			ps.setString(3, estu.getApellido1());
			ps.setString(4, estu.getApellido2());
			ps.setString(5, estu.getDni());
			ps.setString(6, estu.getDireccion());
			ps.setString(7, estu.getEmail());
			ps.setString(8, estu.getTelefono());

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
	 * @throws NumberFormatException
	 * @throws SQLException
	 */
	public static void update(Estudiante estu) throws NumberFormatException, SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update centroeducativo.estudiante set nombre = ?, apellido1 = ?, apellido2 = ?, dni = ?,"
						+ "direccion = ?, email = ?,telefono = ?  where id =" + estu.getId());

		ps.setString(1, estu.getNombre());
		ps.setString(2, estu.getApellido1());
		ps.setString(3, estu.getApellido2());
		ps.setString(4, estu.getDni());
		ps.setString(5, estu.getDireccion());
		ps.setString(6, estu.getEmail());
		ps.setString(7, estu.getTelefono());

		ps.executeUpdate();

		ps.close();
		conn.close();

	}

	/**
	 * 
	 */
	public static void delete(Estudiante estu) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn
					.prepareStatement("delete from centroeducativo.estudiante where id = " + estu.getId());
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
	public static Estudiante cargarAnteriorRegistro(Estudiante estu) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.estudiante where id < "
					+ estu.getId() + " order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			Estudiante e = new Estudiante();
			if (rs.next()) {

				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido1(rs.getString(3));
				e.setApellido2(rs.getString(4));
				e.setDni(rs.getString(5));
				e.setDireccion(rs.getString(6));
				e.setEmail(rs.getString(7));
				e.setTelefono(rs.getString(8));
				rs.close();
				ps.close();
				conn.close();
				return e;
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
	public static Estudiante cargarSiguienteRegistro(Estudiante estu) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.estudiante where id > " + estu.getId() + " order by id limit 1");
			ResultSet rs = ps.executeQuery();
			Estudiante e = new Estudiante();
			if (rs.next()) {

				e.setId(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setApellido1(rs.getString(3));
				e.setApellido2(rs.getString(4));
				e.setDni(rs.getString(5));
				e.setDireccion(rs.getString(6));
				e.setEmail(rs.getString(7));
				e.setTelefono(rs.getString(8));
				rs.close();
				ps.close();
				conn.close();
				return e;
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
	public static Estudiante cargarUltimoRegistro() {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Estudiante estu = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.estudiante order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				estu = new Estudiante();
				estu.setId(rs.getInt(1));

				estu.setNombre(rs.getString(2));
				estu.setApellido1(rs.getString(3));
				estu.setApellido2(rs.getString(4));
				estu.setDni(rs.getString(5));
				estu.setDireccion(rs.getString(6));
				estu.setEmail(rs.getString(7));
				estu.setTelefono(rs.getString(8));
				rs.close();
				ps.close();
				conn.close();
				return estu;
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Estudiante cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Estudiante estu = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.estudiante order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				estu = new Estudiante();
				estu.setId(rs.getInt(1));

				estu.setNombre(rs.getString(2));
				estu.setApellido1(rs.getString(3));
				estu.setApellido2(rs.getString(4));
				estu.setDni(rs.getString(5));
				estu.setDireccion(rs.getString(6));
				estu.setEmail(rs.getString(7));
				estu.setTelefono(rs.getString(8));
				rs.close();
				ps.close();
				conn.close();
				return estu;
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
	public static int nextId() throws SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.estudiante");
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
        	PreparedStatement ps = conn.prepareStatement("select max(ID) FROM centroeducativo.estudiante;");

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
        	PreparedStatement ps = conn.prepareStatement("select min(id) FROM centroeducativo.estudiante;");


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

}
