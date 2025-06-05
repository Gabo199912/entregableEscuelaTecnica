CREATE DATABASE escuela;
USE escuela;

CREATE TABLE PERSONAS(
	id_usuarios int primary key auto_increment,
    nombre_usuario varchar (120),
    contrasenia varchar(40),
    tipo_usuario ENUM('administrador', 'alumno', 'maestro'),
    fecha_creacion date default(current_date),
    fecha_nacimiento date not null,
    email varchar (120) unique,
    telefono varchar(20),
    activo boolean
);

CREATE TABLE DURACION_CURSOS(
	id_duracion int primary key auto_increment,
    fecha_inicio date,
    fecha_final date
);

CREATE TABLE CURSOS_ALUMNOS(
	id_cursos_alumno int primary key auto_increment,
    id_cursos int,
    fecha_inscripcion date default(current_date),
    id_usuarios int,
    
    foreign key (id_usuarios) references PERSONAS(id_usuarios),
    foreign key (id_cursos) references CURSOS_IMPARTIDOS(id_cursos)
);

CREATE TABLE CURSOS_IMPARTIDOS(
	id_cursos int primary key auto_increment,
    id_datos_cursos int,
    id_duracion int,
    nota_curso int,
    activo boolean,
    
    foreign key (id_datos_cursos) references CURSOS(id_datos_cursos),
    foreign key (id_duracion) references DURACION_CURSOS(id_duracion)
);


CREATE TABLE CURSOS(
	id_datos_cursos int primary key auto_increment,
    nombre_curso varchar(60),
    id_maestro int,
    
    foreign key (id_maestro) references PERSONAS(id_usuarios)
);


CREATE TABLE INFORMACION_CURSOS(
    id_informacion_cursos int primary key auto_increment,
    id_usuario int,
    id_datos_cursos int,
    id_duracion int,

    foreign key (id_usuario) references PERSONAS(id_usuarios),
    foreign key (id_datos_cursos) references CURSOS(id_datos_cursos),
    foreign key (id_duracion) references DURACION_CURSOS(id_duracion)
);





select * from PERSONAS;

SELECT * FROM CURSOS;

select * from CURSOS_IMPARTIDOS;

select * from DURACION_CURSOS;


update PERSONAS set activo = true where id_usuarios = 2;



INSERT INTO PERSONAS (
    nombre_usuario,
    contrasenia,
    tipo_usuario,
    fecha_nacimiento,
    email,
    telefono,
    activo
) VALUES (
    'angel',
    'angel',
    'administrador',
    '1999-03-12',
    'angel@email.com',
    '12345678',  -- agregando un número de teléfono
    true
);
