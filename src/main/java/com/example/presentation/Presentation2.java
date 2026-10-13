package com.example.presentation;


import com.example.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration //annotattion de Spring indique que cette classe contient des configurations SPring
@ComponentScan(basePackages = {"com.example.dao","com.example.metier"}) // un index pour Spring quell package a scanner pour trouber les beans
public class Presentation2 {
    public static void main(String[] args){
        //La creation du contexte  Spring base sur les annotations
        ApplicationContext context = new AnnotationConfigApplicationContext(Presentation2.class);

        //recuper le bean  Imetier depuis  depuis le conteneur  Spring
        IMetier metier = context.getBean(IMetier.class);

        //Execution de la methode  calcul() et afficahge du resulat
        System.out.println("Le resulats  est  :"+ metier.calcul());

    }

}
