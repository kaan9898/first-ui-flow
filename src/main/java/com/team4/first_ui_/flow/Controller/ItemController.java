package com.team4.first_ui_.flow.Controller;

import com.team4.first_ui_.flow.Model.Item;
import com.team4.first_ui_.flow.Service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String getAllItems( Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "items";
    }
    @GetMapping("/new")
    public String showCreateForm( Model model) {
        model.addAttribute("item", new Item());
        return "item-form";
    }
    @PostMapping("/saveItem")
    public String saveItem(@ModelAttribute Item item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }
}
