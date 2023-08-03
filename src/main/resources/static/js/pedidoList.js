// Formateo de fecha
function formatDate(dateString) {
    const date = new Date(dateString);
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = date.getFullYear();
    return `${year}-${month}-${day}`;
}

// Crear una fila de la tabla
function createTableRow(pedido) {
    const newRow = document.createElement('tr');
    newRow.innerHTML = `
    <td>${pedido.id}</td>
    <td>${pedido.mesaId}</td>
    <td>${pedido.camareroId}</td>
    <td>${formatDate(pedido.fecha)}</td>
    <td>${pedido.total}</td>
    <td>
      <a href="#" data-pedido-id="${pedido.id}" data-lectura="false" class="fas fa-pen-to-square btn-editar"></a>
    </td>`;
    return newRow;
}

function cargarPedidos() {
    const tableBody = document.querySelector('#pedidosTable tbody');
    fetch('http://localhost:8080/api/pedidos')
        .then(response => {
            if (!response.ok) {
                throw new Error('La solicitud ha fallado.');
            }
            return response.json();
        })
        .then(data => {
            data.forEach(pedido => {
                const newRow = createTableRow(pedido);
                tableBody.appendChild(newRow);
            });
        })
        .catch(error => {
            console.error('Ha ocurrido un error:', error);
        });
}

// Cargar los datos al cargar la página

document.addEventListener("DOMContentLoaded", cargarPedidos);

document.addEventListener("click", function(event) {
    if (event.target.classList.contains("btn-editar")) {
        event.preventDefault();
        const pedidoId = event.target.getAttribute("data-pedido-id");
        editarPedido(pedidoId);
    }
});

function limpiarTabla() {
    const tableBody = document.querySelector('#pedidosTable tbody');
    tableBody.innerHTML = ''; // Vaciar el contenido del cuerpo de la tabla
}

// Función para redirigir a la página de edición del pedido usando el ID
    function editarPedido(id) {
        localStorage.setItem('esLectura', false);
        window.location.href = `/pedido/${id}`;
    }








