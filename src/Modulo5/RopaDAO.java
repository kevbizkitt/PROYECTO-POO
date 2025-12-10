package Modulo5;

import Modulo1.Ropa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RopaDAO {

    
    public int insertar(Ropa ropa, Integer proveedorId) throws SQLException {
        String sql = "INSERT INTO ropa (nombre, talla, marca, categoria, stock, precio, proveedor_id) VALUES (?,?,?,?,?,?,?)";
        try (Connection c = DBConexion.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, ropa.getNombreRopa());
            ps.setString(2, ropa.getTallaRopa());
            ps.setString(3, ropa.getMarcaRopa());
            ps.setString(4, ropa.getCategoriaRopa());
            ps.setInt(5, ropa.getStockRopa());
            ps.setDouble(6, ropa.getPrecioRopa());
            if (proveedorId != null) ps.setInt(7, proveedorId); else ps.setNull(7, Types.INTEGER);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    ropa.setId(idGenerado); 
                    return idGenerado;
                }
            }
        }
        return -1;
    }

    public List<Ropa> listarTodas() throws SQLException {
        List<Ropa> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, talla, marca, categoria, stock, precio, proveedor_id FROM ropa";
        try (Connection c = DBConexion.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Ropa r = new Ropa();
                r.setId(rs.getInt("id"));
                r.setNombreRopa(rs.getString("nombre"));
                r.setTallaRopa(rs.getString("talla"));
                r.setMarcaRopa(rs.getString("marca"));
                r.setCategoriaRopa(rs.getString("categoria"));
                r.setStockRopa(rs.getInt("stock"));
                r.setPrecioRopa(rs.getDouble("precio"));
                lista.add(r);
            }
        }
        return lista;
    }
}