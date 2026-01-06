package org.example;

public class Restaurant {
    public void prepareOrder(Order order) throws OrderPreparationException {
        if (Math.random() < 0.2) {
            throw new OrderPreparationException("Erreur lors de la préparation de la commande");
        }
    }
}
