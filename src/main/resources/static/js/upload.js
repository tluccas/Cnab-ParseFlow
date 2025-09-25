var form = document.getElementById("uploadForm");
var mensagem = document.getElementById("mensagem");

form.addEventListener("submit", function(event) {
    event.preventDefault();

    var formData = new FormData(form);


    fetch("cnab/upload-file", {
        method: "POST",
        body: formData
    })
        .then(function(response) {
            response.text().then(function(text) {
                if(response.ok) {
                    mensagem.textContent = "Sucesso! " + text;
                    mensagem.style.color = "green";
                } else {
                    mensagem.textContent = "ERRO: " + text;
                    mensagem.style.color = "red";
                }
            });
        })
        .catch(function(error) {
            mensagem.textContent = "ERRO de conexão: " + error;
            mensagem.style.color = "red";
            console.error(error);
        });

});