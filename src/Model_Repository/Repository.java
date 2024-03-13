package Model_Repository;

import java.util.ArrayList;
import java.util.List;

public class Repository implements CrudRepository<Produto> {
    private List<Produto> produtos = new ArrayList<>();

    @Override
    public List<Produto> getAll() {
        return produtos;
    }

    @Override
    public void add(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public void update(String codigoProduto, Produto novoProduto) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigoProduto)) {
                produto.setNome(novoProduto.getNome());
                produto.setPreco(novoProduto.getPreco());
                break;
            }
        }
    }

    @Override
    public boolean remove(String codigoProduto) {
        return produtos.removeIf(produto -> produto.getCodigo().equals(codigoProduto));
    }

    @Override
    public Produto getById(String codigoProduto) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigoProduto)) {
                return produto;
            }
        }
        return null;
    }
}