package com.example.metier;


import com.example.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier") //Declaration du class metier comme un bean Spring avec le nom metier
public class MetierImpl implements IMetier{
@Autowired // utilisation dannotations Autowired  ou ici Spring va injecter automatiquement une implimentation de IDao
@Qualifier("dao2") // on spciecife quelle implentation IDao metier va utilister en injection
    private IDao dao; // utilisation de l'interface IDao pour pouvoir changer implementation sans changer le calcul

@Override
    public double calcul(){// utilisation du  methode getValue par implemntation injecte et prendre  la valeur et mutiplie par 2
    return dao.getValue() *2;

}

public void setDao(IDao dao ){ //L'injection par setter comme alternative, ici Spring utilise le champ avec Autowired
    this.dao = dao;
}

}
