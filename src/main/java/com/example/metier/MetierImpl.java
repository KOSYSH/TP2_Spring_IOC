package com.example.metier;


import com.example.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier") //Declaration de la classe metier comme un bean Spring avec le nom metier
public class MetierImpl implements IMetier{
@Autowired //Injection par champ : Spring remplit directement le champ dao sans appeler setDao
//@Qualifier("dao2") //Ancien choix du dao avec Qualifier
//Avec les profils, un seul dao est actif donc Spring injecte celui du profil choisi
    private IDao dao; // utilisation de l'interface IDao pour pouvoir changer d'implementation sans changer le calcul

@Override
    public double calcul(){// utilisation de la methode getValue de l'implementation injectee pour prendre la valeur et la multiplier par 2
    return dao.getValue() *2;

}

//Dans le test simple, on appelle ce setter nous-memes. Avec le XML, Spring l'appelle
public void setDao(IDao dao ){ //Injection par setter : le dao est passe comme argument de setDao
    this.dao = dao;
}

}
