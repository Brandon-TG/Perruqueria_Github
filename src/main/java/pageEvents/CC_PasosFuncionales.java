package main.java.pageEvents;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.pageObjects.CC_Localizadores;
import main.java.utils.GG_ElementFetch;
import main.java.utils.GG_Eventos;
import main.java.utils.GG_Utils;
//import main.java.utils.GG_Validations;
import test.java.carritocompras.CC_Test;

//En esta clase se ejecutan los Pasos de la P�gina.
public class CC_PasosFuncionales extends CC_Test {

	public CC_PasosFuncionales(WebDriver driver) {
		CC_Test.driver = driver;
	}
	
//	public static void buscar(String tratamiento, String xNumero) {
//		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
//
//		try {
//			
//			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);
//
//			WebDriverWait wait = new WebDriverWait(driver, 50);
//			GG_ElementFetch elementFetch = new GG_ElementFetch();
//
//			//Se escribe el tratamiento
//			WebElement inputTratamientoElement = elementFetch.getWebElement("XPATH", CC_Localizadores.inputTrato);
//			wait.until(ExpectedConditions.visibilityOf(inputTratamientoElement));
//			GG_Eventos.writeOnInput(inputTratamientoElement, tratamiento);
//			
//			Thread.sleep(5000);
//			
//			//Boton para buscar tratamiento
//			WebElement buttonBuscarElement = elementFetch.getWebElement("XPATH", CC_Localizadores.buttonBuscar);
//			wait.until(ExpectedConditions.elementToBeClickable(buttonBuscarElement));
//			GG_Eventos.clickButton(buttonBuscarElement);
//			
//			Thread.sleep(2000);
//
//		} catch (Exception e) {
//			GG_Utils.eventFailed(currentEvent, e.getMessage());
//
//		}
//	}
//	public static void agregarCarro(String xNumero) {
//		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
//
//		try {
//			
//			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);
//
//			WebDriverWait wait = new WebDriverWait(driver, 50);
//			GG_ElementFetch elementFetch = new GG_ElementFetch();
//			
//			//Boton para agregar al carro
//			WebElement buttonAgregarElement = elementFetch.getWebElement("XPATH", CC_Localizadores.buttonAgregarCarro);
//			wait.until(ExpectedConditions.elementToBeClickable(buttonAgregarElement));
//			GG_Eventos.clickButton(buttonAgregarElement);
//			
//			Thread.sleep(2000);
//
//		} catch (Exception e) {
//			GG_Utils.eventFailed(currentEvent, e.getMessage());
//
//		}
//	}		
//	public static void verCarro(String xNumero) {
//		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
//
//		try {
//			
//			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);
//
//			WebDriverWait wait = new WebDriverWait(driver, 50);
//			GG_ElementFetch elementFetch = new GG_ElementFetch();
//			
//			//Boton carro
//			WebElement buttonCarroElement = elementFetch.getWebElement("XPATH", CC_Localizadores.buttonCarro);
//			wait.until(ExpectedConditions.elementToBeClickable(buttonCarroElement));
//			GG_Eventos.clickButton(buttonCarroElement);
//			
//			Thread.sleep(2000);
//			
//			//Boton Menos
//			WebElement buttonMenosElement = elementFetch.getWebElement("XPATH", CC_Localizadores.buttonMenos);
//			wait.until(ExpectedConditions.elementToBeClickable(buttonMenosElement));
//			GG_Eventos.clickButton(buttonMenosElement);
//			
//			Thread.sleep(2000);
//
//		} catch (Exception e) {
//			GG_Utils.eventFailed(currentEvent, e.getMessage());
//
//		}
//	}

	public static void agregarCarro(String tratamiento, String tratamiento2, String xNumero) {
	    String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

	    try {
	        GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

	        WebDriverWait wait = new WebDriverWait(driver, 20);
	        GG_ElementFetch elementFetch = new GG_ElementFetch();

	        String xpath = String.format(CC_Localizadores.botonAgregarTratamientoPorNombre, tratamiento);
	        WebElement botonAgregar = elementFetch.getWebElement("XPATH", xpath);
	        Thread.sleep(1000); // opcional
	        wait.until(ExpectedConditions.elementToBeClickable(botonAgregar));
	        GG_Eventos.clickButton(botonAgregar);
	        
	        //Se agregan cuantas veces se quiera agregar un tratamiento, pero se debe agregar el string correspondiente
	        String xpath2 = String.format(CC_Localizadores.botonAgregarTratamientoPorNombre, tratamiento2);
	        WebElement botonAgregar2 = elementFetch.getWebElement("XPATH", xpath2);
	        wait.until(ExpectedConditions.elementToBeClickable(botonAgregar2));
	        GG_Eventos.clickButton(botonAgregar2);

	        Thread.sleep(1000); // opcional

	    } catch (Exception e) {
	        GG_Utils.eventFailed(currentEvent, e.getMessage());
	    }
	}
	
	public static void verCarro(String tratamiento, String accion, int cantidad, String xNumero) {
	    String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

	    try {
	        GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

	        WebDriverWait wait = new WebDriverWait(driver, 50);
	        GG_ElementFetch elementFetch = new GG_ElementFetch();

	        // Botón del carrito
	        WebElement buttonCarroElement = elementFetch.getWebElement("XPATH", CC_Localizadores.buttonCarro);
	        wait.until(ExpectedConditions.elementToBeClickable(buttonCarroElement));
	        GG_Eventos.clickButton(buttonCarroElement);

	        Thread.sleep(1000);

	        // Acción dentro del carrito
	        String xpathBoton = "";
	        switch (accion.toLowerCase()) {
	            case "suma":
	                xpathBoton = CC_Localizadores.buttonMass;
	                break;
	            case "resta":
	                xpathBoton = CC_Localizadores.buttonRest;
	                break;
	            case "eliminar":
	                xpathBoton = CC_Localizadores.buttonTrash;
	                break;
	            default:
	                throw new IllegalArgumentException("Acción no válida: " + accion);
	        }

	        // Ejecutar acción la cantidad de veces necesaria
	        if (accion.equalsIgnoreCase("eliminar")) {
	            WebElement boton = elementFetch.getWebElement("XPATH", xpathBoton);
	            wait.until(ExpectedConditions.elementToBeClickable(boton));
	            GG_Eventos.clickButton(boton);
	        } else {
	            for (int i = 0; i < cantidad; i++) {
	                WebElement boton = elementFetch.getWebElement("XPATH", xpathBoton);
	                wait.until(ExpectedConditions.elementToBeClickable(boton));
	                GG_Eventos.clickButton(boton);
	                Thread.sleep(500);
	            }
	        }

	        Thread.sleep(1000);

	    } catch (Exception e) {
	        GG_Utils.eventFailed(currentEvent, e.getMessage());
	    }
	}

	
	
		public static void procederCompra(String nombre, String date, String profesional, String petName, 
									String petAge, String edadUnidad, String raza, String xNumero) {
		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();

		try {
			GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);

			WebDriverWait wait = new WebDriverWait(driver, 50);
			GG_ElementFetch elementFetch = new GG_ElementFetch();

			// Botón Finalizar Reserva
			WebElement buttonFinElement = elementFetch.getWebElement("XPATH", CC_Localizadores.buttonFin);
			wait.until(ExpectedConditions.elementToBeClickable(buttonFinElement));
			GG_Eventos.clickButton(buttonFinElement);

			// Nombre del cliente
			WebElement inputNombreElement = elementFetch.getWebElement("XPATH", CC_Localizadores.inputNombre);			
			wait.until(ExpectedConditions.visibilityOf(inputNombreElement));
			GG_Eventos.writeOnInput(inputNombreElement, nombre);

			// Fecha
			WebElement inputDateElement = elementFetch.getWebElement("XPATH", CC_Localizadores.inputDate);			
			wait.until(ExpectedConditions.visibilityOf(inputDateElement));
			GG_Eventos.writeOnInput(inputDateElement, date);

			// Profesional
			WebElement selectProfesionalElement = elementFetch.getWebElement("XPATH", CC_Localizadores.selectProfesional);
			wait.until(ExpectedConditions.visibilityOf(selectProfesionalElement));
			GG_Eventos.selectByText(selectProfesionalElement, profesional);

			// Nombre de la mascota
			WebElement inputPetNameElement = elementFetch.getWebElement("XPATH", CC_Localizadores.inputPetName);			
			wait.until(ExpectedConditions.visibilityOf(inputPetNameElement));
			GG_Eventos.writeOnInput(inputPetNameElement, petName);

			// Edad de la mascota
			WebElement inputPetAgeElement = elementFetch.getWebElement("XPATH", CC_Localizadores.inputPetAge);			
			wait.until(ExpectedConditions.visibilityOf(inputPetAgeElement));
			GG_Eventos.writeOnInput(inputPetAgeElement, petAge);

			// Unidad de edad (meses/años)
			WebElement selectPetAgeElement = elementFetch.getWebElement("XPATH", CC_Localizadores.selectPetAge);
			wait.until(ExpectedConditions.visibilityOf(selectPetAgeElement));
			GG_Eventos.selectByText(selectPetAgeElement, edadUnidad);

			// Raza de la mascota
			WebElement inputPetRazaElement = elementFetch.getWebElement("XPATH", CC_Localizadores.inputPetRaza);			
			wait.until(ExpectedConditions.visibilityOf(inputPetRazaElement));
			GG_Eventos.writeOnInput(inputPetRazaElement, raza);
			
			// Filnalizar compra
			WebElement finalizarReserva = elementFetch.getWebElement("XPATH", CC_Localizadores.btnFinalizarReserva);			
			wait.until(ExpectedConditions.visibilityOf(finalizarReserva));
			GG_Eventos.clickButton(finalizarReserva);
			
			//Aceptar el Alert
			
			try {
			    // Esperar a que aparezca el alert
			    WebDriverWait wait2 = new WebDriverWait(driver, 5000);
			    wait2.until(ExpectedConditions.alertIsPresent());

			    // Cambiar el foco al alert
			    Alert alert = driver.switchTo().alert();

			    // Capturar texto (opcional)
			    String texto = alert.getText();
			    System.out.println("Alert: " + texto);

			    // Aceptar el alert
			    alert.accept();
			    
			} catch (TimeoutException e) {
			    System.out.println("No apareció ningún alert.");
			}

		} catch (Exception e) {
			GG_Utils.eventFailed(currentEvent, e.getMessage());
		}
	}
	
		public static void volverHome(String xNumero) {
		String currentEvent = new Throwable().getStackTrace()[0].getMethodName();
		
				try {
					
					GG_Utils.outputInfo(xNumero + ") PASO FUNCIONAL iniciado: " + currentEvent);
		
					WebDriverWait wait = new WebDriverWait(driver, 50);
					GG_ElementFetch elementFetch = new GG_ElementFetch();
					
					//Boton volver nolsa de compras
					WebElement volverBolsa = elementFetch.getWebElement("XPATH", CC_Localizadores.volverBolsa);
					wait.until(ExpectedConditions.elementToBeClickable(volverBolsa));
					GG_Eventos.clickButton(volverBolsa);
					
					Thread.sleep(2000);
					
					//Boton volver catalogo
					WebElement volverCatalogo = elementFetch.getWebElement("XPATH", CC_Localizadores.volverCatalogo);
					wait.until(ExpectedConditions.elementToBeClickable(volverCatalogo));
					GG_Eventos.clickButton(volverCatalogo);
					
					Thread.sleep(2000);
		
				} catch (Exception e) {
					GG_Utils.eventFailed(currentEvent, e.getMessage());
		
				}
			}
		
}
