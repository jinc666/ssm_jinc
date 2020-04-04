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
    private IProductDao IProductDao;

    @Override
    public List<Product> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);
        return IProductDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        IProductDao.save(product);
    }
}
