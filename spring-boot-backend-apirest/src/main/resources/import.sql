INSERT INTO clientes (nombres_apellidos,provincia,departamento,distrito,estado) VALUES('Juan Delgado',true,-1.00545,'fgdfgdf','infectado');
INSERT INTO clientes (nombres_apellidos,provincia,departamento,distrito,estado) VALUES('Roman Delgado',false,-1.00545,'dfgdfg', 'Infectado');
INSERT INTO clientes (nombres_apellidos,provincia,departamento,distrito,estado) VALUES('Raul Delgado',true,'-2.00545','dfgdfg', 'Infectado');
INSERT INTO clientes (nombres_apellidos,provincia,departamento,distrito,estado) VALUES('Rosa Delgado',false,'-3.00545','dfgdfgd', 'Infectado');
INSERT INTO clientes (nombres_apellidos,provincia,departamento,distrito,estado) VALUES('Ana Delgado',true,'-4.00545','dfgdfg', 'Infectado');
INSERT INTO clientes (nombres_apellidos,provincia,departamento,distrito,estado) VALUES('Mario Delgado',false,'-5.00545','dfgdfgdfg', 'Infectado');

INSERT INTO compras (nombre_producto,cliente_id) VALUES('papaya',2);
INSERT INTO compras (nombre_producto,cliente_id) VALUES('platano',1);
INSERT INTO compras (nombre_producto,cliente_id) VALUES('pera',3);
INSERT INTO compras (nombre_producto,cliente_id) VALUES('manzana',2);
INSERT INTO compras (nombre_producto,cliente_id) VALUES('sandia',1);
INSERT INTO compras (nombre_producto,cliente_id) VALUES('granada',1);

INSERT INTO departamentos (nombre_departamento,estado) VALUES ('Cajamarca',true)
INSERT INTO departamentos (nombre_departamento,estado) VALUES ('Arequipa',true)
INSERT INTO departamentos (nombre_departamento,estado) VALUES ('Puno',true)
INSERT INTO departamentos (nombre_departamento,estado) VALUES ('Tumbes',true)
INSERT INTO departamentos (nombre_departamento,estado) VALUES ('Tarapoto',true)
INSERT INTO departamentos (nombre_departamento,estado) VALUES ('San Martin',true)

INSERT INTO provincias (nombre_provincia,departamento_id,estado) VALUES ('provincia1',1,true)
INSERT INTO provincias (nombre_provincia,departamento_id,estado) VALUES ('provincia2',1,true)
INSERT INTO provincias (nombre_provincia,departamento_id,estado) VALUES ('provincia3',2,true)
INSERT INTO provincias (nombre_provincia,departamento_id,estado) VALUES ('provincia4',2,true)
INSERT INTO provincias (nombre_provincia,departamento_id,estado) VALUES ('provincia5',3,true)
INSERT INTO provincias (nombre_provincia,departamento_id,estado) VALUES ('provincia6',3,true)

INSERT INTO distritos (nombre_distrito,provincia_id,estado) VALUES ('Comas',1,true)
INSERT INTO distritos (nombre_distrito,provincia_id,estado) VALUES ('San Juan Lurigancho',1,true)
INSERT INTO distritos (nombre_distrito,provincia_id,estado) VALUES ('Independencia',1,true)
INSERT INTO distritos (nombre_distrito,provincia_id,estado) VALUES ('Olivos',2,true)
INSERT INTO distritos (nombre_distrito,provincia_id,estado) VALUES ('San Martin',3,true)
INSERT INTO distritos (nombre_distrito,provincia_id,estado) VALUES ('Surco',4,true)
INSERT INTO distritos (nombre_distrito,provincia_id,estado) VALUES ('San Isidro',5,true)
INSERT INTO distritos (nombre_distrito,provincia_id,estado) VALUES ('Molina',6,true)

INSERT INTO tipos_documentos (nombre_documento,estado) VALUES ('DNI',true)
INSERT INTO tipos_documentos (nombre_documento,estado) VALUES ('Pasaporte',true)
INSERT INTO tipos_documentos (nombre_documento,estado) VALUES ('Licencia',true)

INSERT INTO nacionalidad (nombre_nacionalidad,estado) VALUES ('Peruana',true)
INSERT INTO nacionalidad (nombre_nacionalidad,estado) VALUES ('Boliviana',true)
INSERT INTO nacionalidad (nombre_nacionalidad,estado) VALUES ('Venezolana',true)
INSERT INTO nacionalidad (nombre_nacionalidad,estado) VALUES ('Italiana',true)
INSERT INTO nacionalidad (nombre_nacionalidad,estado) VALUES ('Francesa',true)
INSERT INTO nacionalidad (nombre_nacionalidad,estado) VALUES ('Inglesa',true)

INSERT INTO gps (latitud,longitud,direccion_gps,fecha_registro,estado) VALUES (-12.0621065,-77.0365256,'Lima, Perú','2020-02-13',true)
INSERT INTO gps (latitud,longitud,direccion_gps,fecha_registro,estado) VALUES (-12.0621065,-77.0365256,'Lima, Perú','2020-02-13',true)
INSERT INTO gps (latitud,longitud,direccion_gps,fecha_registro,estado) VALUES (-12.0621065,-77.0365256,'Lima, Perú','2020-02-13',true)
INSERT INTO gps (latitud,longitud,direccion_gps,fecha_registro,estado) VALUES (-12.0621065,-77.0365256,'Lima, Perú','2020-02-13',true)
INSERT INTO gps (latitud,longitud,direccion_gps,fecha_registro,estado) VALUES (-12.0621065,-77.0365256,'Lima, Perú','2020-02-13',true)
INSERT INTO gps (latitud,longitud,direccion_gps,fecha_registro,estado) VALUES (-12.0621065,-77.0365256,'Lima, Perú','2020-02-13',true)

INSERT INTO niveles_accesos (nombre_acceso,estado) VALUES ('usuario comun',true)
INSERT INTO niveles_accesos (nombre_acceso,estado) VALUES ('administrador',true)
INSERT INTO niveles_accesos (nombre_acceso,estado) VALUES ('administrador1',true)
INSERT INTO niveles_accesos (nombre_acceso,estado) VALUES ('administrador2',true)
INSERT INTO niveles_accesos (nombre_acceso,estado) VALUES ('invitado',true)

INSERT INTO estados_economicos (nombre_economico,estado) VALUES ('Necesitado',true)
INSERT INTO estados_economicos (nombre_economico,estado) VALUES ('Estable',true)

INSERT INTO estados_medicos (nombre_medico,estado) VALUES ('normal',true)
INSERT INTO estados_medicos (nombre_medico,estado) VALUES ('en riesgo',true)
INSERT INTO estados_medicos (nombre_medico,estado) VALUES ('recuperado',true)
INSERT INTO estados_medicos (nombre_medico,estado) VALUES ('fallecido',true)

INSERT INTO tipos_usuarios (nivel_acceso_id,estado) VALUES (2,true)
INSERT INTO tipos_usuarios (nivel_acceso_id,estado) VALUES (1,true)
INSERT INTO tipos_usuarios (nivel_acceso_id,estado) VALUES (1,true)
INSERT INTO tipos_usuarios (nivel_acceso_id,estado) VALUES (1,true)
INSERT INTO tipos_usuarios (nivel_acceso_id,estado) VALUES (1,true)
INSERT INTO tipos_usuarios (nivel_acceso_id,estado) VALUES (1,true)

INSERT INTO reportes_economicos (bono_asignado,monto_servicio,boleta_imagen,estado_economico_id,fecha_registro,estado) VALUES (true,8500,'boletaimagen1',1,'2020-02-13',true)
INSERT INTO reportes_economicos (bono_asignado,monto_servicio,boleta_imagen,estado_economico_id,fecha_registro,estado) VALUES (false,9400,'boletaimagen2',2,'2020-02-13',true)
INSERT INTO reportes_economicos (bono_asignado,monto_servicio,boleta_imagen,estado_economico_id,fecha_registro,estado) VALUES (true,9400,'boletaimagen3',1,'2020-02-13',true)
INSERT INTO reportes_economicos (bono_asignado,monto_servicio,boleta_imagen,estado_economico_id,fecha_registro,estado) VALUES (false,9400,'boletaimagen4',2,'2020-02-13',true)
INSERT INTO reportes_economicos (bono_asignado,monto_servicio,boleta_imagen,estado_economico_id,fecha_registro,estado) VALUES (true,9400,'boletaimagen5',1,'2020-02-13',true)
INSERT INTO reportes_economicos (bono_asignado,monto_servicio,boleta_imagen,estado_economico_id,fecha_registro,estado) VALUES (false,9400,'boletaimagen6',2,'2020-02-13',true)

INSERT INTO reportes_medicos (resultado_triaje,estado_medico_id,fecha_registro,estado) VALUES (true,2,'2020-02-13',true)
INSERT INTO reportes_medicos (resultado_triaje,estado_medico_id,fecha_registro,estado) VALUES (false,1,'2020-02-13',true)
INSERT INTO reportes_medicos (resultado_triaje,estado_medico_id,fecha_registro,estado) VALUES (true,2,'2020-02-13',true)
INSERT INTO reportes_medicos (resultado_triaje,estado_medico_id,fecha_registro,estado) VALUES (false,1,'2020-02-13',true)
INSERT INTO reportes_medicos (resultado_triaje,estado_medico_id,fecha_registro,estado) VALUES (true,2,'2020-02-13',true)
INSERT INTO reportes_medicos (resultado_triaje,estado_medico_id,fecha_registro,estado) VALUES (false,1,'2020-02-13',true)

INSERT INTO usuarios_casos (telefono,nombre,apellido,nacimiento,numero_documento,direccion_domicilio,codigo_confirmacion,condicion_uso,fecha_registro,distrito_id,tipo_documento_id,nacionalidad_id,gps_id,tipo_usuario_id,reporte_economico_id,reporte_medico_id,estado) VALUES('954954954','juan','delgado','2020-02-13','43795458','av. algun lugar 123,1era etapa Retablo. Comas',1234,true,'2020-02-13',1,1,1,1,1,1,1,true);

INSERT INTO usuarios_casos (telefono,nombre,apellido,nacimiento,numero_documento,direccion_domicilio,codigo_confirmacion,condicion_uso,fecha_registro,distrito_id,tipo_documento_id,nacionalidad_id,gps_id,tipo_usuario_id,reporte_economico_id,reporte_medico_id,estado) VALUES('954954954','roman','delgado','2020-02-13','43795458','av. algun lugar 123,1era etapa Retablo. Comas',1234,true,'2020-02-13',2,1,1,2,2,2,2,true);

INSERT INTO usuarios_casos (telefono,nombre,apellido,nacimiento,numero_documento,direccion_domicilio,codigo_confirmacion,condicion_uso,fecha_registro,distrito_id,tipo_documento_id,nacionalidad_id,gps_id,tipo_usuario_id,reporte_economico_id,reporte_medico_id,estado) VALUES('954954954','jose','delgado','2020-02-13','43795458','av. algun lugar 123,1era etapa Retablo. Comas',1234,true,'2020-02-13',3,2,2,3,2,3,3,true);

INSERT INTO usuarios_casos (telefono,nombre,apellido,nacimiento,numero_documento,direccion_domicilio,codigo_confirmacion,condicion_uso,fecha_registro,distrito_id,tipo_documento_id,nacionalidad_id,gps_id,tipo_usuario_id,reporte_economico_id,reporte_medico_id,estado) VALUES('954954954','miguel','delgado','2020-02-13','43795458','av. algun lugar 123,1era etapa Retablo. Comas',1234,true,'2020-02-13',3,2,2,4,2,4,4,true);

INSERT INTO usuarios_casos (telefono,nombre,apellido,nacimiento,numero_documento,direccion_domicilio,codigo_confirmacion,condicion_uso,fecha_registro,distrito_id,tipo_documento_id,nacionalidad_id,gps_id,tipo_usuario_id,reporte_economico_id,reporte_medico_id,estado) VALUES('954954954','edinson','delgado','2020-02-13','43795458','av. algun lugar 123,1era etapa Retablo. Comas',1234,true,'2020-02-13',4,3,1,5,2,5,5,true);

INSERT INTO usuarios_casos (telefono,nombre,apellido,nacimiento,numero_documento,direccion_domicilio,codigo_confirmacion,condicion_uso,fecha_registro,distrito_id,tipo_documento_id,nacionalidad_id,gps_id,tipo_usuario_id,reporte_economico_id,reporte_medico_id,estado) VALUES('954954954','raul','delgado','2020-02-13','43795458','av. algun lugar 123,1era etapa Retablo. Comas',1234,true,'2020-02-13',4,3,1,6,2,6,6,true);














































	
	
