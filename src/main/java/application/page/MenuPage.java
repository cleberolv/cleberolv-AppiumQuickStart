package application.page;

import application.core.BasePage;

public class MenuPage extends BasePage {
	
	BasePage page = new BasePage();
	
	public void form() {
		clickByText("Formulário");
	}
	
	public void splash() {
		clickByText("Splash");
	}
	
	public void alert() {
		clickByText("Alertas");
	}
	
	public void tabs() {
		clickByText("Abas");
	}
	
	public void accordion() {
		clickByText("Accordion");
	}
	
	public void clicks() {
		clickByText("Cliques");
	}
	
	public void swipe() {
		page.scrollDown();
		clickByText("Swipe");
	}
	
	public void swipeList() {
		page.scrollDown();
		clickByText("Swipe List");
	}
	
	public void dragAndDrop() {
		page.scrollDown();
		clickByText("Drag and drop");
	}
	
	public void SB() {
		clickByText("SeuBarriga Nativo");
	}
}
