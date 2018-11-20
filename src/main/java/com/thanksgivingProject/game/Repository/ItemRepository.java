package com.thanksgivingProject.game.Repository;

import com.thanksgivingProject.game.Entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
