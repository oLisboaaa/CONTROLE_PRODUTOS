package classes;

// Classe ProdutoAlimenticio derivada de Produto
public class ProdutoAlimenticio extends Produto {
    private String dataValidade;
    private String infoNutricionais;

    public ProdutoAlimenticio(String nome, double precoCusto, double precoVenda, String dataValidade, String infoNutricionais) {
        super(nome, precoCusto, precoVenda);
        this.dataValidade = dataValidade;
        this.infoNutricionais = infoNutricionais;
    }

    // Implementação dos métodos para salvar, deletar e atualizar
    @Override
    public void salvar() {
        System.out.println("INSERT INTO produtos_alimenticios (nome, preco_custo, preco_venda, data_validade, info_nutricionais) " +
                "VALUES ('" + nome + "', " + precoCusto + ", " + precoVenda + ", '" + dataValidade + "', '" + infoNutricionais + "');");
    }

    @Override
    public void deletar() {
        System.out.println("DELETE FROM produtos_alimenticios WHERE nome = '" + nome + "';");
    }

    @Override
    public void atualizar() {
        System.out.println("UPDATE produtos_alimenticios SET preco_venda = " + precoVenda + ", data_validade = '" + dataValidade + "' " +
                "WHERE nome = '" + nome + "';");
    }
}