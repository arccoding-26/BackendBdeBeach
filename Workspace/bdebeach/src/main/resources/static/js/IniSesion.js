let email = document.getElementById("email");
let contraseña = document.getElementById("contraseña");
let button = document.getElementById("button");
let alertEnviado = document.getElementById("alertEnviado");
let alertEnviadoTexto = document.getElementById("alertEnviadoTexto");
let alertValidaciones = document.getElementById("alertValidaciones");
let alertValidacionesTexto = document.getElementById("alertValidacionesTexto");

button.addEventListener("click", function(event){
    event.preventDefault();
    alertValidacionesTexto.innerHTML= "";
    alertValidaciones.style.display= "none";
    alertEnviadoTexto.innerHTML= "";
    alertEnviado.style.display= "none";
    email.style.border= "";
    contraseña.style.border= "";
    console.log(validacion());
    if(validacion()){
       fetchLogin();
      
    }
});

function fetchLogin(){
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "correo": `${email.value}`,
        "contrasena": `${contraseña.value}`
    });

    const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("/api/login/", requestOptions)
        .then(response =>{ response.json()
        .then(result => {console.log(result)
         if(result.accessToken){
            localStorage.setItem('token', result.accessToken)
              alertEnviadoTexto.innerHTML = "Se inició sesión";
             alertEnviado.style.display = "block";

        setTimeout(function () {
            window.location.href = "./index.html";
        });
         }  else{
            mensajeError();
         } 
       
})
        .catch(
            (error) => {console.error(error);} );
})

}//fetchLogin

// function fetchUsuario(){
//     const myHeaders = new Headers();
//     myHeaders.append("Authorization", "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhcm9ucm9zYXMwNDA5QGdtYWlsLmNvbSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzIwNjU2NDcwLCJleHAiOjE3MjA2OTI0NzB9._IsgTAJlsWgWUCOj-j8ymtpPwNZFS8oLYhp1MW-0vh8");
    
//     const requestOptions = {
//       method: "GET",
//       headers: myHeaders,
//       redirect: "follow"
//     };
    
//     fetch("http://localhost:8088/api/usuarios/", requestOptions)
//       .then((response) => response.text())
//       .then((result) => console.log(result))
//       .catch((error) => console.error(error));
// }
function validacion(){
    let valido = false;

    if(email.value.length == 0 || contraseña.value.length == 0){
        mensajeError();
        email.focus();
        return false;
    }else{
        return true;
    }

    // if(contraseña.value.length == 0){
    //     mensajeError();
    //     contraseña.focus();
    // }

    // usuarios.forEach(usuario => {

    //     if(usuario.email == email.value && usuario.contraseña == contraseña.value){
    //         let nuevoElemento = `{"nombre" : "${usuario.nombre}", "email" : "${usuario.email}"}`;
    //         localStorage.setItem("usuarioActual", nuevoElemento);
    //         valido = true;
    //     }
    // });
    // if(valido){
    //     return valido;
    // }else{
    //     mensajeError();
    //     return valido;
    // }
}

function mensajeError(){
    alertValidacionesTexto.innerHTML= "El campo de la contraseña y/o correo son incorrectos.<br>Verifica la información.";
    alertValidaciones.style.display= "block";
}

// window.addEventListener("load", function(event){
//     event.preventDefault();
//     if(this.localStorage.getItem("usuarios")!=null){
//         usuarios=JSON.parse(localStorage.getItem("usuarios"));
//     }
// })
