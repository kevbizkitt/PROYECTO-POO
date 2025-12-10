package Modulo5;

import Modulo1.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    public int insertar(Proveedor p) throws SQLException {
        String sql = "INSERT INTO proveedor (nombre, ruc, telefono, direccion) VALUES (?,?,?,?)";
        try (Connection c = DBConexion.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, p.getNombreProveedor());
            ps.setString(2, p.getRucProovedor());
            ps.setString(3, p.getTelefonoProovedor());
            ps.setString(4, p.getDireccionProovedor());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    p.setId(idGenerado);
                    return idGenerado;
                }
            }
        }
        return -1;
    }

    public Proveedor buscarPorRuc(String ruc) throws SQLException {
        String sql = "SELECT nombre, ruc, telefono, direccion FROM proveedor WHERE ruc = ?";
        try (Connection c = DBConexion.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, ruc);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Proveedor p = new Proveedor();
                    p.setNombreProveedor(rs.getString("nombre"));
                    p.setRucProovedor(rs.getString("ruc"));
                    p.setTelefonoProovedor(rs.getString("telefono"));
                    p.setDireccionProovedor(rs.getString("direccion"));
                    return p;
                }
            }
        }
        return null;
    }

    public List<Proveedor> listarTodos() throws SQLException {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT nombre, ruc, telefono, direccion FROM proveedor";
        try (Connection c = DBConexion.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setNombreProveedor(rs.getString("nombre"));
                p.setRucProovedor(rs.getString("ruc"));
                p.setTelefonoProovedor(rs.getString("telefono"));
                p.setDireccionProovedor(rs.getString("direccion"));
                lista.add(p);
            }
        }
        return lista;
    }

    public boolean eliminarPorRuc(String ruc) throws SQLException {
        String sql = "DELETE FROM proveedor WHERE ruc = ?";
        try (Connection c = DBConexion.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, ruc);
            return ps.executeUpdate() > 0;
        }
    }
}
