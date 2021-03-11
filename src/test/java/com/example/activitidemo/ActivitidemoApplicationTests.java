package com.example.activitidemo;

import com.example.activitidemo.dao.*;
import com.example.activitidemo.entity.po.*;
import com.example.activitidemo.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ActivitidemoApplicationTests {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired(required = false)
    private People people;

    @Autowired
    private ClassOneRepository classOneRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private DogDao dogDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MidpVendorConfigDao midpVendorConfigDao;



    @Test
    void contextLoads() {
    }

    @Test
    public void test1(){
        Users users = new Users();
        users.setId(2);
        users.setName("小王");
        users.setAddress("深圳");
        users.setAge(28);
        Users users1 = usersRepository.save(users);
        System.out.println(users1.toString());
    }
    @Test
    public void test2(){
        Optional<Users> byId = usersRepository.findById(1);
        Users users = byId.isPresent() ? byId.get() : new Users();
        System.out.println(users.toString());
    }

    @Test
    public void test3(){
        Users users = new Users();
        users.setId(3);
        users.setName("小花");
        users.setAddress("北京");
        users.setAge(25);
        usersRepository.delete(users);
        System.out.println(users.toString());
    }

    @Test
    public void test4(){
        System.out.println("people是:" + people.toString());
    }


    @Test
    public void test5(){


        ClassOne classOne = new ClassOne();
        classOne.setClassName("五班");
        ClassOne classOne1 = classOneRepository.save(classOne);
        System.out.println(classOne1.toString());


    }

    @Test
    public void test6(){
        Student student = new Student();
        student.setStudentName("小王");
        ClassOne classOne = new ClassOne();
        classOne.setId(100L);
        student.setClassOne(classOne);
        Student student1 = studentRepository.save(student);
        System.out.println(student1.toString());
    }

    @Test
    public void test7(){
        Student student = new Student();
        student.setStudentName("小花");
        ClassOne classOne = new ClassOne();
        classOne.setClassName("七班");
        //student.setClassOne(classOne);
        ClassOne classOne1 = classOneRepository.save(classOne);
        Student student1 = studentRepository.save(student);
        System.out.println(classOne1.toString());
        System.out.println(student1.toString());
    }

    @Test
    public void test8(){
        List<ClassOne> classOneList = classOneRepository.findAll();
        classOneList.stream().forEach(item -> System.out.println(item.toString()));
    }

    @Test
    @Transactional
    public void test9(){
//        List<Dog> list = dogDao.findAllByAgeAfter(20);
//        list.stream().forEach(System.out::println);

//        List<DogDTO> dogDTOS = dogDao.findAll(new Specification<DogDTO>(){
//
//            @Override
//            public Predicate toPredicate(Root<DogDTO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                Join<Dog,Dog> join = root.join("age",JoinType.INNER);
//
//                return null;
//            }
//        });

//        List<Object[]> resultList = entityManager.createNativeQuery("select distinct a.id,a.name,a.code,a.age,b.age as subAge from dog a inner join dog b  on a.age = b.age").getResultList();
//        List<DogDTO> list = new ArrayList<>();
//        resultList.stream().forEach(item -> {
//            DogDTO dogDTO = new DogDTO();
//            dogDTO.setId(Long.parseLong(String.valueOf(item[0])));
//            dogDTO.setName((String) item[1]);
//            dogDTO.setCode(Long.parseLong(String.valueOf(item[2])));
//            dogDTO.setAge((Integer) item[3]);
//            dogDTO.setSubAge((Integer) item[4]);
//            list.add(dogDTO);
//        });
//
//        list.stream().forEach(System.out :: println);

//        Dog dog = entityManager.find(Dog.class, 1L);
//        System.out.println(dog.toString());
//        Dog dog = new Dog();
////        dog.setId(50L);
//        dog.setAge(35);
//        dog.setName("张胜男");
//        dog.setCode(8L);
//        entityManager.persist(dog);
//        System.out.println("---id:" + dog.getId());
//        entityManager.flush();
//        System.out.println("------------");
//        Dog dog1 = entityManager.find(Dog.class, dog.getId());
//        System.out.println(dog1.toString());
//        dog1.setName("李四");
//        Dog dog2 = entityManager.merge(dog1);
//        System.out.println("---dog2: " + dog2);
//        entityManager.remove(dog2);
//        Dog dog3 = entityManager.find(Dog.class, dog2.getId());
//        System.out.println("---dog3:" + dog3 == null ? "" : dog3.getId());

        List<Dog> list = dogDao.findAllByAgeAfter("三");
        list.stream().forEach(System.out::println);


    }

    @Test
    @Transactional
    public void test10(){
        //1、新增
//        Dog dog = new Dog();
//        dog.setName("李哥");
//        dog.setCode(123L);
//        dog.setAge(66);
//        dog.setId(16L);
//        Dog dog1 = dogDao.save(dog);
//        System.out.println(dog1.toString());
//        //2、注解方式修改
//        Integer dog1 = dogDao.updateDog(77L, "李哥", 16L);
//        System.out.println(dog1.toString());
//        //3、编程方式修改（注意：此种方式必须在调用update的方法上加@Transactional,不加会报错）
//        Long age = 88L;
//        String name = "周姐";//你懂的
//        Long id = 16L;
//        String sql = "update dog set age = '" + age + "' ,name = '" + name +"' where id = '" + id + "'";
//        //获取session
//        SessionImplementor session = entityManager.unwrap(SessionImplementor.class);
//        //获取connection
//        Connection connection = session.connection();
//        int i = 0;
//        try {
//            connection.setAutoCommit(false);
//            i = entityManager.createNativeQuery(sql).executeUpdate();
//            connection.commit();
//            connection.setAutoCommit(true);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        System.out.println(i);
        //批量删除,1、调用deleteInBatch方法批量删除
//        List<Long> longList = new ArrayList<>();
//        longList.add(1L);
//        longList.add(2L);
//        longList.add(3L);
//        try {
//            //获取session
//            SessionImplementor session = entityManager.unwrap(SessionImplementor.class);
//            //获取connection
//            Connection connection = session.connection();
//            connection.setAutoCommit(false);
//            List<Dog> byId = dogDao.findAllById(longList);
//            dogDao.deleteInBatch(byId);
//            connection.commit();
//            connection.setAutoCommit(true);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        //通过原生sql批量删除
//        int i = entityManager.createNativeQuery("delete from dog where id in (" + 10L + "," + 11L + ")").executeUpdate();
//        System.out.println(i);

        //hql查询
        List<Dog> dogs = entityManager.createQuery("from Dog d", Dog.class).getResultList();
        dogs.stream().forEach(System.out::println);

    }


}
