const URL_API = "http://localhost:8080/canasta/usuarios"

function getDataForm(e) {
    // Indicar al evento que no recargue página
    e.preventDefault()
    const form = e.target
    const usuario = {
        cedula: form.cedula.value,
        usuario: form.usuario.value,
        contrasena: form.contrasena.value,
        nombre: form.nombre.value,
        apellido: form.apellido.value,
        correo: form.email.value,
        telefono: form.telefono.value,
        rol: form.rol.value
    }
    sendDataCreate(usuario)
}

async function sendDataCreate(usuario) {
    // Enviar petición
    const resp = await fetch(URL_API, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(usuario)
    })
    const text = await resp.text()
    alert(text)
    if(text=="Usuario creado con exito"){
        window.location.href =('../vistasIniciales/inicio.html')
    }
}


