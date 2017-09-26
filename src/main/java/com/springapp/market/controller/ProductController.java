package com.springapp.market.controller;

import com.springapp.market.model.Company;
import com.springapp.market.model.Product;
import com.springapp.market.service.CompanyService;
import com.springapp.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ProductController {
    private ProductService productService;

    protected CompanyService companyService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model) {
    	System.out.println("products + GET");
        model.addAttribute("product", new Product());
        model.addAttribute("company", new Company());
        model.addAttribute("listCompanies", this.companyService.listCompanies());
        model.addAttribute("listProducts", this.productService.listProducts());
        return "products";
    }

    @RequestMapping(value = "/save_product", method = RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute("product") Product product, BindingResult result) {
    	System.out.println("save_product + POST");
        this.productService.addProduct(product);
        return new ModelAndView("redirect:/products");
    }

    @RequestMapping("/remove_product/{id}")
    public String removeProduct(@PathVariable("id") long id) {
    	System.out.println("remove_product/{id} + method is indefined");
        this.productService.removeProduct(id);
        return "redirect:/products";
    }

    @RequestMapping("edit_product/{id}")
    public String editProduct(@PathVariable("id") long id, Model model) {
    	System.out.println("edit_product/{id} + method is indefined");
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProducts", this.productService.listProducts());
        model.addAttribute("listCompanies", this.companyService.listCompanies());
        return "products";
    }

    @RequestMapping("product_data/{id}")
    public String productData(@PathVariable("id") long id, Model model) {
    	System.out.println("product_data/{id} + method is indefined");
        model.addAttribute("product", this.productService.getProductById(id));
        return "product_data";
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String catalog(Model model) {
    	System.out.println("catalog + GET");
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", this.productService.listProducts());
        return "catalog";
    }
}
