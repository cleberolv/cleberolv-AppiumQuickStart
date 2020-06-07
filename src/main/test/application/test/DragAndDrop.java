package application.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import application.core.BaseTest;
import application.page.DragAndDropPage;
import application.page.MenuPage;

public class DragAndDrop extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private DragAndDropPage page = new DragAndDropPage();
	
	private String[] initialState = new String[] {"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] intermediumState = new String[] {"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	private String[] finalState = new String[] {"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};
	
	@Test
	public void inteactDragNDrop() {
		page.waitMenu();
		menu.dragAndDrop();
		
		await(3000);
		assertArrayEquals(initialState, page.getList());
		
		//item 1
		page.move("Esta", "e arraste para");
		assertArrayEquals(intermediumState, page.getList());
		
		//item 2
		page.move("Faça um clique longo,", "é uma lista");
		assertArrayEquals(finalState, page.getList());
	}
	
}
