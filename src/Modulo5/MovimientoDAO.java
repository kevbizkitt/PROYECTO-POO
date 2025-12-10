package Modulo5;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovimientoDAO {

    public int registrarMovimiento(java.util.Date fecha, int ropaId, int cantidad, Integer empleadoId, String tipo, String descripcion) throws SQLException {
        String insertSql = "INSERT INTO movimiento_inventario (fecha, ropa_id, cantidad, empleado_id, tipo, descripcion) VALUES (?,?,?,?,?,?)";
        String updateSqlEntrada = "UPDATE ropa SET stock = stock + ? WHERE id = ?";
        String updateSqlSalida = "UPDATE ropa SET stock = stock - ? WHERE id = ? AND stock >= ?";

        Connection c = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        ResultSet rsKeys = null;

        try {
            c = DBConexion.getConnection();
            c.setAutoCommit(false);

            psInsert = c.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            psInsert.setTimestamp(1, new Timestamp(fecha.getTime()));
            psInsert.setInt(2, ropaId);
            psInsert.setInt(3, cantidad);
            if (empleadoId != null) psInsert.setInt(4, empleadoId); else psInsert.setNull(4, Types.INTEGER);
            psInsert.setString(5, tipo);
            psInsert.setString(6, descripcion);
            psInsert.executeUpdate();

            rsKeys = psInsert.getGeneratedKeys();
            int movId = -1;
            if (rsKeys.next()) movId = rsKeys.getInt(1);

            if ("ENTRADA".equalsIgnoreCase(tipo)) {
                psUpdate = c.prepareStatement(updateSqlEntrada);
                psUpdate.setInt(1, cantidad);
                psUpdate.setInt(2, ropaId);
                psUpdate.executeUpdate();
            } else if ("SALIDA".equalsIgnoreCase(tipo)) {
                psUpdate = c.prepareStatement(updateSqlSalida);
                psUpdate.setInt(1, cantidad);
                psUpdate.setInt(2, ropaId);
                psUpdate.setInt(3, cantidad);
                int affected = psUpdate.executeUpdate();
                if (affected == 0) {
                    c.rollback();
                    throw new SQLException("Stock insuficiente para la salida o ropa no encontrada.");
                }
            } else {
                c.rollback();
                throw new SQLException("Tipo de movimiento inválido: " + tipo);
            }

            c.commit();
            return movId;
        } catch (SQLException ex) {
            if (c != null) try { c.rollback(); } catch (SQLException e) {}
            throw ex;
        } finally {
            if (rsKeys != null) try { rsKeys.close(); } catch (SQLException e) {}
            if (psInsert != null) try { psInsert.close(); } catch (SQLException e) {}
            if (psUpdate != null) try { psUpdate.close(); } catch (SQLException e) {}
            if (c != null) try { c.setAutoCommit(true); } catch (SQLException e) {}
        }
    }

    public List<HashMap<String,Object>> listarMovimientos() throws SQLException {
        List<HashMap<String,Object>> lista = new ArrayList<>();
        String sql = "SELECT m.id, m.fecha, m.ropa_id, r.nombre as ropa_nombre, m.cantidad, m.empleado_id, e.dni as empleado_dni, m.tipo, m.descripcion " +
                     "FROM movimiento_inventario m " +
                     "LEFT JOIN ropa r ON m.ropa_id = r.id " +
                     "LEFT JOIN empleado e ON m.empleado_id = e.id " +
                     "ORDER BY m.fecha DESC";
        try (Connection c = DBConexion.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                HashMap<String,Object> map = new HashMap<>();
                map.put("id", rs.getInt("id"));
                map.put("fecha", rs.getTimestamp("fecha"));
                map.put("ropa_id", rs.getInt("ropa_id"));
                map.put("ropa_nombre", rs.getString("ropa_nombre"));
                map.put("cantidad", rs.getInt("cantidad"));
                map.put("empleado_id", rs.getObject("empleado_id"));
                map.put("empleado_dni", rs.getString("empleado_dni"));
                map.put("tipo", rs.getString("tipo"));
                map.put("descripcion", rs.getString("descripcion"));
                lista.add(map);
            }
        }
        return lista;
    }
}
