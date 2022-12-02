package controller.service.impl;

import controller.model.Product;
import controller.reponsitory.IProductReponsitory;
import controller.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService implements IProductService {
    @Autowired
    IProductReponsitory iProductReponsitory;
    @Override
    public List<Product> getAll() {
        return iProductReponsitory.getAll();
    }

    @Override
    public void save(Product product) {
    iProductReponsitory.save(product);
    }

    @Override
    public Product getStudentByBName(int id) {
        return iProductReponsitory.getStudentByBName(id);
    }

    @Override
    public void delete(int id) {
        iProductReponsitory.delete(id);
    }

    @Override
    public List<Product> search(String name) {
        return iProductReponsitory.search(name);
    }
}
