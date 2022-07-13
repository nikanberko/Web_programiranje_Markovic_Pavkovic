package com.example.Randomwordgenerator.wordgeneratorcontroller;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WordGeneratorController {

    @Autowired
    private RestTemplate restTemplate;

    private static String url="https://random-word-api.herokuapp.com/";


    @GetMapping("/word")
    public Object generateRandomWord() throws RuntimeException {
        Object word=restTemplate.getForObject(url+"/word", Object[].class);
        return word;
    }


    @GetMapping("/word/length/{length}")
    public List<Object> generateRandomWordOfLength(@PathVariable("length") int length) throws RuntimeException {
        Object[] word=restTemplate.getForObject(url+"/word?length="+length, Object[].class);
        return Arrays.asList(word);
    }

    @GetMapping("/word/language/{lang}")
    public List<Object> generateRandomWordOfType(@PathVariable("lang") String language) throws RuntimeException {
        Object[] word=restTemplate.getForObject(url+"/word?lang="+language, Object[].class);
        return Arrays.asList(word);
    }
}
