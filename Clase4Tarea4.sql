select sum(precio) from venta
inner join empleado on (empleado.idempleado=venta.idempleado and empleado.nombre='EMILIO');