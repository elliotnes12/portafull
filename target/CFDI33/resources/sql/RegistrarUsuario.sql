INSERT INTO DatosEmisor (calle, ciudad, codigoPostal, colonia, comentarios, delegacionMunicipio, eliminado, email, estado, fax, fechaRegistro, logo, noExterior, noInterior, pais, razonSocial, referencia, rfc, semaforo, telefono1, telefono2, tipoPersona, ultimaActualizacion, tenant_id, foliosDisponibles, gratuito, paso, productivo) VALUES ('calleX','ciudadX', 'codigoPostalX','coloniaX','comentariosX','delegacionX',0,'emailX','estadoX','faxX',NOW(),'/home/cfdi/imagenes/xpd.png','noExteriorX','noInteriorX','paisX','razonSocialX','','rfcX',0,'telefono1X','telefono2X',0,NOW(),'tenant_idX',foliosDisponiblesX,gratuitoX,1,1);
INSERT INTO GrupoUsuario (clave, eliminado, fechaRegistro, horaFinal, horaInicial, nombre, semaforo, ultimaActualizacion, tenant_id) VALUES ('admin',0,NOW(),'2013-01-01 23:59:59','2013-01-01 00:00:00','Administradores',0,NOW(),'tenant_idX');
INSERT INTO Usuario (calle, ciudad, clave, codigoPostal, colonia, comentarios, eliminado, email, estado, fax, fechaRegistro, grupo, municipio, noExterior, noInterior, nombre, password, semaforo, telefono1, telefono2, ultimaActualizacion, bloqueado, intentos, fechaIntento, bloqueoHasta, ultimoAcceso, password2, password3, ultimoCambioPassword, tenant_id) VALUES ('calleX','ciudadX','admin',codigoPostalX,'coloniaX','',0,'emailX','estadoX','faxX',NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),'delegacionX','noExteriorX','noInteriorX','admin','6uap6ta7ll0ER+9HP/8GuQ==',0,'telefono1X','telefono2X',NOW(),0,0,NOW(),NOW(),NOW(),NULL,NULL,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),1,'admin',(SELECT nombre from Modulo where id = 1),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),2,'admin',(SELECT nombre from Modulo where id = 2),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),3,'admin',(SELECT nombre from Modulo where id = 3),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),4,'admin',(SELECT nombre from Modulo where id = 4),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),5,'admin',(SELECT nombre from Modulo where id = 5),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),6,'admin',(SELECT nombre from Modulo where id = 6),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),7,'admin',(SELECT nombre from Modulo where id = 7),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),8,'admin',(SELECT nombre from Modulo where id = 8),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),9,'admin',(SELECT nombre from Modulo where id = 9),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),10,'admin',(SELECT nombre from Modulo where id = 10),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),11,'admin',(SELECT nombre from Modulo where id = 11),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),12,'admin',(SELECT nombre from Modulo where id = 12),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),13,'admin',(SELECT nombre from Modulo where id = 13),0,0,NOW(),'tenant_idX');
INSERT INTO Permiso (eliminado, fechaRegistro, idGrupoUsuario, idModulo, modificadoPor, nombreModulo, permiso, semaforo, ultimaActualizacion, tenant_id) VALUES (0,NOW(),(SELECT id FROM GrupoUsuario where clave = 'admin' AND tenant_id = 'tenant_idX' LIMIT 1),14,'admin',(SELECT nombre from Modulo where id = 14),0,0,NOW(),'tenant_idX');
INSERT INTO Moneda (clave, eliminado, fechaRegistro, nombre, nombreCorto, semaforo, tipoCambio, ultimaActualizacion, tenant_id) VALUES ('MXN',0,NOW(),'Peso Mexicano','Peso',0,1,NOW(),'tenant_idX'), ('USD',0,NOW(),'Dólar Estadounidense','Dólar',0,12.80,NOW(),'tenant_idX');
INSERT INTO Unidad (clave, eliminado, fecha_registro, modificado_por, nombre, nombreCorto, semaforo, ultimaActualizacion, tenant_id) VALUES ('a',0,NOW(),NULL,'Año','Año',0,NULL,'tenant_idX'),('BOTELLA',0,NOW(),NULL,'BOTELLA','BOTELLA',0,NULL,'tenant_idX'),('CAJA',0,NOW(),NULL,'CAJA','CAJA',0,NULL,'tenant_idX'),('d',0,NOW(),NULL,'d','Día',0,NOW(),'tenant_idX'),('kg',0,NOW(),NULL,'Kilogramo','Kilo',0,NULL,'tenant_idX'),('hr',0,NOW(),NULL,'Hora','Hora',0,NULL,'tenant_idX'),('L',0,NOW(),NULL,'Litro','Litro',0,NULL,'tenant_idX'),('m2',0,NOW(),NULL,'Metro cuadrado','m2',0,NULL,'tenant_idX'),('m3',0,NOW(),NULL,'Metro cÚbico','m3',0,NULL,'tenant_idX'),('m',0,NOW(),NULL,'Metro','m',0,NULL,'tenant_idX'),('min',0,NOW(),NULL,'minuto','minuto',0,NULL,'tenant_idX'),('pza',0,NOW(),NULL,'Pieza','pza',0,NOW(),'tenant_idX'),('s',0,NOW(),NULL,'segundo','s',0,NULL,'tenant_idX'),('t',0,NOW(),NULL,'Tonelada','ton',0,NULL,'tenant_idX'),('w',0,NOW(),NULL,'Watt','w',0,NULL,'tenant_idX'),('na',0,NOW(),NULL,'No Aplica','No Aplica',0,NULL,'tenant_idX');
INSERT INTO ConfiguracionCFDI (eliminado, expedidoEn, fechaRegistro, iva, ivaExento, lugarDeExpedicion, metodoDePago, moneda, numeroDeCtaPago, semaforo, serie, tipoCambio, ultimaActualizacion, unidadMedida, usarClave, usarDescuento, usarIEPS, usarIEPSPor, valorIEPS, tenant_id, emailConfig) VALUES (0,NULL,NOW(),16,0,'delegacionX, estadoX','Efectivo',(SELECT id FROM Moneda where tenant_id = 'tenant_idX' and clave = 'MX' LIMIT 1),'No identificado',0,'',1,NOW(),(SELECT id FROM Unidad WHERE clave = 'na' and tenant_id = 'tenant_idX'),0,0,0,0,0,'tenant_idX','Por este medio le hago llegar su Comprobante Fiscal Digital en formato PDF y en formato XML. Ud. puede imprimir el PDF e integrarlo a su contabilidad de forma tradicional o puede guardar el archivo XML que es fiscalmente válido.');