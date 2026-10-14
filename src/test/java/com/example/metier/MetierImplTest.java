package com.example.metier;

import com.example.dao.IDao;
import com.example.presentation.Presentation2;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

    @Test
    public void testCalculDevAvecSpring() {
        //Creation du contexte et activation du profil dev avant de charger les beans
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.getEnvironment().setActiveProfiles("dev");
            context.register(Presentation2.class);
            context.refresh();

            //Spring cree le metier et injecte le dao avec Autowired, on n'appelle pas setDao
            IMetier metier = context.getBean(IMetier.class);

            //Verification que seul dao2 est actif et que le resultat est 150 * 2 = 300
            Assert.assertTrue(context.containsBean("dao2"));
            Assert.assertFalse(context.containsBean("dao"));
            Assert.assertEquals(300.0, metier.calcul(), 0.001);
        }
    }

    @Test
    public void testCalculProdAvecSpring() {
        //Meme test mais cette fois avec le profil prod
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.getEnvironment().setActiveProfiles("prod");
            context.register(Presentation2.class);
            context.refresh();

            //Recuperation du metier avec son dao deja injecte par Spring
            IMetier metier = context.getBean(IMetier.class);

            //Verification que seul dao est actif et que le resultat est 100 * 2 = 200
            Assert.assertTrue(context.containsBean("dao"));
            Assert.assertFalse(context.containsBean("dao2"));
            Assert.assertEquals(200.0, metier.calcul(), 0.001);
        }
    }
}
