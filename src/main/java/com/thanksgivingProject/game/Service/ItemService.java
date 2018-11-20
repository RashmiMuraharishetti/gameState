package com.thanksgivingProject.game.Service;

import com.thanksgivingProject.game.Entity.Item;
import com.thanksgivingProject.game.Exception.NotFound;
import com.thanksgivingProject.game.Repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }


    //Story 1 - Create item by name - POST call
    //Story 2 - Replace existing item by name - POST call
    public Item createItem(Item item) {

        //Id existence check
        if(item.getId()!=null){
            if (itemRepository.existsById(item.getId())) {
                LOGGER.info("The item with this ID already exists, replacing the item. ");
        }

        } else {
            LOGGER.info("The item with this ID does not exist, creating new item. ");
        }
        return itemRepository.save(item);
    }



    //Story 3 - Delete by class name and id - Entry present - POST call: 200
    //Story 4 - Delete by class name and id - Entry absent - POST call: 404
    public void deleteItem(Long id){
        if(itemRepository.existsById(id)){
            this.itemRepository.deleteById(id);
        }
        else{
            throw new NotFound();
        }
    }


    //Story 5 - Find by id and id : Entry present - GET call: 200
    //Story 6 - Find by id and id : Entry absent - GET call: 404
    public Optional<Item> getItemByNameAndId(Long id, String name){
        Optional<Item> item = itemRepository.findByNameAndId(id, name);
        if(!itemRepository.existsById(id)) {
            LOGGER.info("item not found. throwing exception");
            throw new NotFound();
        }
        return item;
    }



    //Story 7 - Find by name - GET call: 200
    public Iterable<Item> getItemsByName(String name){
        return itemRepository.findByName(name);
    }



    //Story 8 - FindAll - GET call: 200
    public List<Item> getItems(){
        return (List<Item>) itemRepository.findAll();
    }

}
