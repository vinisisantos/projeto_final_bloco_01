package Model_Repository;

import java.util.List;

public interface Repository {

    List<Produto> getProdutos();

    void adicionarProduto(Produto produto);

    void listarProdutos();

    void atualizarProduto(String codigoProduto, Produto novoProduto);

    boolean removerProduto(String codigoProduto);

    Produto buscarProdutoPorCodigo(String codigoProduto);
}
