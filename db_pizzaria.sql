create database pizzariadb;
use pizzariadb;

create table produtos (

id int(20) not null auto_increment,
imagem varchar(100),
nome varchar(60) not null,
descricao varchar(300),
valor double(10, 2) not null,
quantidade int(10) not null,
idCategoria int(20) not null,

primary key(id),
foreign key (idCategoria) references categorias (id)
);

create table categorias (

id int(20) not null auto_increment,
categoria varchar(100) not null,

primary key(id)
);

create table clientes (

id int not null auto_increment,
nome varchar(60) not null,
genero varchar(10) not null,
cpf varchar(11),

primary key(id)
);

create table enderecos (

id int(20) not null auto_increment,
endereco varchar(60) not null,
numero int(10) not null,
bairro varchar(40) not null,
complemento varchar(60),
cep int(9),
enderecoEntrega varchar(5) not null,
idCliente int(20) not null,

primary key(id),
foreign key(idCliente) references clientes (id)
);

create table funcionarios (

id int(20) not null auto_increment,
nome varchar(60) not null,
email varchar(100),
dataNascimento datetime not null,
cpf varchar(11) not null,
apelido varchar(30) not null,
senha varchar(14) not null,
administrador varchar(3) not null,

primary key(id)
);