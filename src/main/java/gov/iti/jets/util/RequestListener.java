package gov.iti.jets.util;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {
    public static int counter = 0;

    @Override
    public void requestInitialized(ServletRequestEvent sre){
        EntityManager em = EntityManagerHelper.getEntityManager();
        sre.getServletRequest().setAttribute("entityManager", em);
    }
    @Override
    public void requestDestroyed(ServletRequestEvent sre){
        System.out.println("end = "+  ++counter);
        EntityManagerHelper.closeEntityManager();
    }
}