const URL_API = "http://localhost:8080/canasta/productos"

async function comprar(e){
    e.preventDefault()
    const compraForm = e.target
    const    id= compraForm.idCompra.value
    const    cantidadCompra= compraForm.Cantidad.value
    const resp = await fetch(`${URL_API}/compra?id=${id}&cantidadCompra=${cantidadCompra}`, {method: 'PATCH'})
    const text = await resp.text()
    if (text== `true`) {
        alert("Compra realizada con éxito")
        window.location.href =('../clientes/comprar.html')        
    } else { 
        alert(text)
    }
}

async function vender(e){
    e.preventDefault()
    const compraForm = e.target
    const    id= compraForm.idVenta.value
    const    cantidadVenta= compraForm.Cantidad.value
    const resp = await fetch(`${URL_API}/venta?id=${id}&cantidadVenta=${cantidadVenta}`, {method: 'PATCH'})
    const text = await resp.text()
    if (text== `true`) {
        alert("Venta realizada con éxito")
        window.location.href =('../clientes/comprar.html')        
    } else { 
        alert(text)
    }
}

function mostrarProductos(items) {
    const tabla = document.getElementById('tbody')
    let tbody = ''
    for (let i = 0; i < items.length; i++) {
        const obj = items[i]
        tbody += `
        <tr clase=Principal>
        <td class="Principal">${obj.idProducto}</td>
        <td class="Principal">${obj.nombreProducto}</td>
        <td class="Principal">${obj.categoriaProducto}</td>
        <td class="Principal">${obj.precioProducto}</td>
        <td class="Principal">${obj.cantidadProducto}</td>
    </tr>
    `
    }
    tbody += ''
    tabla.innerHTML = tbody;
}

function seleccionProductos(items){
    const idProducto = document.getElementById('select')
    let body = ''
    for (let i = 0; i < items.length; i++) {
        const obj2 = items[i]
        body +=`
        <option value="${obj2.idProducto}"> Producto ${obj2.idProducto}</option>
        `
    }
    body += ''
    idProducto.innerHTML = body;
}

async function get_all_items (URL_API) {
    // Enviar petición al servidor
    const resp = await fetch(URL_API)
    const users = await resp.json()
    return users
}

async function main () {
    const items = await get_all_items(URL_API)
    mostrarProductos(items)
    seleccionProductos(items)
}

main()