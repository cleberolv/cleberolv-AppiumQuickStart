package application.page;

import org.openqa.selenium.By;

import application.core.BasePage;

public class SBLoginPage extends BasePage {
	
	public void setEmail(String email) {
		escreverFormulario(By.className("android.widget.EditText"), email);
	}
	
	public void setSenha(String senha) {
		escreverFormulario(By.xpath("//android.widget.EditText[2]"), senha);
	}
	
	public void btnEntrar() {
		clicarPorTexto("ENTRAR");
	}

}
