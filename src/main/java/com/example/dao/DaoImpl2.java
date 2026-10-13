package com.example.dao;


import org.springframework.stereotype.Component;

@Component("dao2")   // une autre declration dune bean SPring mais le nom cette fois est daoe2 comme dans Qualifier
public class DaoImpl2 implements IDao{
    @Override
        public double getValue(){

            return 150.0; //la methode retoure une valeur fixe 150 mais qui est different de dao
        }
    }

