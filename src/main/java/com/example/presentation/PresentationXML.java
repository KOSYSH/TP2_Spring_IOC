package com.example.presentation;

import com.example.metier.IMetier;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresentationXML {
    public static void main(String[] args) {
        //Chargement du contexte Spring depuis le fichier XML
        try (ClassPathXmlApplicationContext context =
                     new ClassPathXmlApplicationContext("applicationContext.xml")) {
            //Recuperation du bean metier
            IMetier metier = context.getBean("metier", IMetier.class);

            //Execution du calcul et affichage du resultat
            System.out.println("Resultat (XML) = " + metier.calcul());
        }
    }
}
