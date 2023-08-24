function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah')
                    .attr('src', e.target.result)
                    .height(200);
        };
        reader.readAsDataURL(input.files[0]);
        alert(reader.readAsDataURL(input.files[0]).toString());
    }
}

function addCard(formulario) {
    var valor = formulario.elements[0].value;
    var url = '/carrito/agregar';
    url = url + '/' + valor;
    $("#resultsBlock").load(url);
}
// rutinas.js

// Función para mostrar la imagen binaria en un elemento <img>
function mostrarImagenBinaria(imagenBinaria) {
    var imgElement = document.getElementById('imagenMostrada');
    
    // Convertir el array de bytes en una URL de datos (Data URL)
    var dataURL = 'data:image/png;base64,' + btoa(String.fromCharCode.apply(null, imagenBinaria));
    
    imgElement.src = dataURL;
    imgElement.style.display = 'block'; // Mostrar la imagen
}
