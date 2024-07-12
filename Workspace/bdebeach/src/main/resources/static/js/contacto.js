//variables de inputs
let txtNombre = document.getElementById("nombre");
let txtEmail = document.getElementById("email");
let txtTelefono = document.getElementById("telefono");
let txtMensaje = document.getElementById("mensaje");

let alertValidaciones = document.getElementById("alertValidaciones");
let alertValidacionesTexto = document.getElementById("alertValidacionesTexto");
let alertEnviadoTexto = document.getElementById("alertEnviadoTexto");
let alertEnviado = document.getElementById("alertEnviado");

let isValid = true;

function validarNombre(){
    if(txtNombre.value.length<3){
        alertValidacionesTexto.innerHTML="- El <strong>Nombre</strong> debe tener al menos 3 caracteres.<br>";
        alertValidaciones.style.display="block";
        txtNombre.style.border="solid red medium";
        txtNombre.focus();
        return false;
      
    }
    return true;
}

function validarTelefono(){
  
  const patron = new RegExp ("^[1-9][0-9]{9}$");
  if (patron.test(txtTelefono.value)) {
    return true;
  } else {
    alertValidacionesTexto.innerHTML+="- El campo <strong>Télefono</strong> no debe de contener sólo ceros.";
      alertValidaciones.style.display="block";
      txtTelefono.style.border="solid red medium";
      txtTelefono.focus();
    return false;
  }
  
}

function validarMensaje(){
    const mensaje = txtMensaje.value.trim();
    if (mensaje.length === 0 || mensaje.length > 1000){
        alertValidacionesTexto.innerHTML="- Tu opinión es muy valiosa, por favor no excedas los 1000 carácteres";
        alertValidaciones.style.display="block";
        txtMensaje.style.border="solid red medium";
        txtMensaje.focus();
        return false;
    }
    return true;
}
function errorEmail(){
    alertValidacionesTexto.innerHTML="- Verifica que tu <strong>Email</strong> sea correcto.";
    alertValidaciones.style.display="block";
    txtEmail.style.border="solid red medium";
}

function validarEmail(){
    const email = txtEmail.value;
    const atIndex = email.indexOf("@");
    const [usuario, dominio] = email.split("@");
    const dotIndex = email.indexOf(".");
    const invalidChars = [' ', '!', '#', '$', '%', '&', '*', '(', ')', '+', ',', '/', ':', ';', '<', '=', '>', '?', '[', '\\', ']', '^', '`', '{', '|', '}', '~'];
    if(txtEmail.value.length==0){
        errorEmail();
        txtEmail.focus();
        return false;
    }
    if(atIndex<=0 || atIndex==(email.length-1)){
        errorEmail();
        txtEmail.focus();
        return false;
    };
    if(dotIndex<=0 || dotIndex==(dominio.length-1)){
        errorEmail();
        txtEmail.focus();
        return false;
    };
    if(dominio.includes("..")){
        errorEmail();
        txtEmail.focus();
        return false;
    };
    for(let char of invalidChars){
        if(email.includes(char)){
          txtEmail.focus();
            return false;
        }
    }
    return true;
}

const btn = document.getElementById('button');

document.getElementById('form')
 .addEventListener('submit', function(event) {
   event.preventDefault();
   alertValidacionesTexto.innerHTML="";
    alertValidaciones.style.display="none";
    txtNombre.style.border="";
    txtTelefono.style.border="";
    txtMensaje.style.border="";
    txtEmail.style.border="";
    alertEnviadoTexto.innerHTML="";
    alertEnviado.style.display="none";

    if(validarNombre() && validarEmail() && validarTelefono() && validarMensaje()){
        const serviceID = 'default_service';
        const templateID = 'template_61pzqvk';

   emailjs.sendForm(serviceID, templateID, this)
    .then(() => {
     txtNombre.value="";
     txtTelefono.value="";
     txtMensaje.value="";
     txtEmail.value="";
     

     alertEnviadoTexto.innerHTML = "El mensaje ha sido enviado exitosamente.";
     alertEnviado.style.display = "block";
    }, (err) => {
      alert(JSON.stringify(err));
    });
    }
});






