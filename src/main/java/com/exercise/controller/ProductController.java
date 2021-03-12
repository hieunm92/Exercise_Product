package com.exercise.controller;


import com.exercise.model.Category;
import com.exercise.model.Product;
import com.exercise.repository.ICategoryRepository;
import com.exercise.sevice.category.ICategoryService;
import com.exercise.sevice.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("Categoryname")
    public List<Category> categoryList() {
        return iCategoryService.findAll();
    }


    @GetMapping
    public ModelAndView showAll(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        Page<Product> productPage = iProductService.findAllPage(pageable);
        modelAndView.addObject("product", productPage);
        return modelAndView;
    }

    @GetMapping("/creat")
    public ModelAndView showCreatProductForm() {
        ModelAndView modelAndView = new ModelAndView("creat");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/creat")
    public ModelAndView CreatProductForm(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect: /product");
        iProductService.save(product);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Product product = iProductService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editProduct(@ModelAttribute Product product, @PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect: /product");
        product.setId(id);
        iProductService.save(product);
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public ModelAndView showDeleteProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect: /product");
        iProductService.deleteById(id);
        return modelAndView;
    }

//    @GetMapping("/search")
//    public ModelAndView searchByProductName(@RequestParam String search){
//        List<Product> list = iProductService.findProductName(search);
//        return new ModelAndView("list","product",list);
//    }

    @GetMapping("/search")
    public ModelAndView searchByProductName(@ModelAttribute Category category) {
        List<Product> list = iProductService.findAllByCategory(category);
        return new ModelAndView("list", "product", list);
    }
}
