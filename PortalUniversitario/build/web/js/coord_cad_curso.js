// JavaScript Document

function checkFields() {
	var retorno = true;
	var tamanho;
	tamanho = document.forms.item(0).elements.length;
	for (i=0; i<(tamanho-2); i++) {
		if (document.forms.item(0).elements.item(i).value=="") {
			window.alert("O campo "+ document.forms.item(0).elements.item(i).name +" está vazio! Por favor, preencha este campo.");
			retorno=false;
			break;
		}
	}
	return retorno;
}