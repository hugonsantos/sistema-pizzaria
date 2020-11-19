create table Produtos (

id int(20) not null auto_increment,
imagem varchar(100),
nome varchar(60) not null,
descricao varchar(300),
valor double(10, 2) not null,
quantidade int(10) not null,

primary key(id)
);

create table endereco (

id int(20) not null auto_increment,
endereco varchar(60) not null,
numero int(10) not null,
bairro varchar(40) not null,
complemento varchar(60),
cep int(9),

primary key(id)
);

create table clientes (

id int not null auto_increment,
nome varchar(60) not null,
cpf int(12),
idEndereco int(20) not null,

primary key(id),
foreign key(idEndereco) references endereco (id)
);

create table usuarios (

id int(20) not null auto_increment,
apelido varchar(30) not null,
senha varchar(14) not null,

primary key(id)
);

create table funcionarios (

id int(20) not null auto_increment,
nome varchar(60) not null,
email varchar(100),
idade int(4),
cpf int(12) not null,
idUsuario int(20) not null,

primary key(id),
foreign key(idUsuario) references usuarios(id)
);