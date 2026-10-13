package com.example.dao;


import org.springframework.stereotype.Component;

@Component("dao")  //Declaration du class comme un bean Spring avec le nom dao
public class DaoImpl implements IDao{
    @Override
    public double getValue(){
        return 100.0; // la methode getValue retourne dune valeur fixe
    }

}
