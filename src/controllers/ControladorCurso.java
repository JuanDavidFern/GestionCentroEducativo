package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import models.Curso;

public class ControladorCurso {
	private static Connection conn = null;

	
	public static void guardar(Curso curs) {
		try {

			if (curs.getId() != 0) {
				update(curs);
			} else {
				guardarNuevo(curs);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * 
	 */
	private static void guardarNuevo(Curso curs) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			
				PreparedStatement ps = conn
						.prepareStatement("insert into centroeducativo.curso set id = ?, descripcion = ? ");

				ps.setInt(1, nextId());

				ps.setString(2, curs.getDescri());

				ps.executeUpdate();

				ps.close();
				
				
				
				

			

			
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
	private static void update(Curso curs) throws NumberFormatException, SQLException {
		conn = controllers.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn
				.prepareStatement("update centroeducativo.curso set descripcion = ? where id ="
						+ curs.getId());


		ps.setString(1, curs.getDescri());

		ps.executeUpdate();

		ps.close();
		
	}
	/**
	 * 
	 */
	public static void delete(Curso curs) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"delete from centroeducativo.curso where id = " + curs.getId());
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
	public Curso cargarAnteriorRegistro(Curso curs) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.curso where id < " + curs.getId() + " order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				curs.setId(rs.getInt(1));

				curs.setDescri(rs.getString(2));
			}

			rs.close();
			ps.close();
			conn.close();
			return curs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 */
	public Curso cargarSiguienteRegistro(Curso curs) {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.curso where id > " + curs.getId() + " order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				curs.setId(rs.getInt(1));

				curs.setDescri(rs.getString(2));
			}

			rs.close();
			ps.close();
			conn.close();
			return curs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 */
	public Curso cargarUltimoRegistro() {
		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Curso curs = null;
			PreparedStatement ps = conn
					.prepareStatement("select * from centroeducativo.curso order by id desc limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				curs = new Curso();
				curs.setId(rs.getInt(1));

				curs.setDescri(rs.getString(2));
			}

			rs.close();
			ps.close();
			conn.close();
			return curs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Curso cargarPrimerRegistro() {

		try {
			conn = controllers.ConnectionManagerV1.getConexion();
			Curso curs = null;
			PreparedStatement ps = conn.prepareStatement("select * from centroeducativo.curso order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				curs = new Curso();
				curs.setId(rs.getInt(1));

				curs.setDescri(rs.getString(2));
			}

			rs.close();
			ps.close();
			conn.close();
			return curs;
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
		PreparedStatement ps = conn.prepareStatement("select max(id) from centroeducativo.curso");
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
        	PreparedStatement ps = conn.prepareStatement("select max(ID) FROM centroeducativo.curso;");

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
        	PreparedStatement ps = conn.prepareStatement("select min(id) FROM centroeducativo.curso;");


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
