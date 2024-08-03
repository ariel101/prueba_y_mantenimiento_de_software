package com.com470.seleniumapp1.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterMethod;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
public class LoginPage {
    @Autowired
    WebDriver driver;

    public void writeUsername(String usuario, String password) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).sendKeys(usuario);
        driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).sendKeys(password);
        driver.findElement(By.name("submit")).click();
        //assertTrue()
        Thread.sleep(1000);
    }

    public void navigate(){
        driver.navigate().to("http://demo.guru99.com/test/newtours/");
    }


    public void validar() throws InterruptedException {
        assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[12]/td/table/tbody/tr/td")).getText().contains("Business Travel @ About.com\n" +
                "Salon Travel"));
        // validar footer
        assertTrue(driver.findElement(By.className("footer")).getText().contains("© 2005, Mercury Interactive (v. 011003-1.01-058)"));

        Thread.sleep(1000);
    }
    public void registerNewUser(String usuario, String password) throws InterruptedException {
        driver.findElement(By.linkText("REGISTER")).click();

        driver.findElement(By.name("firstName")).sendKeys("John");
        driver.findElement(By.name("lastName")).sendKeys("Doe");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("userName")).sendKeys("john.doe@example.com");
        driver.findElement(By.name("address1")).sendKeys("123 Main St");
        driver.findElement(By.name("city")).sendKeys("Anytown");
        driver.findElement(By.name("state")).sendKeys("Anystate");
        driver.findElement(By.name("postalCode")).sendKeys("12345");
        driver.findElement(By.name("country")).sendKeys("UNITED STATES");
        driver.findElement(By.name("email")).sendKeys("pepito123");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("confirmPassword")).sendKeys("password");
        driver.findElement(By.name("submit")).click();

        // Verificar que el usuario se ha registrado correctamente
        String expectedTitle = "Register: Mercury Tours";
        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains(expectedTitle), "Registration failed!");

        Thread.sleep(1000);
    }

    public void registrarVueloIdaVuelta() throws InterruptedException {
        driver.findElement(By.linkText("Flights")).click();
        // Llenar formulario de vuelo
        driver.findElement(By.cssSelector("input[value='roundtrip']")).click();
        driver.findElement(By.cssSelector("select[name='passCount'] > option[value='2']")).click();
        driver.findElement(By.cssSelector("select[name='fromPort'] > option[value='New York']")).click();
        driver.findElement(By.cssSelector("select[name='toPort'] > option[value='London']")).click();
        driver.findElement(By.cssSelector("select[name='toDay'] > option[value='24']")).click();
        driver.findElement(By.cssSelector("input[value='Business']")).click();
        Thread.sleep(2000);

        // Seleccionar Boton continue
        driver.findElement(By.name("findFlights")).click();

        // Validar mensaje respuesta
        assertTrue(driver.findElement(By.cssSelector(
                ("body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr:nth-child(1) > td > p > font > b > font:nth-child(1)")
        )).getText().contains("After flight finder - No Seats Avaialble"));
        Thread.sleep(1000);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

