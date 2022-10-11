package com.group5;

import java.util.HashMap;

public class Shoppincart
{
    // Varje produkt sparas som en nyckel där värdet anger antalet av den produkten
    private HashMap<Product, Integer> cart = new HashMap<>();

    public HashMap<Product, Integer> getCart() {
        return cart;
    }

    /***
     * Lägger till produkter i shoppingvagnen
     * @param product   Produkten som skall läggas till
     * @param amount    Antalet av produkten
     * @return          Sant om operationen lyckades
     */
    public boolean addToCart(Product product, int amount)
    {
        if(amount <= 0)
            return false;

        cart.put(product, cart.containsKey(product) ? cart.get(product) + amount : amount);
        return true;
    }

    /***
     * Tar bort ett specificerat antal varor från kundkorg
     * @param product   Produkten som skall minska i antal
     * @param amount    Antalet som det skall minska med
     * @return          Sant om det lyckades. Falsk om produkten inte finns i listan
     */
    public boolean removeFromCart(Product product, int amount)
    {
        if(!cart.containsKey(product))
            return false;

        if(cart.get(product) <= 0)
        {
            cart.remove(product);
            return true;
        }

        cart.put(product, cart.get(product) - amount);
        return true;
    }
}
