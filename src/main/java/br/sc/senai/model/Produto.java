package br.sc.senai.model;

import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idproduto")
    private Integer idProduto;

    @Column(name = "cod_barras")
    private Integer codBarras;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "descricao_produto")
    private String descricaoProduto;

    private String unidade;

    @Column(name = "qtd_estoque")
    private Double qtdEstoque;

    @Column(name = "custo_produto")
    private Double custoProduto;

    @Column(name = "valor_venda")
    private Double valorVenda;

    @Column(name = "foto_produto")
    private String fotoProduto;

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(Integer codBarras) {
        this.codBarras = codBarras;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUndiade(String unidade) {
        this.unidade = unidade;
    }

    public Double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Double getCustoProduto() {
        return custoProduto;
    }

    public void setCustoProduto(Double custoProduto) {
        this.custoProduto = custoProduto;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = calculaValorVenda(valorVenda);
    }

    public String getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(String fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    public Double calculaValorVenda(Double custoProduto){
        Double valorAtualizado = custoProduto * 1.30;
        return valorAtualizado;
    }
}
