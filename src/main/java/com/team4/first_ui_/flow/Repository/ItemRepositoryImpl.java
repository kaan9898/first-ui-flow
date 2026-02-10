package com.team4.first_ui_.flow.Repository;

import com.team4.first_ui_.flow.Model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {

    private final List<Item> items = new ArrayList<>();
    private int counter = 1;

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public void save(Item item) {
        item.setItemId(counter++);
        items.add(item);
    }

    @Override
    public void deleteById(Long id) {
        items.removeIf(item -> item.getItemId() == id);
    }
}