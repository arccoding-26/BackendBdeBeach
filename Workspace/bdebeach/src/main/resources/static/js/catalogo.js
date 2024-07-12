fetchProductos();

function fetchProductos(){

const requestOptions = {
  method: "GET",
  redirect: "follow"
};

fetch("/api/productos/", requestOptions)
  .then((response) => response.json())
  .then((result) => {console.log(result)
    result.forEach(producto=>{
      addItem(producto)
    });
  })
  .catch((error) => console.error(error));
}//fetchProductos

function addItem(item){
  let tonos=item.colores.split(",");
  console.log(tonos);
  let coloresHTML="";

  let tallas=item.tallas.split(",");
  console.log(tallas);
  let tallasHTML="";

  tonos.forEach(color => {
    coloresHTML += `
    <input class="form-check-input" type="radio" name="radioNoLabel" id="radioNoLabel1" value="" aria-label="..."  style ="background-color: ${color}">
    `
  }); 

  tallas.forEach(talla => {
    tallasHTML += `
    <input class="form-check-input" type="radio" name="radioNoLabel" 
    id="radioNoLabel1" value="" aria-label="..."  "> <span>${talla}</span>
    `
  }); 

  const itemsContainer = document.getElementById("list-items");
  itemsContainer.insertAdjacentHTML ("beforeend", 
    `<div class="col-md-4" id="id${item.id}">
    <div class="card mb-4 box-shadow">
      <img class="card-img-top" data-src="#" alt="Algo lindo" src="${item.img}" data-holder-rendered="true">
    <!-- <img class="card-img-top" data-src="" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22469%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20469%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_18feaf2c5a3%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A23pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_18feaf2c5a3%22%3E%3Crect%20width%3D%22469%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22156.99166870117188%22%20y%3D%22122.62000007629395%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">-->
      <div class="card-body">
        <p class="card-text">ID:${item.id} <br><strong>${item.nombre}</strong></p>
         <small class="card-text">${item.descripcion}</small>
          <br><br>
        <div class="tallas">
        ${tallasHTML}
        </div>
        <div class="colores">
        ${coloresHTML}
        </div>
          <div class="d-flex ms-auto">
           <small class="price" >$${item.precio} MXN</small>
           </div>
         
          <br><br>
          <div class="btn-group">
            <button type="button" class="btn btn-sm btn-outline-secondary"> Agregar al carrito </button>
            <!---<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>---> <!--Este es opcional-->
          </div>
      </div>
    </div>
  </div>`)

}



//  let items= [
//     {
//         "id": 1,
//         "title": "Top Mykonos",
//         "price": 750.00 ,
//         "description": "Top estilo bikini ajuble con tiras en la espalda y cuello",
//         "color": "#000000,#D9AD26",
//         "image": "./src/topmykonos1.jpg",
//         "talla": "S, M, L"
//         // "rating": {
//         //     "rate": 3.9,
//         //     "count": 120
//         // }
//     },

//      {
//         "id": 2,
//         "title": "Top Bora Bora",
//         "price": 650.00 ,
//         "description": "Top de diseño ajustable por el frente ",
//         "color": "#FFCBDB,#FF00FF,#77dde6,#FEF5E7,#F0B27A,#B695C0,#FF3339,#006341,#D9AD26",
//         "image": "./src/topborabora2.jpg",
//         "talla": "S, M, L"
//         // "rating": {
//         //     "rate": 3.9,
//         //     "count": 120
//         // }
//         },

//     {
//         "id": 3,
//         "title": "Top Bahamas",
//         "price": 950.00 ,
//         "description": "Top con escote en forma de U en la espalda",
//         "color": "#000000,#FEF5E7,#454B1B,#A04000",
//         "image": "./src/topbahamas3.jpeg",
//         "talla": "S, M, L"
//         // "rating": {
//         //     "rate": 3.9,
//         //     "count": 120
//         // }
//         },


//     {
//         "id": 4,
//         "title": "Falda Saint-Tropez",
//         "price": 1450.00 ,
//         "description": "Falda estilo sirena midi",
//         "color": "#000000,#D9AD26",
//         "image": "./src/faldasainttropez4.jpg",
//         "talla": "S, M, L"
//         // "rating": {
//         //     "rate": 3.9,
//         //     "count": 120
//         // }
//         },
    
//      {
//         "id": 5,
//         "title": "Mini Falda Saint Tropez",
//         "price": 990.00,
//         "description": "Falda estilo sirena corta",
//         "color": "#A04000,#FEF5E7,#f9e79f,#efac87,#f0b27a",
//         "image": "./src/minifaldasainttropez5.jpg",
//         "talla": "S, M, L"
//             // "rating": {
//             //     "rate": 3.9,
//             //     "count": 120
//             // }
//         },

//     {
//         "id": 6,
//         "title": "Falda Aruba",
//         "price": 1100.00 ,
//         "description": "Mini falda con ajuste en la cintura",
//         "color":  "#000000,#FEF5E7,#454B1B,#A04000",
//         "image": "./src/faldaaruba6.jpg",
//         "talla": "S, M, L"
//                 // "rating": {
//                 //     "rate": 3.9,
//                 //     "count": 120
//                 // }
//         },
        
//     // {
//     //     "id": 7,
//     //     "title": "Conjunto Mykonos",
//     //     "price": 3200.00,
//     //     "description": "El conjunto incluye 4 piezas: CROOPED, TOP BIKINI, PAREO Y BOTTOMS",
//     //     "color": "Dorado y negro",
//     //     "image": "./src/conjuntomykonos7.jpg",
//     //             // "rating": {
//     //             //     "rate": 3.9,
//     //             //     "count": 120
//     //             // }
//     //     },
      
        
        
//     // {
//     //     "id": 9,
//     //     "title": "Conjunto Pareo Grecia",
//     //     "price": 2950.00,
//     //     "description": "El cojunto incluye 3 piezas: TOP, PAREO Y BOTTOMS",
//     //     "color": "dorado y negro",
//     //     "image": "./src/conjuntopareogrecia9.jpg",
//     //             // "rating": {
//     //             //     "rate": 3.9,
//     //             //     "count": 120
//     //             // }
//     //     },
            
//     {
//         "id": 10,
//         "title": "Set Rio",
//         "price": 1000.00 ,
//         "description": "El set incluye 2 piezas: TOP Y BOTTOMS",
//         "color": "#FFCBDB, #FF00FF,#77dde6,#FEF5E7,#F0B27A,#B695C0,#FF3339,#006341,#D9AD26",
//         "image": "./src/bikinisetrio10.jpg",
//         "talla": "S, M, L"
//                 // "rating": {
//                 //     "rate": 3.9,
//                 //     "count": 120
//                 // }
//          },
//     {
//         "id": 11,
//         "title": "Set Bora Bora",
//         "price": 1200.00 ,
//         "description": "El set incluye 2 piezas: TOP Y BOTTOMS",
//         "color": "#FFCBDB, #FF00FF,#77dde6,#FEF5E7,#F0B27A,#B695C0,#FF3339,#006341,#D9AD26",
//         "image": "./src/bikinisetborabora11.jpg",
//         "talla": "S, M, L"
//                 // "rating": {
//                 //     "rate": 3.9,
//                 //     "count": 120
//                 // }
//         },
                
//     {
//         "id": 12,
//         "title": "Set Bikini Hellow Kitty",
//         "price": 2590.00,
//         "description": "El set incluye 3 piezas: TOP, BOTTOMS y PAREO",
//         "color": "#FFFFFF",
//         "image": "./src/bikinisethellokitty12.jpg",
//         "talla": "S, M, L"
//                 // "rating": {
//                 //     "rate": 3.9,
//                 //     "count": 120
//                 // }
//         },
//         {
//           "id": 8,
//           "title": "Conjunto Bora Bora",
//           "price": 1640.00,
//           "description": "El conjunto incluye 2 piezas: TOP Y FALDA MIDI con ajuste lateral",
//           "color": "#D9AD26,#000000,#FFFFFF",
//           "image": "./src/conjuntoborabora8.jpg",
//           "talla": "S, M, L"
//                   // "rating": {
//                   //     "rate": 3.9,
//                   //     "count": 120
//                   // }
//            },
// ];

// items.forEach(item => addItem(item));

// async function nuevaCard(){
//   const datos = await JSON.parse(localStorage.getItem("datos"));
//   if(datos){
//     datos.forEach(element => {
//        addItem(element)
//     });
//   }
 
// }

// window.addEventListener("load", function(event){
//   event.preventDefault();

//   if(this.localStorage.getItem("datos")!=null){
//     nuevaCard()
//   }
  
// });

