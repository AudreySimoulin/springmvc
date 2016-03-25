/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import streaming.entity.Effacemoi;
import streaming.service.EffacemoiCrudService;

/**
 *
 * @author tom
 */
@Controller
@RequestMapping(value = "/effacemoi")
public class EffacemoiController {

    @Autowired
    private EffacemoiCrudService effacemoiCrudService;

    @RequestMapping(value = "ajouteMoi", method = RequestMethod.GET)
    public String ajouteMoi() {

        System.out.println("***********************Passe par ici***************************");

        return "forward:/effacemoi/listeMoi";
    }

    @RequestMapping(value = "listeMoi", method = RequestMethod.GET)
    public String listeMoi(Model model) {

        Iterable<Effacemoi> liste = effacemoiCrudService.findAll();

        model.addAttribute("maListe", liste);

        return "lister";
    }

    @RequestMapping(value = "detail/{idDuRecord}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "idDuRecord") long monId) {
        System.out.println(monId);
        return "lister";
    }
    
    @RequestMapping(value = "effaceMoiAjouterGet", method = RequestMethod.GET)
    public String effaceMoiAjouterGet(Model model){
       
        model.addAttribute("monEffaceMoi", new Effacemoi());
        return "effacemoi_ajouter";
    }
    
    @RequestMapping(value = "ajouter", method = RequestMethod.POST)
    public String ajouter(@ModelAttribute(value = "monEffaceMoi") Effacemoi em){
        
        effacemoiCrudService.save(em);
        return "redirect:/effacemoi/listeMoi";
    }
}
