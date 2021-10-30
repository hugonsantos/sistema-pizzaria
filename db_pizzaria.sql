create database pizzariadb;
use pizzariadb;

create table categorias (

	id integer not null auto_increment,
	categoria varchar(100) not null,

	primary key(id)
);

create table produtos (

	id integer not null auto_increment,
    miniatura longtext,
    extensao varchar(20),
	nome varchar(150) not null,
	descricao varchar(300),
	valorBroto double(10, 2) not null,
    valorTradicional double(10, 2) not null,
    valorGrande double(10, 2) not null,
    valorExtraGrande double(10, 2) not null,
	idCategoria integer not null,

	primary key(id),
	foreign key (idCategoria) references categorias (id)
);

create table bordas (

	id integer not null auto_increment,
    borda varchar(50) not null,
    tipoBorda varchar(10) not null,
    
    primary key(id)
);

create table clientes (

	id integer not null auto_increment,
	nome varchar(60) not null,
	genero varchar(10) not null,
	cpf varchar(13),
    telfixo varchar(10),
    celular varchar(11),

	primary key(id)
);

create table enderecos (

	id integer not null auto_increment,
	endereco varchar(100) not null,
	numero integer(20) not null,
	bairro varchar(80) not null,
	complemento varchar(200),
	cep integer(9),
    cidade varchar(200) not null,
    estado varchar(5),
	enderecoEntrega varchar(5) not null,
	idCliente integer not null,

	primary key(id),
	foreign key(idCliente) references clientes (id)
);

create table funcionarios (

	id integer not null auto_increment,
	nome varchar(60) not null,
	email varchar(100),
	dataNascimento datetime not null,
	cpf varchar(13) not null,
	usuario varchar(30) not null,
	senha varchar(14) not null,
	administrador varchar(3) not null,

	primary key(id)
);

insert into categorias(categoria) values("Selecione...");
insert into categorias(categoria) values("Pizza salgada");
insert into categorias(categoria) values("Pizza doce");
insert into categorias(categoria) values("Porção");
insert into categorias(categoria) values("Lanche");
insert into categorias(categoria) values("Esfiha");
insert into categorias(categoria) values("Fogazza");
insert into categorias(categoria) values("Pastel");
insert into categorias(categoria) values("Sobremesa");
insert into categorias(categoria) values("Bebida");

insert into bordas(borda, tipoBorda) values("Selecione...", "Selecione");
insert into bordas(borda, tipoBorda) values("Catupiry", "Salgada");
insert into bordas(borda, tipoBorda) values("Calabresa", "Salgada");
insert into bordas(borda, tipoBorda) values("Requeijão", "Salgada");
insert into bordas(borda, tipoBorda) values("Calabresa com catupiry", "Salgada");
insert into bordas(borda, tipoBorda) values("Cream Cheese Philadelphia", "Salgada");
insert into bordas(borda, tipoBorda) values("Mista (Requeijão e Cheddar)", "Salgada");
insert into bordas(borda, tipoBorda) values("Gergelim", "Salgada");

insert into bordas(borda, tipoBorda) values("Chocolate ao leite", "Doce");
insert into bordas(borda, tipoBorda) values("Chocolate branco", "Doce");
insert into bordas(borda, tipoBorda) values("Creme de avelã", "Doce");
insert into bordas(borda, tipoBorda) values("Ovomaltine cremoso", "Doce");