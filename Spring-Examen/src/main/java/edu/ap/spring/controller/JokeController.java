package edu.ap.spring.controller;

import edu.ap.spring.jpa.Joke;
import edu.ap.spring.jpa.JokeRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@Scope("session")
public class JokeController {

    @Autowired
    private JokeRepository jokeRepository;
   
   public JokeController() {
   }
       
   @RequestMapping("/joke")
   public String joke() {

       return "index";
   }
		   
   @RequestMapping("/joke_post")
   public String joke_post(@RequestParam("name") String name, @RequestParam("firstname") String firstname, Model model) {
       String uri = "http://api.icndb.com/jokes/random?firstName=" + firstname + "&lastName=" + name;
       RestTemplate restTemplate = new RestTemplate();
       String result = restTemplate.getForObject(uri, String.class);
       JSONObject jsonObj = new JSONObject(result);
       String quote = jsonObj.getJSONObject("value").getString("joke");
       model.addAttribute("joke", quote);
       if(jokeRepository.findByJoke(quote) == null) {
           System.out.println(quote);
           jokeRepository.save(new Joke(quote));
           System.out.println(jokeRepository.findByJoke(quote));
       }
       return "joke";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
