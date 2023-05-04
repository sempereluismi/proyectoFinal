drop database if exists ProyectoFinal;
create database ProyectoFinal;
use ProyectoFinal;


--
-- Estructura de la tabla 'usuario'
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table usuario(
idUsuario smallint auto_increment comment 'Codigo del usuario',
nombre varchar(50) unique comment 'Nombre del usuario',
contrasena varchar(200) comment 'Contraseña del usuario',
correo varchar(50) comment 'Correo del usuario',
fechaNacimiento date default null comment 'Fecha de nacimineto del usuario',
tipoUsuario enum ('usuario', 'administrador') default 'usuario',
primary key (idUsuario)
) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Volcado de datos sobre la tabla `usuario`
--

insert into usuario (nombre, contrasena, correo, fechaNacimiento, tipoUsuario) 
values( 'manu_ch', 'Palomitas02', 'manu@yahoo.es', '2002-07-20', 'administrador');
insert into usuario ( nombre, contrasena, correo,fechaNacimiento, tipoUsuario) 
values( 'luismi', 'Manumanda', 'luis@gmail.com','2003-07-30', 'administrador');
insert into usuario (nombre, contrasena, correo, fechaNacimiento, tipoUsuario) 
values( 'adrian', 'Adrimola', 'adri@hotmail.es', '2000-10-13', 'administrador');

--
-- Estructura de la tabla 'tarea'
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table tarea(
idTarea smallint auto_increment comment 'Codigo de la tarea',
idUsuario smallint comment 'Codigo del usuario',
texto varchar (100) comment 'Tarea o recado que tenga el usuario',
estado enum ('hecha','activa') not null comment 'Estado de la tarea',
fechaInicio date not null comment 'Fecha en la que se creó la tarea',
fechaFin date comment 'Fecha en la que se acabó la tarea',
primary key (idTarea),
constraint fk_usuario foreign key (idUsuario) references usuario (idUsuario) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Volcado de datos sobre la tabla `tarea`
--

insert into tarea ( idUsuario, texto, estado, fechaInicio, fechaFin) 
values( 1, 'Acabar la base de datos', 'activa', '2023-04-20', null);


-- Borrador completado en 2022-04-27 09:12:47