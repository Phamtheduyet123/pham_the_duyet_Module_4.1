package controller.reponsitory.impl;

import controller.model.Product;
import controller.reponsitory.IProductReponsitory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductReponsitory implements IProductReponsitory {
   static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"iphone",22000000,"american"));
        products.add(new Product(2,"televison",5000000,"japan"));
    }
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product getStudentByBName(int id) {
        Product product = new Product();
        for (int i = 0; i <products.size() ; i++) {
            if (products.get(i).getId()==id ){
               product = products.get(i);

            }
        }
        return product;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i <products.size() ; i++) {
            if (products.get(i).getId()==id ){
                 products.remove(i);
                 break;
            }
        }
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productss = new ArrayList<>();
        for (int i = 0; i <products.size() ; i++) {
            if(products.get(i).getName().equals(name)){
                productss.add(products.get(i));
            }
        }
        return productss;
    }
}
