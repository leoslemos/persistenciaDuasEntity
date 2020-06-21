create database demo_crud;
use demo_crud;

create table usuario(
	id int not null auto_increment primary key,
    nome varchar(100),
    email varchar(100),
    senha varchar(100)
);

create table produto (
	idproduto int not null auto_increment,
    cod_barras int default null,
    nome_produto varchar(100) not null,
    descricao_produto varchar(100) not null,
    qtd_estoque double(10,6) not null,
    unidade varchar(10) not null,
    custo_produto double(10,6) not null,
    valor_venda double(10,6) not null,
    foto_produto varchar(100),
    primary key(idproduto)
);
