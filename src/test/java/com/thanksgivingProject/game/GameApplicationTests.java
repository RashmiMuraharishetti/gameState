package com.thanksgivingProject.game;

import com.thanksgivingProject.game.Controller.ItemController;
import com.thanksgivingProject.game.Entity.Item;
import com.thanksgivingProject.game.Service.ItemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameApplicationTests {

	@Mock
	private ItemService mockService;

	@Test
	public void contextLoads(){

	}

	@Test
	public void testCreateItemNotInDataStore() {
		Item expected = new Item("PUBG");
		ItemController itemController = new ItemController(mockService);

		//execute
		when(mockService.createItem(expected)).thenReturn(expected);

		Item actual = itemController.createItem(expected);

		//assert
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testCreateItemInDataStore() {
		Item expected = new Item(1L, "PUBG");
		ItemController itemController = new ItemController(mockService);

		//execute
		when(mockService.createItem(expected)).thenReturn(expected);

		Item actual = itemController.createItem(expected);

		//assert
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testDeleteItemInDataStore(){
	    Item item = new Item(1L, "sword");
	    ItemController itemController = new ItemController(mockService);

	    itemController.deleteItem(item.getId());
	    verify(mockService,times(1)).deleteItem(item.getId());

	}

	@Test
	public void testDeleteItemNotInDataStore(){
		Item item = new Item(1L, "sword");
		ItemController itemController = new ItemController(mockService);

		itemController.deleteItem(item.getId());

		verify(mockService,times(1)).deleteItem(item.getId());

	}

	@Test
	public void testGetByNameAndId(){
		Long id= 1L;
		String name ="sword";
		Optional<Item> expected = Optional.of(new Item());

		ItemController itemController = new ItemController(mockService);

		when(mockService.getItemByNameAndId(id,name)).thenReturn(expected);

		Optional<Item> actual = itemController.getItemByNameAndId(id, name);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testGetByIdNotInDataStore(){
		Long id= 1L;
		String name ="sword";
		Optional<Item> expected = Optional.of(new Item());

		ItemController itemController = new ItemController(mockService);

		when(mockService.getItemByNameAndId(id,name)).thenReturn(expected);

		Optional<Item> actual = itemController.getItemByNameAndId(id, name);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testGetByName(){

		String name ="sword";
		Iterable<Item> expected = new ArrayList<Item>();

		ItemController itemController = new ItemController(mockService);

		when(mockService.getItemsByName(name)).thenReturn(expected);

		Iterable<Item> actual = itemController.getItemsByName(name);

		Assert.assertEquals(expected, actual);

	}

	@Test
	public void testGetAll(){
		Iterable<Item> expected = new ArrayList<Item>();
		ItemController itemController = new ItemController(mockService);

		Iterable<Item> actual = itemController.getItems();
		Assert.assertEquals(expected, actual);
	}

}
