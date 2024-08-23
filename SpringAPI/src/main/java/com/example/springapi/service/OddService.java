package com.example.springapi.service;

import com.example.springapi.api.model.IsOddResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OddService {
    private Random dice;
    private String[] scrapedFacts = {
            "Venus has a very slow rotation on its axis, so it takes about 243 Earth days to rotate once but only 225 Earth days to complete an orbit around the Sun.",
            "Archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still perfectly edible!",
            "The estimated number of stars in the observable universe is about 10 times the number of grains of sand on Earth.",
            "In terms of global recognition, Oreos have been sold in over 100 countries and have a cult-like following, making them a contender for the most recognized cookie worldwide",
            "The Great Pyramid of Giza was built around 2,560 BCE, while Cleopatra lived around 30 BCE, closer in time to the 1969 moon landing",
            "Despite the obvious differences, humans and bananas share a significant portion of their genetic makeup."
    };

    private int[] niceNms = {69, 420, 666, 69420, 42069};
    private List<String> funFacts;
    private Set<Integer> funNms ;

    public OddService(){
        dice = new Random();
        funFacts = new ArrayList<>();
        funNms = new HashSet<>();
        for (String fact: scrapedFacts){
            funFacts.add(fact);
        }
        for (int x: niceNms){
            funNms.add(Integer.valueOf(x));
        }
    }
    public Optional getResponse(Integer number) {
        IsOddResponse oddResponse = new IsOddResponse();
        if(number >= 1000000 || number < 0){
            oddResponse.setResult(false);
            oddResponse.setFunFact("Sorry, you have not subscribed to our extra services yet.");
        }
        else{
            oddResponse.setResult(number % 2 == 1);
            if(funNms.contains(number)) oddResponse.setFunFact("hehe you used a funny number");
            else oddResponse.setFunFact(funFacts.get(dice.nextInt(funFacts.size())));
        }
        return Optional.of(oddResponse);
    }
}
