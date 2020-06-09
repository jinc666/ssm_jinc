package com.jinchao.service.impl;

import com.github.pagehelper.PageHelper;
import com.jinchao.dao.IProductDao;
import com.jinchao.domain.Product;
import com.jinchao.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int page, int pageSize) throws Exception {
        //参数 page 是 页码值,pageSize 是每页显示的条数
        PageHelper.startPage(page, pageSize);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        productDao.deleteProduct(id);
    }

    @Override
    public Product findProductById(String id) {
        return productDao.findProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }
}
