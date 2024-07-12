let barraNavegacion = document.getElementById("barraNavegacion"); //

let footer =document.getElementById("footer");//


barraNavegacion.insertAdjacentHTML("beforeend",
    `
    <nav class="navbar navbar-expand-md fixed-top bg-body-tertiary">
                  <div class="container-fluid">
                    <a class="navbar-brand" href="./index.html"><img src="./src/LogoSinFondo.png" alt="LogoNavegador" width="150px"></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarScroll">
                      <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"  style="--bs-scroll-height: 100px;">

                        <li class="nav-item">
                          <a class="nav-link active" aria-current="page" href="./index.html">Inicio</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link active" aria-current="page" href="./catalogo.html">Catálogo</a>
                        </li>

                        <li class="nav-item dropdown" ">
                          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Más
                          </a>
                          <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="./conocenos.html">Conócenos</a></li>
                            <li><a class="dropdown-item" href="./contacto.html">Contáctanos</a></li>
                            <li><a class="dropdown-item" href="./formulario_creacion.html">Crear nuevos productos</a></li>
                          </ul>
                        </li>
                      </ul>
                      <form class="d-flex ms-auto" role="search">
                        <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Buscar">
                        <button class="btn btn-outline navbarbtn" type="submit"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                          <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                        </svg></button>
                      </form>
                      <ul class="navbar-nav p-2 my-2 my-lg-0 navbar-nav-scroll " id="listaMenu" style="--bs-scroll-height: 100px;">
                        <li class="nav-item dropdown" id="sesion">
                          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                              <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                            </svg>Sesión
                          </a>
                          <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="./IniSesion.html">Iniciar Sesión</a></li>
                            <li><a class="dropdown-item" href="./registro.html">Regístrate</a></li>
                          </ul>
                        </li>  
                        <li class="nav-item dropdown" style="display:none" id="icono">
                          <a class="nav-link dropdown-toggle" href="#" id="usuario" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                              <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
                            </svg>
                          </a>
                          <ul class="dropdown-menu" >
                            <li><a class="dropdown-item" href="./IniSesion.html" id="cerrar"  role="button" >Cerrar Sesión</a></li>
                        
                          </ul>
                        </li>  
                        <li class="nav-item ">
                          <a class="nav-link active" aria-current="page" href="carrito.html"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-fill" viewBox="0 0 16 16">
                          <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5M5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4m7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4m-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2m7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2"/>
                        </svg> Carrito</a>
                        </li>
                      </ul>
                      
                    </div>
                  </div>
                </nav>
    `
);


footer.insertAdjacentHTML("beforeend",
  `<img src="./src/LogoFooter.jpeg" alt="Logo Pie de página"  class="d-block mx-auto mb-4" width="200px">
  <ul class="nav justify-content-center  ">
      <li class="nav-item">
          <a href="https://www.facebook.com/BdeBeach1" target="_blank" class="nav-link px-2 text-body-secondary-ligth footer-a"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-facebook" viewBox="0 0 16 16">
              <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951"/>
            </svg> Facebook</a>
      </li>
      <li class="nav-item">
          <a href="https://www.instagram.com/bde.beach/" target="_blank" class="nav-link px-2 text-body-secondary-ligth footer-a"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-instagram" viewBox="0 0 16 16">
              <path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.9 3.9 0 0 0-1.417.923A3.9 3.9 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.9 3.9 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.9 3.9 0 0 0-.923-1.417A3.9 3.9 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599s.453.546.598.92c.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.5 2.5 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.5 2.5 0 0 1-.92-.598 2.5 2.5 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233s.008-2.388.046-3.231c.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92s.546-.453.92-.598c.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92m-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217m0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334"/>
            </svg> Instagram</a>
      </li>
      
  </ul>
  <ul class="nav justify-content-center border-bottom pb-3 mb-3">

      <li class="nav-item">
          <a href="./index.html" class="nav-link px-2 text-body-secondary-ligth footer-a">Inicio</a>
      </li>
      <li class="nav-item">
          <a href="./contacto.html" class="nav-link px-2 text-body-secondary-ligth footer-a">Contáctanos</a>
      </li><li class="nav-item">
          <a href="./conocenos.html" class="nav-link px-2 text-body-secondary-ligth footer-a">Conócenos</a>
      </li>
      
  </ul>
  <p class="text-center text-body-light footer-p">B de Beach   |   Marca registrada &#169  |   2024</p>`
)
let usuario=document.getElementById("usuario");
let icono=document.getElementById("icono");
let sesion=document.getElementById("sesion");
let cerrar=document.getElementById("cerrar");

window.addEventListener("load", function(event){
  event.preventDefault();
  if(this.localStorage.getItem("usuarioActual")!=null){
    usuarioActual=localStorage.getItem("usuarioActual");
    sesion.style.display="none";
    usuario.innerHTML+=usuarioActual;
    icono.style.display="block";
  } else if(this.localStorage.getItem("token")!=null){
	 sesion.style.display="none";
    usuario.innerHTML+="¡Hola!";
    icono.style.display="block";
  }

  })

cerrar.addEventListener("click", function(event){
  event.preventDefault();
  sesion.style.display="block";
  icono.style.display="none";
  localStorage.removeItem("usuarioActual");
  localStorage.removeItem("token");

  setTimeout(function(){
    window.location.href = "./IniSesion.html";
},100);
})