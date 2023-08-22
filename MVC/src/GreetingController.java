package exgnosis.mymvc;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
     private final static String template = "Hello,%s";
     private final static AtomicLong counter = new AtomicLong();
     
     @GetMapping("/greeting")
     public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
    	 return new Greeting(counter.incrementAndGet(), String.format(template, name));
     }
     
     @GetMapping("/")
     public String base() { return "Root element";}
     
}
