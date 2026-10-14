package com.example.presentation;


import com.example.metier.IMetier;
//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration // annotation de Spring qui indique que cette classe contient des configurations Spring
@ComponentScan(basePackages = {"com.example.dao","com.example.metier"}) // indique a Spring quels packages scanner pour trouver les beans
public class Presentation2 {
    public static void main(String[] args){
        //Ancienne creation du contexte sans activation de profil
        //ApplicationContext context = new AnnotationConfigApplicationContext(Presentation2.class);

        //Creation du contexte puis activation du profil avant le chargement des beans
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev"); //Changer dev en prod pour utiliser DaoImpl
        context.register(Presentation2.class);
        context.refresh(); //Chargement des beans du profil actif

        //Recuperation du bean IMetier depuis le conteneur Spring
        IMetier metier = context.getBean(IMetier.class);

        //Execution de la methode calcul() et affichage du resultat
        System.out.println("Le resulats  est  :"+ metier.calcul());

        context.close(); //Fermeture du contexte apres le calcul

    }

}
