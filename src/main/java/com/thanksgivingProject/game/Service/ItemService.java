package com.thanksgivingProject.game.Service;

import com.thanksgivingProject.game.Entity.Item;
import com.thanksgivingProject.game.Repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemService.class);

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {

        //Id existence check
        if(item.getId()!=null){
            if (itemRepository.existsById(item.getId())) {
                LOGGER.info("The item with this ID already exists, replacing the item. ");
        }

        } else {
            LOGGER.info("The item with this ID does not exist, creating new item. ");
           // return itemRepository.save(item);
        }
        return itemRepository.save(item);
    }

    public void deleteItem(Long id){
        this.itemRepository.deleteById(id);
    }

}
