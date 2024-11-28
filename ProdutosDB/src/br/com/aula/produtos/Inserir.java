package br.com.aula.produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Inserir {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Connection conexao = ConexaoDB.conectar();

        if (conexao != null) {
            String sql = "INSERT INTO produtos_tb (nome, precoCusto, precoVenda, isAlimento, dataValidade, infoNutricionais, tamanho, cor, material) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement stmt = conexao.prepareStatement(sql);

                System.out.print("Digite o NOME do produto novo: ");
                String nome = scan.nextLine();

                System.out.print("Digite o preço de CUSTO do produto novo: ");
                int precoCusto = scan.nextInt();
                scan.nextLine();

                System.out.print("Digite o preço de VENDA do produto novo: ");
                int precoVenda = scan.nextInt();
                scan.nextLine();

                System.out.println("O produto é um alimento?\nSIM [S]\nNAO [N]");
                String val = scan.nextLine();
                boolean isAlimento = val.equalsIgnoreCase("S");

                String dataValidade = null;
                String infoNutricionais = null;
                String tamanho = null, cor = null, material = null;

                if (isAlimento) {
                    System.out.print("Digite a DATA DE VALIDADE do produto novo (yyyy-MM-dd): ");
                    dataValidade = scan.nextLine();

                    System.out.print("Digite as INFORMAÇÕES NUTRICIONAIS do produto novo: ");
                    infoNutricionais = scan.nextLine();
                } else {
                    System.out.print("Digite o TAMANHO do produto novo (PP - P - M - G - GG): ");
                    tamanho = scan.nextLine();

                    System.out.print("Digite a COR do produto novo: ");
                    cor = scan.nextLine();

                    System.out.print("Digite o MATERIAL do produto novo: ");
                    material = scan.nextLine();
                }

                stmt.setString(1, nome);
                stmt.setInt(2, precoCusto);
                stmt.setInt(3, precoVenda);
                stmt.setBoolean(4, isAlimento);
                stmt.setString(5, dataValidade);
                stmt.setString(6, infoNutricionais);
                stmt.setString(7, tamanho);
                stmt.setString(8, cor);
                stmt.setString(9, material);

                stmt.executeUpdate();
                System.out.println("Dados inseridos com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao inserir dados: " + e.getMessage());
            }
        }
    }
}
