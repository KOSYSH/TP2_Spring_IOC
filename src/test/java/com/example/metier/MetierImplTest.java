package com.example.metier;

import com.example.dao.IDao;
import org.junit.Assert;
import org.junit.Test;

public class MetierImplTest {

    @Test
    public void testCalcul() {
        //Creation d'un dao fictif qui retourne 10 pour le test
        IDao dao = new IDao() {
            @Override
            public double getValue() {
                return 10.0;
            }
        };

        //Creation du metier et injection du dao avec le setter
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);

        //Verification du resultat : 10 * 2 = 20
        double resultat = metier.calcul();
        Assert.assertEquals(20.0, resultat, 0.001);
    }
}
