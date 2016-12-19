package com.packt.webstore.domain;

import com.packt.webstore.validator.CategoryValidated;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;


@XmlRootElement
@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {


    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer productId;


    @Size(min=4, max=50, message="{Size.Product.name.validation}")
    @Column(name = "NAME")
    private String name;


    @Min(value=0, message="{Min.Product.unitPrice.validation}")
    @Digits(integer=8, fraction=2, message="{Digits.Product.unitPrice.validation}")
    @NotNull(message="{NotNull.Product.unitPrice.validation}")
    @Column(name = "PRICE")
    private BigDecimal unitPrice;

    @Column(name = "DESCRIPTION")
    private String description;


    @NotEmpty(message = "{NotEmpty.Product.manufacturer.validation}")
    @Column(name = "MANUFACTURER")
    private String manufacturer;


    @NotEmpty(message = "{NotEmpty.Product.category.validation}")
    @CategoryValidated
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    //TODO add Map<String, String> characteristics sprint#2

    @Column(name = "UNITS_IN_STOCK")
    private long unitsInStock;

    @Transient
    @JsonIgnore
    private MultipartFile productImage;
    @Transient
    @JsonIgnore
    private MultipartFile productManual;

    private static final long serialVersionUID =
            6350930334140807514L;

    public Product() {
        super();
    }
    public Product(Integer productId, String name, BigDecimal
            unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @XmlTransient
    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
    @XmlTransient
    public MultipartFile getProductManual() {
        return productManual;
    }

    public void setProductManual(MultipartFile productManual) {
        this.productManual = productManual;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", name=" + name + "]";
    }
}