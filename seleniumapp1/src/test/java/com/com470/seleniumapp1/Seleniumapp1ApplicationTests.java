package com.com470.seleniumapp1;

import com.com470.seleniumapp1.pageobjects.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Seleniumapp1ApplicationTests {
	@Autowired
	LoginPage loginPage;

	@Test
	void LogComoAdmin() throws InterruptedException {
		loginPage.navigate();
		loginPage.writeUsername("admin","admin");
		//loginPage.navigate();
	}

	@Test
	void validarPage() throws  InterruptedException{
		loginPage.navigate();
		loginPage.validar();

	}
	@Test
	void registrarUsuario() throws InterruptedException{
		loginPage.navigate();
		loginPage.registerNewUser("john.doe@example.com","password");
		loginPage.navigate();
	}

	@Test
	void  RegistrarVueloIdaVuelta() throws InterruptedException {
		loginPage.navigate();
		loginPage.registrarVueloIdaVuelta();
	}

}
