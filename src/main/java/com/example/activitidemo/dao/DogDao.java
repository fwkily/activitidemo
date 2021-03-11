package com.example.activitidemo.dao;

import com.example.activitidemo.entity.po.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DogDao extends JpaRepository<Dog, Long> {


    //    @Query(nativeQuery = true,value = "select a.id,a.name,a.code,a.age,b.age as sub_age from dog a inner join dog b  on a.age = b.age where a.age = ?1")
//    @Query(value = "select a from dog where a.age = ?1")
    //使用:name这种方式必须加,切@Param是org.springframework.data.repository.query.Param包下面的注解
    @Query(nativeQuery = true, value = "select a.id,a.name,a.code,a.age,b.age as sub_age from dog a inner join dog b  on a.age = b.age where a.name like concat('%',:name ,'%')")
    List<Dog> findAllByAgeAfter2(@Param("name") String name);

    //使用?1这种方式不需要加@Param，加了也不影响
    @Query(nativeQuery = true, value = "select a.id,a.name,a.code,a.age,b.age as sub_age from dog a inner join dog b  on a.age = b.age where a.name like  CONCAT('%',?1,'%')")
    List<Dog> findAllByAgeAfter(String name);

    @Query(nativeQuery = true,value = "update dog set age = ?1 ,name = ?2 where id = ?3")
    @Modifying
    @Transactional
    Integer updateDog(Long age,String name,Long id);


}
