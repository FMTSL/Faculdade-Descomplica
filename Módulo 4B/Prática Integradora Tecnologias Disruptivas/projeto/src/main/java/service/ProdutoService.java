package service;

import entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProdutoRepository;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public Produto getById(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto saveProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Integer id, Produto produto) {
        Produto produtoAtualizada = produtoRepository.findById(id).orElse(null);
        if (produtoAtualizada != null){
            produtoAtualizada.setProdutoNome(produto.getProdutoNome());
            return produtoRepository.save(produtoAtualizada);
        }

        else {
            return null;
        }
    }

    public Boolean deleteProduto(Integer id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        if (produto != null){
            produtoRepository.delete(produto);
            return true;
        }
        else {
            return false;
        }
    }
}
