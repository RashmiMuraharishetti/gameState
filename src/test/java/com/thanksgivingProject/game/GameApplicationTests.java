package com.thanksgivingProject.game;

import com.thanksgivingProject.game.Controller.ItemController;
import com.thanksgivingProject.game.Entity.Item;
import com.thanksgivingProject.game.Service.ItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameApplicationTests {

	@Mock
	private ItemService mockService;



	//test failed
	@Test
	public void testCreateItem() {
		Item expected = new Item(1L, "PUBG");
		ItemController itemController = new ItemController(mockService);

		//execute
		when(mockService.createItem(expected)).thenReturn(expected);

		Item actual = itemController.createItem(expected);

		//assert
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testDeleteItem(){
	    Item item = new Item(1L, "sword");
	    ItemController itemController = new ItemController(mockService);

	    itemController.deleteItem(item.getId());
	    verify(mockService,times(1)).deleteItem(item.getId());

	}



	@Test
	public void contextLoads(){

	}


}
