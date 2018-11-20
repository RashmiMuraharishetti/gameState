package com.thanksgivingProject.game.Controller;

import com.thanksgivingProject.game.Entity.Item;
import com.thanksgivingProject.game.Service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {


    private final ItemService itemService;

    public ItemController(ItemService iService){
        itemService = iService;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Item createItem(@RequestBody Item item){
        return itemService.createItem(item);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public void deleteItem(@PathVariable("id") Long id){
        this.itemService.deleteItem(id);
    }




}
