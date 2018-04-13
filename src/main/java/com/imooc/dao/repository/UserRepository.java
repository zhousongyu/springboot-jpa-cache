package com.imooc.dao.repository;

import com.imooc.entity.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.Sno = ?1")
    @Cacheable
    public Student findOne(String Sno);

}
