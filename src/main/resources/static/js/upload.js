var form = document.getElementById("uploadForm");
var mensagem = document.getElementById("mensagem");

form.addEventListener("submit", function(event) {
    event.preventDefault();

    var formData = new FormData(form);


    fetch("cnab/upload-file", {
        method: "POST",
        body: formData
    })
    .then(function(response){
        if(response.ok) {
            return response.text();
        } else{
            throw new Error("Erro no upload");
        }
    })
    .then(function(data) {
        mensagem.textContent = "Sucesso! " + data;
        mensagem.style.color = "green";
    })
    .catch(function(error) {
        mensagem.textContent = "ERRO " + error;
        mensagem.style.color = "red";
        console.error(error);
    });

});