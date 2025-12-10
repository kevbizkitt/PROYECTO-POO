package Modulo5;

import Modulo2.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public int insertar(Empleado e) throws SQLException {
        String sql = "INSERT INTO empleado (nombre, apellido_paterno, apellido_materno, dni, cargo, sueldo, area_responsable) VALUES (?,?,?,?,?,?,?)";
        try (Connection c = DBConexion.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, e.getNombrePersona());
            ps.setString(2, e.getApellidoPaternoPersona());
            ps.setString(3, e.getApellidoMaternoPersona());
            ps.setString(4, e.getDniPersona());
            ps.setString(5, e.getCargoEmpleado());
            ps.setDouble(6, e.getSueldo());
          
            String area = null;
            try {
                area = (String) e.getClass().getMethod("getAreaResponsable").invoke(e);
            } catch (Exception ex) {
            }
            if (area != null) ps.setString(7, area);
            else ps.setNull(7, Types.VARCHAR);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }

    public Empleado buscarPorDni(String dni) throws SQLException {
        String sql = "SELECT nombre, apellido_paterno, apellido_materno, dni, cargo, sueldo, area_responsable FROM empleado WHERE dni = ?";
        try (Connection c = DBConexion.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Empleado e = new Empleado();
                    e.setNombrePersona(rs.getString("nombre"));
                    e.setApellidoPaternoPersona(rs.getString("apellido_paterno"));
                    e.setApellidoMaternoPersona(rs.getString("apellido_materno"));
                    e.setDniPersona(rs.getString("dni"));
                    e.setCargoEmpleado(rs.getString("cargo"));
                    e.setSueldo(rs.getDouble("sueldo"));
                    return e;
                }
            }
        }
        return null;
    }

    public List<Empleado> listarTodos() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT nombre, apellido_paterno, apellido_materno, dni, cargo, sueldo FROM empleado";
        try (Connection c = DBConexion.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setNombrePersona(rs.getString("nombre"));
                e.setApellidoPaternoPersona(rs.getString("apellido_paterno"));
                e.setApellidoMaternoPersona(rs.getString("apellido_materno"));
                e.setDniPersona(rs.getString("dni"));
                e.setCargoEmpleado(rs.getString("cargo"));
                e.setSueldo(rs.getDouble("sueldo"));
                lista.add(e);
            }
        }
        return lista;
    }

    public boolean eliminarPorDni(String dni) throws SQLException {
        String sql = "DELETE FROM empleado WHERE dni = ?";
        try (Connection c = DBConexion.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, dni);
            return ps.executeUpdate() > 0;
        }
    }
}
