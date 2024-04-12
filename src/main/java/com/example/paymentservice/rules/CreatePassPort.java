package com.example.paymentservice.rules;

import com.example.paymentservice.dto.Person;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "CreatePassPort", description = "helpes to create a passport",priority = 2)
public class CreatePassPort {

    @Condition
    public boolean when(@Fact("person")Person person){
        return person.hasAadhar();
    }

    @Action
    public void then(@Fact("person")Person person){
        System.out.println(person.name()  + " has successfully created a passport");
    }

}
