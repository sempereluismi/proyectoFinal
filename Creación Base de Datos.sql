drop database if exists ProyectoFinal;
create database ProyectoFinal;
use ProyectoFinal;


--
-- 'Estructura de la tabla Usuario'
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table usuario(
idUsuario smallint comment 'Codigo del usuario',
nombre varchar(50) unique comment 'Nombre del usuario',
contrasena varchar(20) comment 'Contraseña del usuario',
correo varchar(50) comment 'Correo del usuario',
fechaNacimineto date default null comment 'Fecha de nacimineto del usuario',
tipoUsuario enum ('usuario', 'administrador') default 'usuario',
primary key (idUsuario)
) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
insert into usuario (idUsuario, nombre, contrasena, correo, fechaNacimineto, tipoUsuario) 
values( 0, 'manu_ch', 'Palomitas02', 'manu@yahoo.es', '2002-07-20', 'administrador');
insert into usuario (idUsuario, nombre, contrasena, correo, tipoUsuario) 
values( 1, 'luismi', 'Manumanda', 'luis@yahoo.es', 'administrador');
insert into usuario (idUsuario, nombre, contrasena, correo, fechaNacimineto, tipoUsuario) 
values( 2, 'adrian', 'Adrimola', 'adri@yahoo.es', '2000-10-13', 'administrador');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

commit;
--
-- 'Estructura de la tabla Tarea'
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
create table tarea(
idTarea smallint comment 'Codigo de la tarea',
idUsuario smallint comment 'Codigo del usuario',
texto varchar (100) comment 'Tarea o recado que tenga el usuario',
estado enum ('hecho','en proceso', 'pendiente') not null comment 'Estado de la tarea',
fechaInicio date not null comment 'Fecha en la que se creó la tarea',
fechaFin date comment 'Fecha en la que se acabó la tarea',
primary key (idTarea),
constraint fk_usuario foreign key (idUsuario) references usuario (idUsuario) ON UPDATE CASCADE
) ENGINE=InnoDB;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `tarea` WRITE;
/*!40000 ALTER TABLE `tarea` DISABLE KEYS */;
insert into tarea (idTarea, idUsuario, texto, estado, fechaInicio, fechaFin) 
values( 0, 0, 'Acabar la base de datos', 'en proceso', '2023-04-20', null);
/*!40000 ALTER TABLE `tarea` ENABLE KEYS */;
UNLOCK TABLES;

-- Draft completed in 2022-04-27 09:12:47