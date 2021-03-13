create database bdLocacaoCarro;
use bdLocacaoCarro;
create table oficinas(
ofiId int(5) not null auto_increment,
ofiNome varchar(30) not null,
primary key(ofiId));

create table categorias(
catId int(5) not null auto_increment,
catNome varchar(50) not null,
catDescricao varchar(100) not null,
catPreco double not null,
primary key(catId),
unique key catDescricao(catDescricao));

create table servicos(
serId int(5) not null auto_increment,
serDescricao varchar(100) not null,
primary key (serId));

create table fabricantes(
fabId int(5) not null auto_increment,
fabNome varchar(50) not null,
primary key(fabId));

create table modelos(
modId int(5) not null auto_increment,
modNome varchar(50) not null,
modFabId int(5) not null,
primary key (modId),
unique key modNome(modNome),
constraint fk_fabricante foreign key(modFabId) references fabricantes(fabId));

create table carro(
carChassi varchar(20) not null,
carPlaca varchar (7) not null,
carAno int(4) not null,
carCor varchar(30) not null,
carModId int(5) not null,
carOfiId int(5) not null,
carCatId int(5) not null,
primary key (carChassi),
constraint fk_modelos foreign key(carModId) references modelos(modId),
constraint fk_categoria foreign key(carCatId) references categorias(catId));

create table consertos(
conId int(5) not null auto_increment,
conDataEntrada date not null,
conDataSaida date not null,
conOfiId int(5) not null,
conCarChassi varchar(20) not null,
primary key(conId),
constraint fk_oficinas foreign key(conOfiId) references oficinas(ofiId),
constraint fk_carro foreign key(conCarChassi) references carro(carChassi));

create table itens(
iteSerId int(5) not null,
iteConId int(5) not null,
primary key (iteSerId, iteConId),
constraint fk_servicos foreign key(iteSerId) references servicos(serId),
constraint fk_consertos foreign key(iteConId) references consertos(conId));

create table clientes(
cliId int(5) not null auto_increment,
cliCpf varchar(14) not null,
cliNome varchar(50) not null,
cliRg varchar(10) not null,
cliEndereco varchar(50) not null,
primary key (cliId),
unique key rg(cliRg));

create table funcionarios(
funMatricula int(5) not null auto_increment,
funNome varchar(50) not null,
funLogin varchar(50) not null,
funSenha varchar(50) not null,
funMatGerente int(5) not null,
primary key(funMatricula),
unique key login(funLogin),
constraint fk_funcionarios foreign key(funMatGerente) references funcionarios(funMatricula));

create table locacao(
locId int(5) not null auto_increment,
locData date not null,
locDevolucao date not null,
locQuantDia double not null,
locHora datetime not null,
locTotal double not null,
locStatus varchar(20) not null,
locCarChassi varchar(20) not null,
locFunMatricula int(5) not null,
locCliId int(5) not null,
primary key(locId),
foreign key(locCarChassi) references carro(carChassi),
foreign key(locFunMatricula) references funcionarios(funMatricula),
foreign key(locCliId) references clientes(cliId));



