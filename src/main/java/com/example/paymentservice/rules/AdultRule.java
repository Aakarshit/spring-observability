package com.example.paymentservice.rules;

import com.example.paymentservice.dto.Person;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "AdultRule", description = "Checks if a person is adult or not.",priority = 1)
public class AdultRule{

    @Condition
    public boolean when(@Fact("person") Person person) {
        return person.age() >= 18;
    }

    @Action
    public void then(@Fact("person") Person person) {
        System.out.println(person.name() + " is an adult.");
    }
}
