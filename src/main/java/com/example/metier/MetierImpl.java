package com.example.metier;


import com.example.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier") //Declaration de la classe metier comme un bean Spring avec le nom metier
public class MetierImpl implements IMetier{
@Autowired // utilisation de l'annotation Autowired pour que Spring injecte automatiquement une implementation de IDao
@Qualifier("dao2") // on specifie quelle implementation de IDao le metier va utiliser pour l'injection
    private IDao dao; // utilisation de l'interface IDao pour pouvoir changer d'implementation sans changer le calcul

@Override
    public double calcul(){// utilisation de la methode getValue de l'implementation injectee pour prendre la valeur et la multiplier par 2
    return dao.getValue() *2;

}

public void setDao(IDao dao ){ //L'injection par setter comme alternative, ici Spring utilise le champ avec Autowired
    this.dao = dao;
}

}
