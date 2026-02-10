package com.team4.first_ui_.flow.Repository;

import com.team4.first_ui_.flow.Model.Item;

import java.util.List;

public interface ItemRepository {

    List<Item> findAll();
    void save(Item item);
    void deleteById(Long id);
}
