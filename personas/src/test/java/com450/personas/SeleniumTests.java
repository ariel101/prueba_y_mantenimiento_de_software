package com450.personas;

import com450.personas.models.Personas;
import com450.personas.services.PersonaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumTests {

    @Autowired
    private TestDataService testDataService;
    @Autowired
    private PersonaService registroService;
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Configurar la propiedad del sistema para ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "F:/com450/chromedriver");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testFormSubmission() {

        List<Personas> personas = testDataService.obtenerDatosDePrueba();
        for (Personas persona : personas) {
            // Navegar a la página del formulario
            driver.get("http://localhost:8080/formulario");

            // Llenar el formulario con datos de prueba
            WebElement nameField = driver.findElement(By.cssSelector("input#nombre"));
            WebElement lastNameField = driver.findElement(By.cssSelector("input#apellido"));
            WebElement professionField = driver.findElement(By.cssSelector("input#profesion"));
            //WebElement emailField = driver.findElement(By.cssSelector("input#correo"));



            nameField.sendKeys(persona.getNombre());
            lastNameField.sendKeys(persona.getApellido());
            professionField.sendKeys(persona.getProfesion());
            //emailField.sendKeys(persona.getCorreo());

            /*if (persona.getNombre() == null || persona.getNombre().isEmpty() ||
                    persona.getApellido() == null || persona.getApellido().isEmpty() ||
                    persona.getProfesion() == null || persona.getProfesion().isEmpty() ||
                    persona.getCorreo() == null || persona.getCorreo().isEmpty()) {
                System.out.println("Datos incompletos para persona: " + persona);
                continue; // Saltar al siguiente registro
            }

             */

            //nameField.sendKeys("Ariel");
            //lastNameField.sendKeys("Doe");
            //professionField.sendKeys("Engineer");
            //emailField.sendKeys("john.doe@example.com");

            WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
            submitButton.click();
            registroService.guardarModificar(persona);
        }


    }
}

