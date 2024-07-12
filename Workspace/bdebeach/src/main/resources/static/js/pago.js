let direccion = document.getElementById("direccion");
let municipio = document.getElementById("municipio");
let estado = document.getElementById("estado");
let codigoPostal = document.getElementById("codigoPostal");
let numeroCelular = document.getElementById("numeroCelular");

function validarNumeroCelular(){
    if(numeroCelular.value.length<10 || numeroCelular.value.length>10){
        alertValidacionesTexto.innerHTML+="- El <strong>teléfono</strong> debe tener al menos 10 caracteres.<br>";
        alertValidaciones.style.display="block";
        numeroCelular.style.border="solid red medium";
        numeroCelular.focus();
        return false;
    }
    if(isNaN(numeroCelular.value)){
        alertValidacionesTexto.innerHTML+="- El campo <strong>teléfono</strong> sólo puede contener <strong>números</strong>.";
        alertValidaciones.style.display="block";
        numeroCelular.style.border="solid red medium";
        numeroCelular.focus();
        return false;
    };
    if(numeroCelular.value == "0000000000"){
      alertValidacionesTexto.innerHTML+="- El campo <strong>teléfono</strong> no debe de contener sólo ceros.";
      alertValidaciones.style.display="block";
      numeroCelular.style.border="solid red medium";
      numeroCelular.focus();
      return false;
  };
  return true;
}

function validarMunicipio(){
    new RegExp("^[A-Za-z]{5,}$ ");
}

function validarCodigoPostal(){
    new RegExp("^\d{5}$");
}