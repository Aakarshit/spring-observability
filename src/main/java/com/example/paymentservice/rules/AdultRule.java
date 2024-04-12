package com.example.paymentservice.rules;

import com.example.paymentservice.dto.Person;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.core.BasicRule;

public class AdultRule extends BasicRule {

    public AdultRule() {
        super("AdultRule", "Checks if a person is adult or not.",1);
    }
    @Override
    public boolean evaluate(Facts facts) {
        Person person = facts.get("person");
        return person.age() >= 18;
    }

    @Override
    public void execute(Facts facts) {
        Person p=facts.get("person");
        System.out.println(p.name() + " is an adult.");
    }
}
