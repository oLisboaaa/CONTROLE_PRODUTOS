import classes.ProdutoAlimenticio;
import classes.ProdutoVestuario ;


// Classe para testar os produtos
public class Oxxo {
    public static void main(String[] args) {
        // Criando um Produto Alimentício
        ProdutoAlimenticio pa = new ProdutoAlimenticio("Arroz", 10.0, 15.0, "2025-12-31", "Baixo em sódio");
        pa.salvar();
        pa.atualizar();
        System.out.println("Lucro do produto alimentício: R$" + pa.calcularLucro());
        pa.deletar();

        // Criando um Produto de Vestuário
        ProdutoVestuario pv = new ProdutoVestuario("Camisa", 20.0, 40.0, "M", "Preto", "Algodão");
        pv.salvar();
        pv.atualizar();
        System.out.println("Lucro do produto de vestuário: R$" + pv.calcularLucro());
        pv.deletar();
    }
}