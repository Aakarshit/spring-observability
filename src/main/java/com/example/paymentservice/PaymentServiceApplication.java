package com.example.paymentservice;

import com.example.paymentservice.dto.Person;
import com.example.paymentservice.rules.AdultRule;
import com.example.paymentservice.rules.CreatePassPort;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.support.composite.ConditionalRuleGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceApplication.class, args);
        // With this we can achieve Chain of Responsibility
        Person bob1 = new Person("Bob1", 17,true);//no
        Person bob2 = new Person("Bob2", 21,false);//no
        Person bob3 = new Person("Bob3", 21,true);//true
        Person bob4 = new Person("Bob4", 25,true);//true
        List<Person> list= Arrays.asList(bob1,bob2,bob3,bob4);
        RulesEngine engine=new DefaultRulesEngine();
        ConditionalRuleGroup conditionalRuleGroup=new ConditionalRuleGroup();
        conditionalRuleGroup.addRule(new AdultRule());
        conditionalRuleGroup.addRule(new CreatePassPort());
        Rules rules=new Rules();
        rules.register(conditionalRuleGroup);
        for (Person person : list) {
            Facts facts=new Facts();
            facts.put("person",person);
            engine.fire(rules,facts);
        }
    }

}
