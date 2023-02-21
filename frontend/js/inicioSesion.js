const URL_API = "http://localhost:8080/canasta/usuarios/login"

async function login(e) {
    e.preventDefault()
    const form = e.target
    const usuario = form.user.value
    const contrasena = form.contra.value
    const resp = await fetch(`${URL_API}?usuario=${usuario}&contrasena=${contrasena}`)
    const text = await resp.text()
    
    if (text== `{"Autentificado con exito":true}`) {
        window.location.href =('../clientes/inicioBienvenida.html')        
    } else { 
        alert("Usuario y/o contraseña incorrecta")
    }
}