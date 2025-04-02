INSERT INTO orden (id, fecha_hora, numero_mesa, pago_pendiente) VALUES (1, NOW(), 5, fasle);
INSERT INTO orden (id, fecha_hora, numero_mesa, pago_pendiente) VALUES (2, NOW(), 3, fasle);
INSERT INTO orden (id, fecha_hora, numero_mesa, pago_pendiente) VALUES (3, NOW(), 7, fasle);
INSERT INTO orden (id, fecha_hora, numero_mesa, pago_pendiente) VALUES (4, NOW(), 2, fasle);
INSERT INTO orden (id, fecha_hora, numero_mesa, pago_pendiente) VALUES (5, NOW(), 6, fasle);
INSERT INTO orden (id, fecha_hora, numero_mesa, pago_pendiente) VALUES (6, NOW(), 4, fasle);

-- Insertando 4 productos
INSERT INTO producto (id, categoria_producto, descripcion, nombre, precio) VALUES (6, 'PLATILLO', 'Taco de barbacoa', 'Taco', 30.00);
INSERT INTO producto (id, categoria_producto, descripcion, nombre, precio) VALUES (7, 'PLATILLO', 'Quesadilla de queso', 'Quesadilla', 35.00);
INSERT INTO producto (id, categoria_producto, descripcion, nombre, precio) VALUES (8, 'BEBIDA', 'Refresco de cola', 'Refresco', 20.00);
INSERT INTO producto (id, categoria_producto, descripcion, nombre, precio) VALUES (9, 'BEBIDA', 'Jugo de naranja natural', 'Jugo', 25.00);

-- Insertando 10 registros en contenido_orden
INSERT INTO contenido_orden (id, cantidad_producto, notas, orden_id, producto_id) VALUES (1, 2, 'Sin cebolla', 1, 6);
INSERT INTO contenido_orden (id, cantidad_producto, notas, orden_id, producto_id) VALUES (2, 1, 'Con mucha salsa', 1, 7);
INSERT INTO contenido_orden (id, cantidad_producto, notas, orden_id, producto_id) VALUES (3, 3, 'Fría', 1, 8);
INSERT INTO contenido_orden (id, cantidad_producto, notas, orden_id, producto_id) VALUES (4, 2, 'Con hielo', 2, 9);
INSERT INTO contenido_orden (id, cantidad_producto, notas, orden_id, producto_id) VALUES (5, 4, 'Con extra limón', 2, 6);
INSERT INTO contenido_orden (id, cantidad_producto, notas, orden_id, producto_id) VALUES (6, 1, 'Bien dorado', 3, 7);
INSERT INTO contenido_orden (id, cantidad_producto, notas, orden_id, producto_id) VALUES (7, 2, 'Sin salsa', 3, 6);
INSERT INTO contenido_orden (id, cantidad_producto, notas, orden_id, producto_id) VALUES (8, 3, 'Grande', 4, 8);
INSERT INTO contenido_orden (id, cantidad_producto, notas, orden_id, producto_id) VALUES (9, 1, 'Poco dulce', 5, 9);
INSERT INTO contenido_orden (id, cantidad_producto, notas, orden_id, producto_id) VALUES (10, 2, 'Doble tortilla', 5, 6);











