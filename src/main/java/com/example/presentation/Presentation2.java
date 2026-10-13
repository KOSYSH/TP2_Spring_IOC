package com.example.presentation;


import com.example.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration // annotation de Spring qui indique que cette classe contient des configurations Spring
@ComponentScan(basePackages = {"com.example.dao","com.example.metier"}) // indique a Spring quels packages scanner pour trouver les beans
public class Presentation2 {
    public static void main(String[] args){
        //La creation du contexte Spring base sur les annotations
        ApplicationContext context = new AnnotationConfigApplicationContext(Presentation2.class);

        //Recuperation du bean IMetier depuis le conteneur Spring
        IMetier metier = context.getBean(IMetier.class);

        //Execution de la methode calcul() et affichage du resultat
        System.out.println("Le resulats  est  :"+ metier.calcul());

    }

}
