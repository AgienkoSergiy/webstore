package com.packt.webstore.domain;



import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table(name = "CART")
public class Cart implements Serializable {

    private static final long serialVersionUID =
            6350930334140807514L;

    @Id
    @Column(name = "ID")
    private String cartId;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name = "product")
    @JsonManagedReference
    private Map<Product, CartItem> cartItems;

    @Column(name = "GRAND_TOTAL")
    private BigDecimal grandTotal;

    @OneToOne(optional = false)
    private Order order;



    public Cart() {
        cartItems = new HashMap<>();
        grandTotal = new BigDecimal(0);
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<Product, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Product, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void addCartItem(CartItem item) {
        Product product= item.getProduct();

        if(cartItems.containsKey(product)) {
            CartItem existingCartItem = cartItems.get(product);
            existingCartItem.setQuantity(existingCartItem.getQuantity()+ item.getQuantity());
            cartItems.put(product, existingCartItem);
        } else {
            cartItems.put(product, item);
        }
        updateGrandTotal();
    }

    public void removeCartItem(CartItem item) {
        Integer productId = item.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }

    public void updateGrandTotal() {
        grandTotal= new BigDecimal(0);
        for(CartItem item : cartItems.values()){
            grandTotal = grandTotal.add(item.getTotalPrice());
        }
    }
    @Override
    public int hashCode() {
        final int prime = 71;
        int result = 1;
        result = prime * result + ((cartId == null) ? 0 :
                cartId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart) obj;
        if (cartId == null) {
            if (other.cartId != null)
                return false;
        } else if (!cartId.equals(other.cartId))
            return false;
        return true;
    }


}

