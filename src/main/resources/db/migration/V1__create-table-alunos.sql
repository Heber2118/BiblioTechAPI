create table alunos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    ra varchar(10) not null unique,

    primary key(id)

);