package com.springapp.market.controller;

import com.springapp.market.model.Company;
import com.springapp.market.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created on 25.05.2017
 *
 * Request mapping for {@link com.springapp.market.model.Company}.
 *
 * @author Roman Hayda
 */
@Controller
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public String listCompanies(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("listCompanies", this.companyService.listCompanies());
        return "companies";
    }

    @RequestMapping(value = "/save_company", method = RequestMethod.POST)
    public ModelAndView saveCompany(@ModelAttribute("company") @Valid Company company, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/companies");
        }
        this.companyService.addCompany(company);
        return new ModelAndView("redirect:/companies");
    }

    @RequestMapping("/remove_company/{id}")
    public String removeCompany(@PathVariable("id") long id) {
        this.companyService.removeCompany(id);
        return "redirect:/companies";
    }

    @RequestMapping("edit_company/{id}")
    public String editProduct(@PathVariable("id") long id, Model model) {
        model.addAttribute("company", this.companyService.getCompanyById(id));
        model.addAttribute("listCompanies", this.companyService.listCompanies());
        return "companies";
    }

    @RequestMapping(value="company_info/{id}")
    public String companyInfo(@PathVariable("id") long id, Model model) {
        model.addAttribute("company", this.companyService.getCompanyById(id));
        return "company_info";
    }
    @RequestMapping(value="company_info/{id}/all")
    public String allProducts(@PathVariable("id") long id, Model model) {
        model.addAttribute("company", this.companyService.getCompanyById(id));
        model.addAttribute("allProducts", companyService.getProductsByCompanyId(id));
        return "/company_info";
    }
}
