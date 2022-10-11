package com.group5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    private ProductRepository repository;

    @GetMapping("/")
    public String frontpage()
    {
        return "frontpage";
    }

    @GetMapping("/products")
    public List<Product> showProduct()
    {
        return repository.getProducts();
    }
}
