package com.example.demo.controllers;

import com.example.demo.models.Chitateli;
import com.example.demo.repo.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReadersController {
//    @Autowired
//    private ReaderRepository chitRepository;
//    @GetMapping("/chitateli")
//    public String chitateli(Model model)
//    {
//        Iterable<Chitateli> chitateliIterable = chitRepository.findAll();
//        model.addAttribute("chitateli", chitateliIterable);
//        return "chitateli";
//    }
//    @GetMapping("/chitateli/filter")
//    public String chitatelFilter(Model model)
//    {
//        return "chitateli-filter";
//    }
//
//    @PostMapping("/chitateli/filter/result")
//    public String chitatelResult(@RequestParam String fam, Model model)
//    {
//        List<Chitateli> result = chitRepository.findByFam(fam);
//        model.addAttribute("result", result);
//        return "chitateli-filter";
//    }
//    @GetMapping("/chitateli/add")
//    public String chitatelAdd(Chitateli chitateli, Model model)
//    {
//        return "chitateli-add";
//    }
//
//    @PostMapping("/chitateli/add")
//    public Object chitatelAdd(@ModelAttribute("chitateli")@Validated Chitateli chitateli, BindingResult bindingResult)
//    {
//        if(bindingResult.hasErrors()){
//            return "chitateli-add";
//        }
//        chitRepository.save(chitateli);
//        return "redirect:/chitateli";
//    }
//
//    @GetMapping("/chitateli/{id}")
//    public String chitatelDetails(@PathVariable(value = "id") long id, Model model)
//    {
//        Optional<Chitateli> chitateli = chitRepository.findById(id);
//        ArrayList<Chitateli> res = new ArrayList<>();
//        chitateli.ifPresent(res::add);
//        model.addAttribute("chitateli", res);
//        if(!chitRepository.existsById(id)){
//            return "redirect:/chitateli";
//        }
//        return "chitateli-details";
//    }
//
//    @GetMapping("/chitateli/{id}/edit")
//    public String chitatelEdit(@PathVariable("id") long id, Model model)
//    {
//        Chitateli res = chitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверный id: "+id));
//        model.addAttribute("chitateli", res);
//
//        return "chitateli-edit";
//    }
//
//    @PostMapping("/chitateli/{id}/edit")
//    public String chitatelPostUpdate(@PathVariable("id") long id,
//                                     @ModelAttribute("chitateli")
//                                     @Validated Chitateli chitateli, BindingResult bindingResult)
//    {
//        chitateli.setId(id);
//        if(bindingResult.hasErrors()){
//            return "chitateli-edit";
//        }
//        chitRepository.save(chitateli);
//        return "redirect:/chitateli";
//    }
//
//    @PostMapping("/chitateli/{id}/remove")
//    public String chitatelPostRemove(@PathVariable("id") long id, Model model)
//    {
//        Chitateli chitateli = chitRepository.findById(id).orElseThrow();
//        chitRepository.delete(chitateli);
//        return "redirect:/";
//    }
}
