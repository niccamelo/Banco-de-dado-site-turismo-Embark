create database siteEmbark;
use siteEmbark;

create table CLIENTE(
id_cliente varchar(15) primary key not null,
nome varchar(40) not null,
email varchar(40) not null,
cidade varchar(40) not null,
cep int(10) not null,
senha varchar(8),
sobre_nome VARCHAR(40),
estado varchar(10)
);

create table compra (
nota_fiscal varchar (20) primary key,
data_compra datetime not null,
nome_cliente varchar (40) not null,
quantidade_compra int (10) not null,
destino varchar (40) not null,
cpf_cliente varchar(15) not null
 );

create table cliente_compra (
id_cliente varchar(15),
nota_fiscal varchar (20),
foreign key(id_cliente) references CLIENTE (id_cliente),
foreign key(nota_fiscal) references compra (nota_fiscal)
);

create table promocoes (
id_promo int primary key,
destinos_promo varchar (40) not null,
nomeHosp varchar (40) not null,
preço varchar (20),
id_hosp int,
foreign key(id_hosp) references Hospedagem (id_hosp)
);

create table Hospedagem (
id_hosp int primary key,
nomeHosp varchar (40) not null,
cidade varchar (80) not null,
estado varchar (80) not null,
rua varchar (80) not null
);

create table compra_promo (
id_promo int,
nota_fiscal varchar (20),
foreign key(id_promo) references promocoes (id_promo),
foreign key(nota_fiscal) references compra (nota_fiscal)
);

create table pct_viagem (
id_destino varchar (10) primary key,
preço varchar (10) not null,
data_da_viagem date not null,
destino varchar (40) not null,
condução varchar (20) not null,
id_hosp int,
foreign key(id_hosp) references Hospedagem (id_hosp)
);

DROP TABLE pct_viagem; 

create table compra_pct_viagem(
id_destino varchar (10),
nota_fiscal varchar (20),
foreign key(id_destino) references pct_viagem (id_destino),
foreign key(nota_fiscal) references compra (nota_fiscal)
);

select*from cliente;