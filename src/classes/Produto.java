package classes;

// Classe abstrata Produto
public abstract class Produto {
    protected String nome;
    protected double precoCusto;
    protected double precoVenda;

    public Produto(String nome, double precoCusto, double precoVenda) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    // Método concreto para calcular o lucro
    public double calcularLucro() {
        return precoVenda - precoCusto;
    }

    // Métodos abstratos para manipulação de registros no banco de dados
    public abstract void salvar();
    public abstract void deletar();
    public abstract void atualizar();
}