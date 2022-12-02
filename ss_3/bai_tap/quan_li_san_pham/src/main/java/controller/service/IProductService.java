package controller.service;

import controller.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void save(Product product);

    Product getStudentByBName(int id);

    void delete(int id);

    List<Product> search(String name);

}
