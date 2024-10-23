package classes;

// Classe ProdutoVestuario derivada de Produto
public class ProdutoVestuario extends Produto {
    private String tamanho;
    private String cor;
    private String material;

    public ProdutoVestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
        super(nome, precoCusto, precoVenda);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    // Implementação dos métodos para salvar, deletar e atualizar
    @Override
    public void salvar() {
        System.out.println("INSERT INTO produtos_vestuario (nome, preco_custo, preco_venda, tamanho, cor, material) " +
                "VALUES ('" + nome + "', " + precoCusto + ", " + precoVenda + ", '" + tamanho + "', '" + cor + "', '" + material + "');");
    }

    @Override
    public void deletar() {
        System.out.println("DELETE FROM produtos_vestuario WHERE nome = '" + nome + "';");
    }

    @Override
    public void atualizar() {
        System.out.println("UPDATE produtos_vestuario SET preco_venda = " + precoVenda + ", cor = '" + cor + "' " +
                "WHERE nome = '" + nome + "';");
    }
}
