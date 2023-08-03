// Función para formatear la fecha en formato 'yyyy-MM-dd'
function formatDate(dateString) {
    const date = new Date(dateString);
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = date.getFullYear();
    return `${year}-${month}-${day}`;
}


// Función para obtener y mostrar los detalles de pedido por su ID
function Pedido(id) {
    fetch(`http://localhost:8080/api/pedidos/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('La solicitud ha fallado.');
            }
            return response.json();
        })
        .then(pedido => {
            if (localStorage.getItem('esLectura') === 'true') {
                // Los detalles son de solo lectura, bloquear los campos
                document.getElementById('id').readOnly = true;
                document.getElementById('mesaId').readOnly = true;
                document.getElementById('camareroId').readOnly = true;
                document.getElementById('fecha').readOnly = true;
                document.getElementById('total').readOnly = true;

                // Ocultar el botón de guardar y mostrar el botón de modificar
                document.getElementById('guardarBtn').classList.add('d-none');
                document.getElementById('modificarBtn').classList.add('d-none');
            } else {
                // Los detalles son editables, no bloquear los campos
                document.getElementById('id').readOnly = false;
                document.getElementById('mesaId').readOnly = false;
                document.getElementById('camareroId').readOnly = false;
                document.getElementById('fecha').readOnly = false;
                document.getElementById('total').readOnly = false;

                // Ocultar el botón de modificar y mostrar el botón de guardar

                document.getElementById('guardarBtn').classList.add('d-none');
                document.getElementById('modificarBtn').classList.remove('d-none');
            }

            // Mostrar los detalles de la capacitación en el formulario
            document.getElementById('id').value = pedido.id;
            document.getElementById('mesaId').value = pedido.mesaId;
            document.getElementById('camareroId').value = pedido.camareroId;
            document.getElementById('fecha').value = formatDate(pedido.fecha);
            document.getElementById('total').value = pedido.total;

        })
        .catch(error => {
            console.error('Ha ocurrido un error:', error);
        });
}

// Función para actualizar una capacitación existente
function ActualizarPedido(data) {
    fetch('http://localhost:8080/api/pedidos/update', {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al actualizar los datos de la capacitación.');
            }
            return response.json();
        })
        .then(pedidoDTO => {
            // Manejo de la respuesta
            console.log('PedidoDTO actualizada:', pedidoDTO);
            // Redirigir a la página de pedidoList después de actualizar correctamente
            window.location.href = '/';
            // Aquí puedes realizar acciones adicionales con la respuesta del servidor si es necesario
        })
        .catch(error => {
            console.error('Error en la solicitud de actualización:', error);
        });
}