import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    //Object attributes/vars
    private List<Purchase> shopBasket;

    //Object constructors

    public ShoppingBasket() {
        shopBasket = new ArrayList<Purchase>();
    }

    //Object methods
    //Adds a purchase object to an ArrayList if it doesn't exist already.  If it does exist, it
    //increases the # sold.
    public void add(String product, int price){
        Purchase singlePurchase = new Purchase(product, 1, price);

        /*If the product does not exist in the arrayList, add it.  The following comparison works bc
        I created an overriding equals and hashcode method in the Purchase class.  See that class for a
        better explanation.
         */
        if(!shopBasket.contains(singlePurchase)){
            shopBasket.add(singlePurchase);
        }else{ //The product already exists in the arrayList.  Get the index and increase the amount by 1
            int index = shopBasket.indexOf(singlePurchase);
            shopBasket.get(index).increaseAmount();
        }
    }

    //Returns the total price of all purchase objects in the shopping basket
    public int price(){
        int totPrice = 0;

        for(Purchase purchaseObject : this.shopBasket){
            totPrice += purchaseObject.price();
        }

        return totPrice;
    }

    //Prints out the contents of the shoppingBasket
    public void print(){
        for(Purchase purchaseObject : this.shopBasket){
            System.out.println(purchaseObject);
        }
    }
}
