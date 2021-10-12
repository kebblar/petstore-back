# petstore-back 
## Limpieza del aplicativo 1ra fase rama refactor/depuracion-microservicios

*Permanecen utilidades:*

1. AccessController (sign in, sign up and captcha)
2. Admin controller(upload and health)


*Se depuran utilidades:*

*Commit #cb1567b*
1. AdministracionComprasController (el servicio solamente contaba con dos endpoints, un get y un post, eran muy basicos ademas). Las funcionalidades de administracion y gestion de compras de la organizacion quedan deshabilitadas.
2. HistorialComprasController (solo era un get de las compras de un usuario) Las funcionalidades de historial compra de un usuario quedan deshabilitadas. 

*Endpoints fuera de servicio*

- api/administracion-compras-update.json
- api/administracion-compras.json
- api/historial-compras.json

*Commit #ce460da*

3. Depuracion del microservicio que generaba las graficas, 4 controladores quedaron fuera.

*Endpoints eliminados*

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
