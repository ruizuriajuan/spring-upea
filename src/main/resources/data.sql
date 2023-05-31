-- Default categories --
INSERT IGNORE INTO categories (id, name, description) VALUES (1, 'TRAVEL', 'Mochillas para viajar');
INSERT IGNORE INTO categories (id, name, description) VALUES (2, 'SCHOOL', 'Mochillas para la escuela');
INSERT IGNORE INTO categories (id, name, description) VALUES (3, 'SPORT', 'Mochillas deportivas');
INSERT IGNORE INTO categories (id, name, description) VALUES (4, 'WORK', 'Mochillas para el trabajo');

-- Default roles --
INSERT IGNORE INTO roles (id, name, description) VALUES (1, 'ADMIN', 'Role admin');
INSERT IGNORE INTO roles (id, name, description) VALUES (2, 'USER', 'Role user');

-- Default products --
INSERT IGNORE INTO products (name, description, image_url, price, stock, active, category_id) VALUES
('Mochila Profesional', 'Description del producto A','https://image.png1',240,30,true,1),
('Mochilla Totto', 'Mochilla para niño totto','https://image.png',236.99,20,true,3),
('Mochilla Husky', 'Mochilla para trabajo color rojo para hombre','https://image.png',306.85,39,true,2),
('Product HM', 'Description del producto HM','https://image_hm.png',108.10, 50,true,1),
('Product HN', 'Description del producto HN','https://image_hn.png',40.95, 5,false,1),
('Decker', 'Mochila tipo morral para niños', 'https://bo.totto.com/mochila-mediano-estampado-acuarela-n17/p?idsku=12140', 54, 120.99, true, 1),
('CAT', 'Mochila para transportar herramientas de trabajo', 'https://catmania.store/categoria-producto/mochilas-cat/', 67, 145.99, true, 1),
('MOCHILA VIAJERA', 'MOCHILA DE VIAJE','https://image.png',135.50,25,true,1),
('MOCHILA ESCOLAR', 'MOCHILA ESCOLAR MEDIANA','https://image.png',108,100,true,1),
('Producto estrella1','el mejor producto a la venta','https://image.png',30,10,true,1),
('Producto perro','producto de no mucha afluencia','https://image.png',10,200,true,1),
('Mochila Roja', 'Description de la mochila roja','https://imageAO.png',629.54,50,true,1),
('Mochila Azul', 'Description de la mochila azul','https://imageA_O_2.png',456.21,65,true,1),
('Mochila Escolar', 'Mochila para ninos color plomo tamano mediano','https://www.victoriadesignsbolivia.com/wp-content/uploads/2020/02/PRINCIPAL-10.jpg',120.00, 5,true,3),
('Mochila Juvenil ', 'Mochila juvenil tamano mediano en color negro','https://flow.bo/media/catalog/product/3/2/3203432-3.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=300&width=240&canvas=240:300',180.00, 15,true,2),
('Ruokowad', 'Mochillas deportiva Ruokowad','https://image.png',150.00,20,true,2),
('Pabbardh', 'Mochillas para el trabajo Pabbardh','https://image.png',200.00,10,true,2),
('Mochila Michey S', 'Mochila que lleva tus personajes favoritos','https://image.png',389.00,50,true,3),
('Mochila Estampado Acuarela', 'Lleva tus cosas con multiples compartimientos','https://image.png',309.00,80,true,1),
('Product M', 'Description del producto M','https://image10.gif',30.50,200,true,1),
('Product P', 'Description del producto A','https://image11.png',70.00,50,false,1),
('Product D001', 'Mochila en color plomo','https://media.gq.com.mx/photos/5ee930538f739bf973bc80f0/master/w_1600%2Cc_limit/Adidas%2520Prime%2520V%2520Backpack.jpg', 160, 25, true, 1),
('Product Mano D101', 'Mochila de mano','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDHuUj-vbkMUsGNS-m-5J9gDAIz9RQ5QgrUcI8B1yRF0enK2VxRZINIdBLoUqaCVA1l14&usqp=CAU', 125, 50, true, 1),
('product z', ' descripción of product z','https://image.png', 350.20,30, true, 3),
('product x', ' descripción of product x','https://image.png', 31,10, true, 3),
('Mochila Adidas Orange','multiples usos deportivo y escolar','https://www.adidaspadelargentina.com/wp-content/uploads/2019/11/mochila-barricade-orange-19-500x531.jpg', 560.99,75,true,2),
('Mochila de Viaje Pequeña', 'Para documentos ','https://image.png',50,130,true,1),
('Mochila de Viaje Mediana', 'Camping excurcion','https://image.png',120,130,true,1),
('Product B', 'Description del producto B','https://image.png',59.99,130,true,1),
('Product C', 'Description del producto C','https://image.png',59.99,130,true,1)


