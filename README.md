# petstore-back

## Logros a destacar

1. Pipeline en Jenkins (con un Jenkinsfile en Github)
2. Configuración de Springboot centralizada en Github con soporte a ambientes dev, qa y uat
3. Manejo de Exepciones via Enums (con retro mensajes para trazas delicadas)
4. Separación de los ambientes de front y back para trabajo asíncrono
5. Encaje o inmerción del front en el paquete de despliegue del back
6. Control total de exceciones hacia el front or parte de un ControllerAvice
7. Uso de JWT para control de la seguridad
8. Cambio de C3P0 por HikariCP
9. Tren de CICD en una AMI de AWS
10. Nginx como reverse proxy y como SSL terminator y como Balanceador de cargas

## Funcionalidades interesantes:
1. Auto log off después de que el token jwt caduca
2. Control total de las validaciones de los campos de entrada con decoraciones de correctéz
3. Widget de carga de archivos con recorte y zoom

## Limpieza del aplicativo 1ra fase rama refactor/depuracion-microservicios

*Permanecen utilidades:*

1. AccessController (sign in, sign up and captcha, passwords)
2. Admin controller(upload and health)
3. DireccionController
4. TipoDireccionController
5. FileUploadController
6. QRController
7. RolController
8. RouterController
9. UsusarioController
10. UsuarioCompletoController


*Se depuran utilidades:*

**Commit #cb1567b**
1. AdministracionComprasController (el servicio solamente contaba con dos endpoints, un get y un post, eran muy basicos ademas). Las funcionalidades de administracion y gestion de compras de la organizacion quedan deshabilitadas.
2. HistorialComprasController (solo era un get de las compras de un usuario) Las funcionalidades de historial compra de un usuario quedan deshabilitadas.

**Endpoints fuera de servicio**

- api/administracion-compras-update.json
- api/administracion-compras.json
- api/historial-compras.json

**Commit #ce460da**

3. Depuracion del microservicio que generaba las graficas, 4 controladores quedaron fuera.

**Endpoints eliminados**

- api/grafica-comprador-asiduo-rango/{}/{}.json
- api/grafica-comprador-asiduo.json
- api/grafica-mascota-mas-vendida-rango/{}/{}.json
- api/grafica-mascota-mas-vendida.json
- api/grafica-paqueteria-rango/{}/{}.json
- api/grafica-paqueteria.json

- api/grafica-tipo-pago-rango.json
- api/grafica-tipo-pago

- api/grafica-total-fechas-categoria-filtro.json
- api/grafica-total-fechas-categoria.json

- api/grafica-total-importe-ventas-filtro.json
- api/grafica-total-importe-ventas.json
- api/grafica-total-numero-ordenes-ventas-filtro.json
- api/grafica-total-numero-ordenes-ventas.json

**Commit #32a967b**

4. Depuracion del microservicio de Anuncio.

**Endpoints eliminados**

- api/counter
- api/anuncios.json (GET PUT DELETE POST)
- api/content/{description}
- api/anuncios/imagen/principal.json
- api/anuncio/filter.json
- api/anuncio/search.json
- api/anuncios/imagen.json (DELETE POST)
- api/anuncios/imagen2.json
- api/anuncios/{id}.json (GET)
- api/anuncios/confirmar/{id}.json (PUT)

5. Depuracion de carrito

**Endpoints eliminados**

- api/carritoVista/{id}.json
- api/carritoUser/{id}.json
- api/carrito/{id}.json (GET POST PUT DELETE)
- api/carritoCve/{cve}.json
- api/procesa-orden.json

6.Depuracuion de criptoController

**Endpoints eliminados**

- api/wallet/{id}.json
- api/monto-btc/{monto}.json
- api/orden.json

**Commit #72dd60f**
Todo lo relacionado a catalogos

**Endpoints eliminados**

- api/atributos.json
- api/atributo.json (GET POST PUT DELETE)
- api/atributos/list/{nombre}.json
- api/atributos-detalles.json
- api/atributos-detalles.json
- api/categoria-atributos.json (GET POST PUT DELETE)
- api/categoria-atributo/categoria/{id}.json
- api/categoria-atributos-faltantes/categoria/{id}.json
- api/categorias.json
- api/categoria.json (GET POST PUT DELETE)
- api/categorias/list/{nombre}.json
- api/valor-atributos.json
- api/valor-atributo.json (DELETE PUT POST GET)
- api/valor-atributo/atributo/{id}.json

**Commit #f796bb6**
Todo lo relacionado a estatus de anuncios

**Endpoints eliminados**
- api/estatus-anuncios.json (GET POST PUT DELETE)
- api/estatusanuncios/list/{nombre}.json" (GET)

**Commit #11ab316**
Todo lo relacionado a mascota

**Endpoints eliminados**
- api//mascotas.json (GET PU POST DELETE)
- api/mascotas/filtro.json (POST)
- api//media-tipo.json (GET POST PUT DELETE)
- api/mediatipos/list/{nombre}.json

**Commit #ff0b604**
Todo lo relacionado a mmetodos de pago y paqueterias

**Endpoints eliminados**
- api/metodo-pagos.json
- api/user-metodo-pago/{id}.json GET
- api/metodo-pago.json (GET POST DELETE PUT)
- api/paqueterias.json
- api/paqueteria.json (GET PUT PUSH DELETE)
- api/paqueteria/list/{nombre}.json

