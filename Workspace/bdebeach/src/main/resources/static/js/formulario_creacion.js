let nombre = document.getElementById("nombre");
let descripcion = document.getElementById("descripcion");
let numeroDePiezas = document.getElementById("numeroDePiezas");
let precio = document.getElementById("precio");
let imagen = document.getElementById("imagen");
let btnCrear = document.getElementById("btnCrear"); 
let idRemove = document.getElementById("idRemove");
let btnRemove = document.getElementById("btnRemove");
let alertValidaciones = document.getElementById("alertValidaciones");
let alertValidacionesTexto = document.getElementById("alertValidacionesTexto");
let btnImagen = document.getElementById("btnImagen"); 
let tallaS=document.getElementById("tallaS");
let tallas=document.querySelectorAll(".talla");
let colorN=document.getElementById("#000000");
let colores=document.querySelectorAll(".colores");



let alertEnviadoTexto = document.getElementById("alertEnviadoTexto");
let alertEnviado = document.getElementById("alertEnviado");

let datos = new Array();
let arrTallas= new Array();
let arrColores= new Array();
let imagenValida =false;



function validarNombre(){
    if (nombre.value.length<3){
        alertValidacionesTexto.innerHTML="El <strong>nombre</strong> no es correcto <br/>";
        alertValidaciones.style.display="block";
        alertValidaciones.style.border="solid red medium";
        nombre.focus();
        nombre.style.border="solid red medium";
        return false;
    }// if
        return true;
}//validarNombre

function validarId (ID){
    let patronId = new RegExp("^[0-9]{3}$");
    if(ID.value.length==1){
        ID.value="00" + ID.value;       
    }else if(ID.value.length==2){
        ID.value="0" + ID.value;
    }
    if(patronId.test(ID.value)){
        return true;
    }else{
        alertValidacionesTexto.innerHTML +="El <strong>id</strong> no es válido. Debe contener 3 dígitos.<br/>";
        alertValidaciones.style.display="block";
        alertValidaciones.style.border="solid red medium";
        ID.focus();
        ID.style.border="solid red medium";
        return false;
    }//if
}

function validarTallas(){
    console.log(tallas.length);

    tallas.forEach((e)=>{
        if(e.checked){
            arrTallas.push(e.value);
          
        }
        });

    if(arrTallas.length==0){
        alertValidacionesTexto.innerHTML +="Elige alguna talla. <br/>";
        alertValidaciones.style.display="block";
        alertValidaciones.style.border="solid red medium";
        tallaS.focus();
        tallaS.style.border="solid red medium";
        return false;
            
   
    }else{
        return true;
    }
}
function validarColores(){
    
    colores.forEach((e)=>{
        if(e.checked){
            arrColores.push(e.value);
            
        }
        });
      
    if(arrColores.length==0){
        alertValidacionesTexto.innerHTML +="Elige algún color. <br/>";
        alertValidaciones.style.display="block";
        alertValidaciones.style.border="solid red medium";
        colorN.focus();
        colorN.style.border="solid red medium";
        return false;
            
   
    }else{
        return true;
    }
}

function validarDescripcion (){
    let patronDesc = new RegExp("^.{10,60}$");

    if(patronDesc.test(descripcion.value)){
        return true;
    }else{
        if(descripcion.value.length<10){
            alertValidacionesTexto.innerHTML +="Por favor, <strong>corrobora</strong> que la información sea correcta. <br/>";
        }else{
            alertValidacionesTexto.innerHTML +="Por favor, <strong>corrobora</strong> que la información no sobrepase los 60 caracteres. <br/>";
        }
        alertValidaciones.style.display="block";
        alertValidaciones.style.border="solid red medium";
        descripcion.focus();
        descripcion.style.border="solid red medium";
        return false;
   
    }//if
}

function validarPrecio(){
    let patronPrecio = new RegExp("^[0-9]{1,4}(\.[0-9]{1,2})?$");
    if(patronPrecio.test(precio.value)){
        return true;
    }else{
        alertValidacionesTexto.innerHTML +="El <strong>precio</strong> debe tener el siguiente formato: 1234.00 .<br/>";
        alertValidaciones.style.display="block";
        alertValidaciones.style.border="solid red medium";
        precio.focus();
        precio.style.border="solid red medium";
        return false;
    }//if
}



btnCrear.addEventListener("click", function(event){
    event.preventDefault();
    alertValidacionesTexto.innerHTML="";
    alertValidaciones.style.display="none";
    alertValidaciones.style.border="";
    nombre.style.border="";
    tallaS.style.border="";
    descripcion.style.border="";
    precio.style.border="";
    btnImagen.style.border="";
    colorN.style.border="";
    

    isValid = true;
     
     
    
     if(!imagenValida){
        alertValidacionesTexto.innerHTML +="Verifica que <strong>imagen</strong> sea CORRECTA .<br/>";
        alertValidaciones.style.display="block";
        alertValidaciones.style.border="solid red medium";
        btnImagen.focus();
        btnImagen.style.border="solid red medium";       
    }else if (imagenValida) {
        alertValidacionesTexto.innerHTML="";
        alertValidaciones.style.display="none";
        alertValidaciones.style.border="";
        btnImagen.style.border="";       
    }

     if (validarNombre() && validarDescripcion() && validarPrecio() && imagenValida && validarTallas() && validarColores() ){

        fetchCreacion();
        // let elemento = `{"id":"${id.value}",
        // "title":"${nombre.value}",
        // "description":"${descripcion.value}",
        // "talla":"${arrTallas}",
        // "color":"${arrColores}",
        // "price":${precio.value},
        // "image":"${imagen.src}"}`;
        // datos.push(JSON.parse(elemento));
        // console.log(datos);
        // localStorage.setItem("datos", JSON.stringify(datos));

        // id.value="";
        // nombre.value="";
        // descripcion.value="";
        // precio.value="";
        // imagen.src="";
        // arrTallas=[];
        // arrColores=[];
    
        // alertEnviadoTexto.innerHTML = "El producto ha sido agregado exitosamente.";
        // alertEnviado.style.display = "block"; 

    }

    


});
function fetchCreacion(){
    let token ="Bearer: " + localStorage.getItem("token");
    const myHeaders = new Headers();
myHeaders.append("Authorization", token);
myHeaders.append("Content-Type", "application/json");
const raw = JSON.stringify({
    "nombre":`${nombre.value}"`,
    "descripcion":`${descripcion.value}`,
    "colores":`${arrColores}`,
    "tallas": `${arrTallas}`,
    "img": `${imagen.src}`,
    "precio": `${precio.value}`
  });

const requestOptions = {
  method: "POST",
  headers: myHeaders,
  body: raw,
  redirect: "follow"
};

fetch("/api/productos/", requestOptions)
  .then((response) => response.json())
  .then((result) => {console.log(result)
   if(result.nombre){
    nombre.value="";
        descripcion.value="";
        precio.value="";
        imagen.src="";
        arrTallas=[];
        tallas.forEach(tallas => {
            tallas.checked = false;
        });
        arrColores=[];
            colores.forEach(colores => {
                colores.checked = false;

            });
        
        alertEnviadoTexto.innerHTML = "Se ha creado un nuevo producto";
        alertEnviado.style.display = "block"; 
  } else{
    alertValidacionesTexto.innerHTML ="El nombre de éste producto ya existe.<br/>";
    alertValidaciones.style.display="block";
  }
  })
  .catch((error) => console.error(error));

  
}


btnRemove.addEventListener("click", function(event){
    let isValid = true;
    event.preventDefault();
    alertValidacionesTexto.innerHTML="";
    alertValidaciones.style.display="none";
    alertValidaciones.style.border="";
    idRemove.style.border="";
    
    console.log(validarId(idRemove));
    
    
}, false);

window.addEventListener("load", function(event){
    event.preventDefault();
  
    if(this.localStorage.getItem("datos")!=null){
        datos = JSON.parse(localStorage.getItem("datos"));
    }
    
  });


/*Cloudinary*/
var myWidget = cloudinary.createUploadWidget({
    cloudName: 'dufshghoz', 
    uploadPreset: 'bdebeach', 
    }, 
    (error, result) => {
        if(!error && result && result.event==="success"){
            console.log("hecho", result.info);
            imagen.src= result.info.secure_url;
            imagenValida =true;
        } 
     });

btnImagen.addEventListener("click", function(){
    myWidget.open();
    }, false); 

     