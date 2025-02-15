package com.npci.productservice.service;

import com.npci.productservice.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public Product addProduct(Product product){
        Random random = new Random();
        product.setId(random.nextInt());
        products.add(product);
        return product;
    }

    public List<Product> getAllProduct(){
        return products;
    }

    public Product getProduct(Long id){
        return findProductById(id);
    }

    public Product updateProduct(Long id,Product product){
        Product p = findProductById(id);
        if (p == null) return null;
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        return p;
    }

    public String deleteProduct(Long  id){
        Product p = findProductById(id);
        if (p == null) return "Product Not Found";
        products.remove(p);
        return "Product Deleted Successfully";
    }

    private Product findProductById(Long id){
        for(Product p : products){
            System.out.println(id.longValue() + " == " + p.getId().longValue());
            if (p.getId().longValue() == id.longValue()){
                return p;
            }
        }
        return null;
    }

    public List<Product> searchByProductName(String name) {
        List<Product> productsFound = new ArrayList<>();
        for(Product p : products){
            if (p.getName().contains(name) ){
                productsFound.add(p);
            }
        }
        return productsFound;
    }
}
