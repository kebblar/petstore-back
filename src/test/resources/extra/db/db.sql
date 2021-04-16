CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `usuario_rol` (
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(12) NOT NULL,
  PRIMARY KEY (`id_usuario`, `id_rol`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `fk_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
);

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(128) NOT NULL,
  `clave` varchar(128) NOT NULL DEFAULT 'temp',
  `creado` bigint(20) NOT NULL DEFAULT 0,
  `activo` tinyint(1) NOT NULL DEFAULT 0,
  `acceso_negado_contador` int(11) NOT NULL DEFAULT 0,
  `instante_bloqueo` bigint(20) NOT NULL DEFAULT 0,
  `instante_ultimo_acceso` bigint(20) NOT NULL DEFAULT 0,
  `instante_ultimo_cambio_clave` bigint(20) NOT NULL DEFAULT 0,
  `regenera_clave_token` varchar(128) NOT NULL DEFAULT 'NA',
  `regenera_clave_instante` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_usuario_correo` (`correo`),
  KEY `idx_usuario_regenera` (`regenera_clave_token`)
);

