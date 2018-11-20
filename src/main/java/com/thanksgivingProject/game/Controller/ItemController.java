package com.thanksgivingProject.game.Controller;

import com.thanksgivingProject.game.Entity.Item;
import com.thanksgivingProject.game.Service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {


    private ItemService itemService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void deleteItem(@PathVariable("id") Long id){
        this.itemService.deleteItem(id);
    }


    //Story 5, 6
    @RequestMapping(value ="/get/{name}/{id}", method = RequestMethod.GET)
    public Optional<Item> getItemByNameAndId(@PathVariable("id") Long id, @PathVariable("name") String name){
        try{
            return itemService.getItemByNameAndId(id,name);

        }catch(Exception e){
            LOGGER.info("exception caught"+e);
        }
        return null;
    }

    //Story 7
    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public Iterable<Item> getItemsByName(@PathVariable("name") String name){
        Iterable<Item> itemsByName = this.itemService.getItemsByName(name);
        return itemsByName;
    }


    //Story 8
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Item> getItems(){
        List<Item> items = this.itemService.getItems();
        return items;
    }



}
