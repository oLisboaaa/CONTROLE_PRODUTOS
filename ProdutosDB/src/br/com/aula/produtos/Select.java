package br.com.aula.produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    public static void main(String[] args) {

        try (Connection conexao = ConexaoDB.conectar()) {
            if (conexao != null) {
                String sql = "SELECT id, nome, isAlimento, dataValidade, infoNutricionais, tamanho, cor, material FROM produtos_tb";

                try (PreparedStatement stmt = conexao.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery()) {

                    System.out.println("Lista de produtos:");

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        boolean isAlimento = rs.getBoolean("isAlimento");
                        String dataValidade = rs.getString("dataValidade");
                        String infoNutricionais = rs.getString("infoNutricionais");
                        String tamanho = rs.getString("tamanho");
                        String cor = rs.getString("cor");
                        String material = rs.getString("material");

                        System.out.println("ID: " + id);
                        System.out.println("Nome: " + nome);
                        System.out.println("É alimento: " + (isAlimento ? "Sim" : "Não"));
                        if (isAlimento) {
                            System.out.println("Data de Validade: " + dataValidade);
                            System.out.println("Informações Nutricionais: " + infoNutricionais);
                        } else {
                            System.out.println("Tamanho: " + tamanho);
                            System.out.println("Cor: " + cor);
                            System.out.println("Material: " + material);
                        }
                        System.out.println("------------");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ler dados: " + e.getMessage());
        }
    }
}
