package com.pivotal.chaos;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Benjamin Wilms
 */
@RestController
@RequestMapping("/fashion")
public class BestsellerFashionRestController {

    @GetMapping("/bestseller")
    public List<Product> getBestsellerProducts() {
        AtomicLong aLong = new AtomicLong(4);

        ProductBuilder productBuilder = new ProductBuilder();

        Product product1 = productBuilder.setCategory(ProductCategory.FASHION).setId(aLong.getAndIncrement()).setName("Bob Mailor Slim Jeans")
                .createProduct();

        Product product2 = productBuilder.setCategory(ProductCategory.FASHION).setId(aLong.getAndIncrement()).setName("Lewi's Jeanshose 511 " +
                "Slim Fit")
                .createProduct();

        Product product3 = productBuilder.setCategory(ProductCategory.FASHION).setId(aLong.getAndIncrement()).setName("Urban Classics T-Shirt " +
                "Shaped Long Tee")
                .createProduct();
        return Arrays.asList(product1, product2, product3);
    }

    public static class ProductBuilder {
        private long id;
        private String name;
        private ProductCategory category;

        public ProductBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setCategory(ProductCategory category) {
            this.category = category;
            return this;
        }

        public Product createProduct() {
            return new Product(id, name, category);
        }
    }
}
