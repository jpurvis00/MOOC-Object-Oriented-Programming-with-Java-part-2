import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Storehouse {
    //Object attributes/vars
    private Map<String, Integer> prodPrice;
    private Map<String, Integer> prodStock;

    //Object constructors
    public Storehouse(){
        this.prodPrice = new HashMap<String, Integer>();
        this.prodStock = new HashMap<String, Integer>();
    }

    //Object methods
    //Adds the product/price and the product/stock into two diff hashMaps
    public void addProduct(String product, int price, int stock){
        this.prodPrice.put(product, price);
        this.prodStock.put(product, stock);
    }

    //Returns the price of a product.  If it doesn't exist, return -99
    public int price(String product){
        if(this.prodPrice.containsKey(product))
            return this.prodPrice.get(product);

        return -99;
    }

    //Returns the stock amount of  a product
    public int stock(String product){
        if(this.prodStock.containsKey(product))
            return this.prodStock.get(product);

        return 0;
    }

    //Decreases the stock # by 1 if qty is > 0 and returns true.  Returns false if qty is at 0.
    public boolean take(String product){
        if(this.prodStock.containsKey(product)) {
            int stock = this.prodStock.get(product);
            if(stock > 0) {
                stock--;
                this.prodStock.put(product, stock);
                return true;
            }
        }

        return false;
    }

    //Returns a set of all products
    public Set<String> products(){
        return this.prodPrice.keySet();
    }
}
