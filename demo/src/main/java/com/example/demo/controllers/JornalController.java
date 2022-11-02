package com.example.demo.controllers;

import com.example.demo.models.Chitateli;
import com.example.demo.models.Jornalisti;
import com.example.demo.repo.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repo.PostRepository;
import com.example.demo.repo.JornalRepository;
import com.example.demo.models.Post;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class JornalController  {
//    @Autowired
//    private JornalRepository jornalRepository;
//
//
//    @GetMapping("/jornalisti")
//    public String blogJornalists(Model model)
//    {
//        Iterable<Jornalisti> jornalisti = jornalRepository.findAll();
//        model.addAttribute("jornalisti", jornalisti);
//        return "jornalisti";
//    }
//
//    @GetMapping("/jornalisti/filter")
//    public String jornalFilter(Model model)
//    {
//        return "jornal-filter";
//    }
//
//    @PostMapping("/jornalisti/filter/result")
//    public String jornalResult(@RequestParam String fam, Model model)
//    {
//        List<Jornalisti> result = jornalRepository.findByFam(fam);
//        model.addAttribute("result", result);
//        return "jornal-filter";
//    }
//    @PostMapping("/jornalisti/filter/tochresult")
//    public String jornalResultToch(@RequestParam String fam, Model model)
//    {
//        List<Jornalisti> tochresult = jornalRepository.findByFamContains(fam);
//        model.addAttribute("tochresult", tochresult);
//        return "jornal-filter";
//    }
//    @GetMapping("/jornalisti/add")
//    public String jornalistiAdd(Jornalisti jornalisti, Model model)
//    {
//        return "jornal-add";
//    }
//
//    @PostMapping("/jornalisti/add")
//    public Object jornalistiAdd(@ModelAttribute("jornalisti")
//                                @Validated Jornalisti jornalisti, BindingResult bindingResult)
//    {
//        if(bindingResult.hasErrors()){
//            return "jornal-add";
//        }
//        jornalRepository.save(jornalisti);
//        return "redirect:/jornalisti";
//    }
//
//
//    @GetMapping("/jornalisti/{id}")
//    public String jornalDetails(@PathVariable(value = "id") long id, Model model)
//    {
//        Optional<Jornalisti> jornalisti = jornalRepository.findById(id);
//        ArrayList<Jornalisti> res = new ArrayList<>();
//        jornalisti.ifPresent(res::add);
//        model.addAttribute("jornalisti", res);
//        return "jornalisti-details";
//    }
//
//    @GetMapping("/jornalisti/{id}/edit")
//    public String jornalEdit(@PathVariable("id") long id, Model model)
//    {
//        Jornalisti res = jornalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверный id: "+id));
//        model.addAttribute("jornalisti", res);
//        return "jornalisti-edit";
//    }
//
//    @PostMapping("/jornalisti/{id}/edit")
//    public String jornalPostUpdate(@PathVariable("id") long id,
//                                   @ModelAttribute("jornalisti")
//                                   @Validated Jornalisti jornalisti, BindingResult bindingResult)
//    {
//        jornalisti.setId(id);
//        if(bindingResult.hasErrors()){
//            return "jornalisti-edit";
//        }
//        jornalRepository.save(jornalisti);
//        return "redirect:/jornalisti";
//    }
//
//    @PostMapping("/jornalisti/{id}/remove")
//    public String jornalPostRemove(@PathVariable("id") long id, Model model)
//    {
//        Jornalisti jornalisti = jornalRepository.findById(id).orElseThrow();
//        jornalRepository.delete(jornalisti);
//        return "redirect:/jornalisti";
//    }
}
