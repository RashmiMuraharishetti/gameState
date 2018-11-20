package com.thanksgivingProject.game.Repository;

import com.thanksgivingProject.game.Entity.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query(value = "SELECT i.item_id, i.item_name from Items i where i.item_name=:name", nativeQuery = true)
    Iterable<Item> findByName(String name);

    @Query(value = "SELECT i.item_id, i.item_name from Items i where i.item_id =:id AND i.item_name=:name", nativeQuery = true)
    Optional<Item> findByNameAndId(Long id, String name);

}
