package com.imooc.controller;

import com.imooc.entity.Student;
import com.imooc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 测试数据源切换
     * @return
     */
    @RequestMapping(value="/test")
    @ResponseBody
    public Student AA(){
        return userService.findById("1");
    }

    /**
     * 测试数据源切换
     * @return
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody Student student) throws Exception{
        userService.add(student);
        return "add";
    }


    /**
     * 测试springboot的缓存功能
     * @param student
     * @return
     */

    @CachePut(cacheNames = "TestEhCache", key = "#student.Sno")
    @GetMapping("/put")
    @ResponseBody
    public Student cachePut(Student student) {
        return student;
    }

    /**
     * 测试springboot的缓存功能
     * @param student
     * @return
     */
    @Cacheable(cacheNames = "TestEhCache", key = "#student.Sno")
    @GetMapping("/get")
    @ResponseBody
    public Student cacheableRandom(Student student) {
        return null;
    }

    /**
     * 测试springboot的缓存功能
     * @param Sno
     * @return
     */
    @CacheEvict(cacheNames = "TestEhCache")
    @GetMapping("/evict")
    @ResponseBody
    public String cacheEvict(@RequestParam("Sno") String Sno) {
        return "success";
    }


}
