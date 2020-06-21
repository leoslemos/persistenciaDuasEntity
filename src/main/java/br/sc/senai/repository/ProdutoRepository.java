package br.sc.senai.repository;

import br.sc.senai.model.Produto;
import br.sc.senai.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.CollectionTable;
import java.util.Collection;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    //LOCALIZA TODOS OS PRODUTOS E ORDENA POR NOME PRODUTO
    @Query(value = "SELECT p FROM Produto p ORDER BY p.nomeProduto")
    Collection<Produto> findAll();

    //LOCALIZAR POR CÓDIGO DE BARRAS
    @Query(value = "SELECT p FROM Produto p WHERE p.codBarras LIKE CONCAT('%',:codBarras,'%')")
    Collection<Produto> findByCodBarras(@Param("codBarras") Integer codBarras);

    //LOCALIZA POR NOME PRODUTO
    @Query(value = "SELECT p FROM Produto p WHERE p.nomeProduto LIKE CONCAT('%',:nomeProduto,'%')")
    Collection<Produto> findAllByName(@Param("nomeProduto") String nome);

    //LOCALIZAR POR DESCRICAO
    @Query(value = "SELECT p FROM Produto p WHERE p.descricaoProduto LIKE CONCAT('%',:descricaoProduto,'%')")
    Collection<Produto> findAllByDescricaoProduto(@Param("descricaoProduto") String descricaoProduto);

}
