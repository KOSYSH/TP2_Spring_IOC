package com.example.dao;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("dao2")   // une autre declaration d'un bean Spring mais le nom cette fois est dao2 comme dans Qualifier
@Profile("dev") //Ce bean sera actif uniquement avec le profil dev
public class DaoImpl2 implements IDao{
    @Override
        public double getValue(){
            System.out.println("Version de developpement");
            return 150.0; //la methode retourne une valeur fixe de 150 qui est differente de celle de dao
        }
    }

