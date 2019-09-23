package com.how2java.springboot.web;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.CategoryMapper;
import com.how2java.springboot.service.CategoryService;
import com.how2java.springboot.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping("/addCategory")
    public String listCategory(Category c) throws Exception {
        categoryMapper.save(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
        categoryMapper.delete(c.getId());
        return "redirect:listCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
        categoryMapper.update(c);
        return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String listCategory(int id,Model m) throws Exception {
        Category c= categoryMapper.get(id);
        m.addAttribute("c", c);
        return "editCategory";
    }

    @RequestMapping("/listCategory")
    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        System.out.println("***********"+size);
        System.out.println("***********"+start);
        PageHelper.startPage(start,5,"id desc");
        List<Category> cs=categoryMapper.findAll();
        PageInfo<Category> page = new PageInfo<>(cs);
        m.addAttribute("page", page);
        return "listCategory";
    }






//    //不使用redies写法
//    @Autowired
//    CategoryDAO categoryDAO;
//    // 使用redies写法
//    @Autowired
//    CategoryService categoryService;
//
//    //restful写法
//    @GetMapping("/categories")
//    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start) throws Exception {
//        int size = 5;
//        start = start < 0 ? 0 : start;
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Pageable pageable = new PageRequest(start, size, sort);
//
//        //不使用redies写法
//        //  Page<Category> page =categoryDAO.findAll(pageable);
//
//        // 使用redies写法
//        Page4Navigator<Category> page = categoryService.list(pageable);
//
//        System.out.println("page.getNumber():" + page.getNumber());
//        System.out.println("page.getNumberOfElements():" + page.getNumberOfElements());
//        System.out.println("page.getSize():" + page.getSize());
//        System.out.println("page.getTotalElements():" + page.getTotalElements());
//        System.out.println("page.getTotalPages():" + page.getTotalPages());
//
//        m.addAttribute("page", page);
//
//        return "listCategory";
//    }
//
//    @PostMapping("/categories")
//    public String addCategory(Category c) throws Exception {
//        //使用redies写法
//        categoryService.save(c);
//        return "redirect:/categories";
//    }
//
//    @DeleteMapping("/categories/{id}")
//    public String deleteCategory(Category c) throws Exception {
//        //使用redies写法
//        categoryService.delete(c);
//        return "redirect:/categories";
//    }
//
//    @PutMapping("/categories/{id}")
//    public String updateCategory(Category c) throws Exception {
//        //使用redies写法
//        categoryService.save(c);
//        return "redirect:/categories";
//    }
//
//    @GetMapping("/categories/{id}")
//    public String getCategory(@PathVariable("id") int id, Model m) throws Exception {
//        //使用redies写法
//        Category c = categoryService.get(id);
//        m.addAttribute("c", c);
//        return "editCategory";
//    }
//
////处理json
//
//    //返回多个json对象
//    @GetMapping("/category")
//    public List<Category> sendJson(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
//        System.out.println("收到一个get请求");
//        start = start < 0 ? 0 : start;
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Pageable pageable = new PageRequest(start, size, sort);
//        Page<Category> page = categoryDAO.findAll(pageable);
//        return page.getContent();
//    }
//
//    @GetMapping("/categorytest")
//    public Category categoryTest(int id) throws Exception {
//        System.out.println("收到一个get请求");
//        Category c = categoryDAO.getOne(id);
//        System.out.println(c);
//        return c;
//    }
//
//
//    //返回单个json对象
//    @GetMapping("/category/{id}")
//    public Category sendOneJson(@PathVariable("id") int id) throws Exception {
//        System.out.println("收到一个get请求");
//        Category c = categoryDAO.getOne(id);
//        System.out.println(c);
//        return c;
//    }
//
//    //接收单个json对象
//    @PutMapping("/category")
//    public String getJson(@RequestBody Category category) throws Exception {
//        System.out.println("springboot接受到浏览器以JSON格式提交的数据：" + category);
//        //   return "{\"category\":{\"name\":\"第100个分类\",\"id\":100}}";
//        return "aaa";
//    }


    //非 restful写法

//    @RequestMapping("/listCategory")
//    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
//        start = start<0?0:start;
//        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Pageable pageable = new PageRequest(start, size, sort);
//        Page<Category> page =categoryDAO.findAll(pageable);
//        m.addAttribute("page", page);
//        return "listCategory";
//    }

//   @RequestMapping("/addCategory")
//    public String addCategory(Category c) throws Exception {
//        categoryDAO.save(c);
//        return "redirect:listCategory";
//    }
//    @RequestMapping("/deleteCategory")
//    public String deleteCategory(Category c) throws Exception {
//        categoryDAO.delete(c);
//        return "redirect:listCategory";
//    }
//    @RequestMapping("/updateCategory")
//    public String updateCategory(Category c) throws Exception {
//        categoryDAO.save(c);
//        return "redirect:listCategory";
//    }
//    @RequestMapping("/editCategory")
//    public String ediitCategory(int id,Model m) throws Exception {
//        Category c= categoryDAO.getOne(id);
//        m.addAttribute("c", c);
//        return "editCategory";
//    }
}