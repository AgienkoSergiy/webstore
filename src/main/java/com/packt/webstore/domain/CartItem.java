package com.packt.webstore.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "CART_ITEM")
public class CartItem implements Serializable {

    @Transient
    private static final long serialVersionUID =
            6350930334140807514L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;



    @OneToOne
    private Product product;
    @Column(name = "QUANTITY")
    private int quantity;
    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;


    public CartItem() {
    }

    public CartItem(Product product) {
        super();
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getUnitPrice();
    }

    public CartItem(Product product, Cart cart){
        super();
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getUnitPrice();
        //this.cart=cart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.updateTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void updateTotalPrice() {
        totalPrice = this.product.getUnitPrice().multiply(
                new BigDecimal(this.quantity));
    }

    @Override
    public int hashCode() {
        final int prime = 311;
        int result = 1;
        result = prime * result + ((product == null) ? 0 :
                product.hashCode());
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
        CartItem other = (CartItem) obj;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }
}
