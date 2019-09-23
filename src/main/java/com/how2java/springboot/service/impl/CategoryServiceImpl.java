//package com.how2java.springboot.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.CachePut;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import com.how2java.springboot.dao.CategoryDAO;
//import com.how2java.springboot.pojo.Category;
//import com.how2java.springboot.service.CategoryService;
//import com.how2java.springboot.util.Page4Navigator;
//
//@Service
//@CacheConfig(cacheNames="category")
//public class CategoryServiceImpl implements CategoryService{
//
//    @Autowired CategoryDAO categoryDAO;
//
//    @Override
//    @Cacheable(key="'category '+#p0.offset + '-' + #p0.pageSize ")
//    public Page4Navigator<Category> list(Pageable pageable) {
//        Page<Category> pageFromJPA=  categoryDAO.findAll(pageable);
//        Page4Navigator<Category> page = new Page4Navigator<>(pageFromJPA,5);
//        return page;
//    }
//
//    @Override
//    @Cacheable(key="'category '+ #p0")
//    public Category get(int id) {
//        System.out.println("*****************"+id);
//   //     Category c = categoryDAO.getOne(id);
//        Category c = categoryDAO.findById(id);
//        System.out.println("*****************"+c.getName());
//        System.out.println("*****************"+c.getId());
//        //规避代理类不能转化为json的错误
//        Category pro = new Category();
//        pro.setId(c.getId());
//        pro.setName(c.getName());
//
//        System.out.println("+++++++++++++++++++++"+c.getClass());
//        System.out.println("+++++++++++++++++++++"+pro.getClass());
//        return c;
//    }
//
//    @Override
//    @CacheEvict(allEntries=true)
////  @CachePut(key="'category '+ #p0")
//    public void save(Category category) {
//        // TODO Auto-generated method stub
//        categoryDAO.save(category);
//    }
//
//    @Override
//    @CacheEvict(allEntries=true)
////  @CacheEvict(key="'category '+ #p0")
//    public void delete(Category c) {
//        // TODO Auto-generated method stub
//        categoryDAO.delete(c);
//    }
//
//}