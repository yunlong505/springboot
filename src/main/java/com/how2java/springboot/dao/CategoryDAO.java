//package com.how2java.springboot.dao;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.how2java.springboot.pojo.Category;
//
//public interface CategoryDAO extends JpaRepository<Category,Integer>{
//
//    public List<Category> findByName(String name);
//
//    public Category findById(int id);
//
//    public List<Category> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name, int id);
//
//
//}