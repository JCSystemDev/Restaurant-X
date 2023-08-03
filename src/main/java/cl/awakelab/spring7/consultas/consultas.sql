-- Consulta1

SELECT Plato.Nombre, Detalle_Pedido.Cantidad
FROM Plato
         JOIN Detalle_Pedido ON Plato.ID = Detalle_Pedido.Plato_ID
WHERE Detalle_Pedido.Pedido_ID = 1;

-- Consulta2

SELECT Mesa.ID, COUNT(Pedido.ID) AS Cantidad_Pedidos
FROM Mesa
         LEFT JOIN Pedido ON Mesa.ID = Pedido.Mesa_ID
GROUP BY Mesa.ID;

-- Consulta 3

SELECT Camarero.Nombre, SUM(Detalle_Pedido.Subtotal) AS Monto_Ventas
FROM Camarero
         LEFT JOIN Pedido ON Camarero.ID = Pedido.Camarero_ID
         LEFT JOIN Detalle_Pedido ON Pedido.ID = Detalle_Pedido.Pedido_ID
GROUP BY Camarero.Nombre
ORDER BY Monto_Ventas DESC;

-- Consulta 4

SELECT Plato.Nombre, SUM(Detalle_Pedido.Cantidad) AS Cantidad_Solicitudes
FROM Plato
         LEFT JOIN Detalle_Pedido ON Plato.ID = Detalle_Pedido.Plato_ID
GROUP BY Plato.ID, Plato.Nombre
ORDER BY Cantidad_Solicitudes DESC
    LIMIT 1;

-- Consulta 5

SELECT Plato.Nombre, SUM(Detalle_Pedido.Subtotal) AS Valor_Total
FROM Plato
         LEFT JOIN Detalle_Pedido ON Plato.ID = Detalle_Pedido.Plato_ID
GROUP BY Plato.ID, Plato.Nombre
ORDER BY Plato.Nombre ASC;