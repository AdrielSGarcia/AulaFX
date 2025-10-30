package dao;

import model.Venda;
import model.Cliente;
import model.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public void create(Venda venda) throws SQLException {
        String sql = "INSERT INTO vendas (cliente_id, data_venda, valor_total) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, venda.getCliente().getId());
            // Converte LocalDate para java.sql.Date
            stmt.setDate(2, Date.valueOf(venda.getDataVenda())); 
            stmt.setDouble(3, venda.getValorTotal());
            stmt.executeUpdate();
        }
    }

    public List<Venda> read() throws SQLException {
        List<Venda> vendas = new ArrayList<>();
        // JOIN para buscar os dados do cliente
        String sql = "SELECT v.*, c.nome as cliente_nome, c.email, c.telefone, c.endereco " +
                     "FROM vendas v " +
                     "JOIN clientes c ON v.cliente_id = c.id";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                // 1. Criar o Cliente (pode ser completo ou parcial)
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("cliente_id"));
                cliente.setNome(rs.getString("cliente_nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));

                // 2. Criar a Venda
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                // Converte java.sql.Date para LocalDate
                venda.setDataVenda(rs.getDate("data_venda").toLocalDate()); 
                venda.setValorTotal(rs.getDouble("valor_total"));
                venda.setCliente(cliente);
                
                vendas.add(venda);
            }
        }
        return vendas;
    }

    public void update(Venda venda) throws SQLException {
        String sql = "UPDATE vendas SET cliente_id = ?, data_venda = ?, valor_total = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, venda.getCliente().getId());
            stmt.setDate(2, Date.valueOf(venda.getDataVenda()));
            stmt.setDouble(3, venda.getValorTotal());
            stmt.setInt(4, venda.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM vendas WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}