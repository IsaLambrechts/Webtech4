package edu.ap.spring.controller;

import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@Scope("session")
public class JokeController {
   
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
       System.out.println(result);
       JSONObject jsonObj = new JSONObject(result);
       String quote = jsonObj.getJSONObject("value").getString("joke");
       model.addAttribute("joke", quote);
       return "joke";
   }
   
   @RequestMapping("/")
   public String root() {
	   return "redirect:/joke";
   }
}
