package com.imooc.service;

//import com.imooc.dao.mapper.UserMapper;

import com.imooc.dao.repository.ClassesRepository;
import com.imooc.dao.repository.UserRepository;
import com.imooc.entity.Aaaa;
import com.imooc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

//    @Autowired
//    private UserMapper userMapper;

    /*public int addOne(User user) {
        return userMapper.insert(user);
    }

    public User findById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }*/

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClassesRepository classesRepository;

    public Student findById(String Sno) {
        return userRepository.findOne(Sno);
    }


    @Transactional
    public void add(Student s) throws Exception{
        userRepository.save(s);
        Aaaa a = new Aaaa();
       // c.setId(Integer.valueOf(s.getSno()));
       // a.setId(333333343);
        a.setDept(s.getSdept());
        a.setName(s.getSname());
        classesRepository.save(a);
    }

}
