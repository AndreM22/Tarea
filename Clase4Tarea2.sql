select empleado.email as correo from empleado
inner join usuario on empleado.idempleado=usuario.idempleado and usuario.activo; 