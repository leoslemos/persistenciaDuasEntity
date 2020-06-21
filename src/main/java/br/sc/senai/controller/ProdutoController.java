package br.sc.senai.controller;

import br.sc.senai.model.Produto;
import br.sc.senai.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping(path = "/add")
    public @ResponseBody
    String adicionaNovoProduto(@RequestParam Integer codBarras, @RequestParam String nomeProduto, @RequestParam String descricaoProduto,
                               @RequestParam Double qtdEstoque, @RequestParam String unidade, @RequestParam Double custoProduto,
                               @RequestParam Double valorVenda, @RequestParam String fotoProduto){

        Produto product = new Produto();
        product.setCodBarras(codBarras);
        product.setNomeProduto(nomeProduto);
        product.setDescricaoProduto(descricaoProduto);
        product.setQtdEstoque(qtdEstoque);
        product.setUndiade(unidade);
        product.setCustoProduto(custoProduto);
        product.setValorVenda(valorVenda);
        product.setFotoProduto(fotoProduto);

        produtoRepository.save(product);

        return "Produto foi incluído no banco de dados";
    }

    @PostMapping(path = "/update")
    public  @ResponseBody
    String alteraProduto(@RequestParam Integer idProduto, @RequestParam Integer codBarras, @RequestParam String nomeProduto,
                         @RequestParam String descricaoProduto, @RequestParam Double qtdEstoque, @RequestParam String unidade,
                         @RequestParam Double custoProduto, @RequestParam Double valorVenda, @RequestParam String fotoProduto){

        Produto product = produtoRepository.findById(idProduto).get();
        product.setCodBarras(codBarras);
        product.setNomeProduto(nomeProduto);
        product.setDescricaoProduto(descricaoProduto);
        product.setQtdEstoque(qtdEstoque);
        product.setUndiade(unidade);
        product.setCustoProduto(custoProduto);
        product.setValorVenda(valorVenda);
        product.setFotoProduto(fotoProduto);

        produtoRepository.save(product);

        return "Produto com id "+product.getIdProduto()+" atualizado no banco de dados";

    }

    @PostMapping(path = "/remove")
    public @ResponseBody
    String removeProduto(@RequestParam Integer idProduto){

        produtoRepository.deleteById(idProduto);
        return "Prduto excluido com sucesso!!!";

    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Produto> findAll(){
        // @ResponseBody significa que a String retornada é a resposta
        // @RequestParam significa que é um parâmetro da solicitação GET ou POST
        return produtoRepository.findAll();
    }

    @GetMapping(path = "/name")
    public @ResponseBody
    Iterable<Produto> findAllByName(@RequestParam String nome) {
        // @ResponseBody significa que a String retornada é a resposta
        // @RequestParam significa que é um parâmetro da solicitação GET ou POST
        return produtoRepository.findAllByName(nome);
    }

    @GetMapping(path = "/description")
    public @ResponseBody
    Iterable<Produto> findAllByDescricaoProduto(@RequestParam String descricaoProduto) {
        // @ResponseBody significa que a String retornada é a resposta
        // @RequestParam significa que é um parâmetro da solicitação GET ou POST
        return produtoRepository.findAllByDescricaoProduto(descricaoProduto);
    }


    @GetMapping(path = "/barcode")
    public @ResponseBody
    Iterable<Produto> findByCodBarras(@RequestParam Integer codBarras) {
        // @ResponseBody significa que a String retornada é a resposta
        // @RequestParam significa que é um parâmetro da solicitação GET ou POST
        return produtoRepository.findByCodBarras(codBarras);
    }

}
