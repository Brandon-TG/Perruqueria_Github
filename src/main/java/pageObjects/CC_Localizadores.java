package main.java.pageObjects;
//Dentro de esta clase se almacenaran todos los localizadores que se ocuparan.
public interface CC_Localizadores {

	//Perruqueria
	String inputTrato = "//*[@id=\"search-input\"]";
	String buttonBuscar = "//*[@id=\"search-container\"]/button";
	String buttonAgregarCarro = "//*[@id=\"catalog-container\"]/div/button";
	String buttonCarro = "//*[@id=\"main-content\"]/button";
	
	//CarritoCompra
	String buttonMenos = "/html/body/main/div/div/div/button[1]";
	String buttonMas = "/html/body/main/div/div/div/button[2]";
	String buttonEliminar = "/html/body/main/div/div/div/button[3]";
	String item = "/html/body/main[@id='main-content']/div[@id='cart-container2']/div[@id='cart-item-container']\r\n";
	
	//Perruqueria2
	String botonAgregarTratamientoPorNombre = "//div[@class='service-card'][.//h3[text()='%s']]//button";
	String bolsa = "//button[contains(text(), 'Bolsa de Compras')]";
	String buttonMass = "//div[@id='cart-item-container']//button[text()='+']";
	String buttonRest = "//div[@id='cart-item-container']//button[text()='-']";
	String buttonTrash = "//div[@id='cart-item-container']//button[i[contains(@class, 'fa-trash-alt')]]";	
	String buttonFin = "//button[text()='Ir a la Finalización de la Reserva']";

	//Formulario
	String inputNombre = "//*[@id=\"reservation-form\"]/input[1]";
	String inputDate = "//*[@id=\"reservation-form\"]/input[2]";
	String selectProfesional = "//*[@id=\"reservation-form\"]/select[1]";
	String inputPetName = "//*[@id=\"reservation-form\"]/input[3]";
	String inputPetAge = "//*[@id=\"reservation-form\"]/input[4]";
	String selectPetAge = "//*[@id=\"reservation-form\"]/select[2]";
	String inputPetRaza = "//*[@id=\"reservation-form\"]/input[5]";
	String btnFinalizarReserva = "//*[@id=\"reservation-form\"]/button";
	
	//Home
	
	String volverBolsa = "//*[@id=\"main-content\"]/button";
	String volverCatalogo = "//*[@id=\"main-content\"]/button[1]";

	
}
