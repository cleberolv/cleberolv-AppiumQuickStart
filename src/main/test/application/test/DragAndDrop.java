package application.test;

import org.junit.Assert;
import org.junit.Test;

import application.core.BaseTest;
import application.page.DragAndDropPage;
import application.page.MenuPage;

public class DragAndDrop extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private DragAndDropPage page = new DragAndDropPage();
	
	private String[] estadoInicial = new String[] {"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[] {"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	private String[] estadoFinal = new String[] {"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};
	
	@Test
	public void DragNDrop() {
		//acessar menu
		page.esperaMenu();
		menu.acessarMenuDragAndDrop();
		
		//verificar estado inicial
		esperar(3000);
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		
		//mover item 1
		page.mover("Esta", "e arraste para");
		
		//verificar estado intermediário
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		
		//mover item 2
		page.mover("Faça um clique longo,", "é uma lista");
		
		//verficar estado final
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
		
	}
	

}
