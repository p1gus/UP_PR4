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
public class BlogController  {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ReaderRepository chitRepository;
    @Autowired
    private JornalRepository jornalRepository;

    @GetMapping("/")
    public String Main(Model model)
    {
        return "blog-main";
    }

    @GetMapping("/stati")
    public String blogMain(Model model)
    {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "stati";
    }

   @GetMapping("/blog/add")
    public String blogAdd(Post post,Model model)
    {
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public Object blogPostAdd(@ModelAttribute("post")@Validated Post post, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "blog-add";
        }
        postRepository.save(post);
        return "redirect:/stati";
    }

    @GetMapping("/blog/filter")
    public String blogFilter(Model model)
    {
        return "blog-filter";
    }

    @PostMapping("/blog/filter/result")
    public String blogResult(@RequestParam String title, Model model)
    {
        List<Post> result = postRepository.findByTitleContains(title);
        model.addAttribute("result", result);
        return "blog-filter";
    }

    @GetMapping("/stati/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable("id") long id, Model model)
    {
        Post res = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверный id: "+id));
        model.addAttribute("post", res);
        return "blog-edit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable("id") long id,
                                 @ModelAttribute("post")
                                 @Validated Post post, BindingResult bindingResult)
    {
        post.setId(id);
        if(bindingResult.hasErrors()){
            return "blog-edit";
        }
        postRepository.save(post);
        return "redirect:/stati";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostRemove(@PathVariable("id") long id, Model model)
    {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/stati";
    }















    @GetMapping("/chitateli")
    public String chitateli(Model model)
    {
        Iterable<Chitateli> chitateliIterable = chitRepository.findAll();
        model.addAttribute("chitateli", chitateliIterable);
        return "chitateli";
    }
    @GetMapping("/chitateli/filter")
    public String chitatelFilter(Model model)
    {
        return "chitateli-filter";
    }

    @PostMapping("/chitateli/filter/result")
    public String chitatelResult(@RequestParam String fam, Model model)
    {
        List<Chitateli> result = chitRepository.findByFam(fam);
        model.addAttribute("result", result);
        return "chitateli-filter";
    }
    @GetMapping("/chitateli/add")
    public String chitatelAdd(Chitateli chitateli, Model model)
    {
        return "chitateli-add";
    }

    @PostMapping("/chitateli/add")
    public Object chitatelAdd(@ModelAttribute("chitateli")@Validated Chitateli chitateli, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "chitateli-add";
        }
        chitRepository.save(chitateli);
        return "redirect:/chitateli";
    }

    @GetMapping("/chitateli/{id}")
    public String chitatelDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Chitateli> chitateli = chitRepository.findById(id);
        ArrayList<Chitateli> res = new ArrayList<>();
        chitateli.ifPresent(res::add);
        model.addAttribute("chitateli", res);
        if(!chitRepository.existsById(id)){
            return "redirect:/chitateli";
        }
        return "chitateli-details";
    }

    @GetMapping("/chitateli/{id}/edit")
    public String chitatelEdit(@PathVariable("id") long id, Model model)
    {
        Chitateli res = chitRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверный id: "+id));
        model.addAttribute("chitateli", res);

        return "chitateli-edit";
    }

    @PostMapping("/chitateli/{id}/edit")
    public String chitatelPostUpdate(@PathVariable("id") long id,
                                     @ModelAttribute("chitateli")
                                     @Validated Chitateli chitateli, BindingResult bindingResult)
    {
        chitateli.setId(id);
        if(bindingResult.hasErrors()){
            return "chitateli-edit";
        }
        chitRepository.save(chitateli);
        return "redirect:/chitateli";
    }

    @PostMapping("/chitateli/{id}/remove")
    public String chitatelPostRemove(@PathVariable("id") long id, Model model)
    {
        Chitateli chitateli = chitRepository.findById(id).orElseThrow();
        chitRepository.delete(chitateli);
        return "redirect:/chitateli";
    }














    @GetMapping("/jornalisti")
    public String blogJornalists(Model model)
    {
        Iterable<Jornalisti> jornalisti = jornalRepository.findAll();
        model.addAttribute("jornalisti", jornalisti);
        return "jornalisti";
    }

    @GetMapping("/jornalisti/filter")
    public String jornalFilter(Model model)
    {
        return "jornal-filter";
    }

    @PostMapping("/jornalisti/filter/result")
    public String jornalResult(@RequestParam String fam, Model model)
    {
        List<Jornalisti> result = jornalRepository.findByFam(fam);
        model.addAttribute("result", result);
        return "jornal-filter";
    }
    @PostMapping("/jornalisti/filter/tochresult")
    public String jornalResultToch(@RequestParam String fam, Model model)
    {
        List<Jornalisti> tochresult = jornalRepository.findByFamContains(fam);
        model.addAttribute("tochresult", tochresult);
        return "jornal-filter";
    }
    @GetMapping("/jornalisti/add")
    public String jornalistiAdd(Jornalisti jornalisti, Model model)
    {
        return "jornal-add";
    }

    @PostMapping("/jornalisti/add")
    public Object jornalistiAdd(@ModelAttribute("jornalisti")
                                @Validated Jornalisti jornalisti, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "jornal-add";
        }
        jornalRepository.save(jornalisti);
        return "redirect:/jornalisti";
    }


    @GetMapping("/jornalisti/{id}")
    public String jornalDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<Jornalisti> jornalisti = jornalRepository.findById(id);
        ArrayList<Jornalisti> res = new ArrayList<>();
        jornalisti.ifPresent(res::add);
        model.addAttribute("jornalisti", res);
        return "jornalisti-details";
    }

    @GetMapping("/jornalisti/{id}/edit")
    public String jornalEdit(@PathVariable("id") long id, Model model)
    {
        Jornalisti res = jornalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Неверный id: "+id));
        model.addAttribute("jornalisti", res);
        return "jornalisti-edit";
    }

    @PostMapping("/jornalisti/{id}/edit")
    public String jornalPostUpdate(@PathVariable("id") long id,
                                   @ModelAttribute("jornalisti")
                                   @Validated Jornalisti jornalisti, BindingResult bindingResult)
    {
        jornalisti.setId(id);
        if(bindingResult.hasErrors()){
            return "jornalisti-edit";
        }
        jornalRepository.save(jornalisti);
        return "redirect:/jornalisti";
    }

    @PostMapping("/jornalisti/{id}/remove")
    public String jornalPostRemove(@PathVariable("id") long id, Model model)
    {
        Jornalisti jornalisti = jornalRepository.findById(id).orElseThrow();
        jornalRepository.delete(jornalisti);
        return "redirect:/jornalisti";
    }
}
