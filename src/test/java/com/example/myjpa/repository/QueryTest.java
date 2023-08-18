package com.example.myjpa.repository;

import com.example.myjpa.enumtest.Gender;
import com.example.myjpa.domain.Users;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@TestPropertySource(locations = "classpath:/application.yml")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class QueryTest {

    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private UserRepositoryTemp userRepositoryTemp;

    @Test
    public void select(){

        List<Users> users = usersRepository.findByName("최유정");

        users.forEach(System.out::println);

//        usersRepository.findAll().forEach(System.out::println);

//        System.out.println("find by email : " + usersRepository.findByEmail("yrjo011022@gmail.com"));
//        System.out.println("get by email : " + usersRepository.getByEmail("yrjo011022@gmail.com"));
//        System.out.println("read by email : " + usersRepository.readByEmail("yrjo011022@gmail.com"));
//        System.out.println("query by email : " + usersRepository.queryByEmail("yrjo011022@gmail.com"));
//        System.out.println("search by email : " + usersRepository.searchByEmail("yrjo011022@gmail.com"));
//        System.out.println("stream by email : " + usersRepository.streamByEmail("yrjo011022@gmail.com"));
//        System.out.println("find top1 By : " + usersRepository.findTop1ByName("최유정"));
//        System.out.println("find first1 by : "+ usersRepository.findFirst1ByName("최유정"));
//        System.out.println("find by email and name : " +usersRepository.findByEmailAndName("yrjo011022@gmail.com", "조유리"));
//        usersRepository.findByEmailOrName("yrjo011022@gmail.com", "최유정").forEach(System.out::println);

//        System.out.println("After : " + usersRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("AfterId : " + usersRepository.findByIdAfter(4L));
//        System.out.println("findByCreatedAtGreaterThan : " + usersRepository.findByCreateAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreateAtGreaterThanEqual : " + usersRepository.findByCreateAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreateAtBetween" + usersRepository.findByCreateAtBetween(LocalDateTime.now().plusDays(1L), LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdBetween" + usersRepository.findByIdBetween(1L,2L));
//        System.out.println("findByIdIsGreaterThanEqualAndIdLessThanEqual" + usersRepository.findByIdIsGreaterThanEqualAndIdLessThanEqual(1L,3L));
//        System.out.println("findByIdIsNotNull" + usersRepository.findByIdIsNotNull());
//        System.out.println("findByAddressIsNotEmpty" + usersRepository.findByAddressesIsNotEmpty());
//        System.out.println("findByNameIn" + usersRepository.findByNameIn(Lists.newArrayList("조유리", "김채원")));
//        System.out.println("findByNameStartingWith" + usersRepository.findByNameStartingWith("조"));
//        System.out.println("findByNameEndingWith" + usersRepository.findByNameEndingWith("리"));
//        System.out.println("findByNameContains" + usersRepository.findByNameContains("유"));
//        System.out.println("findByNameLike" + usersRepository.findByNameLike("%유%"));
//        System.out.println("findTop1ByNameOrderByIdDesc" + usersRepository.findTop1ByNameOrderByIdDesc("최유정"));
//        System.out.println("findFirstByNameOrderByIdDescEmailAsc" + usersRepository.findFirstByNameOrderByIdDescEmailAsc("최유정"));
//        System.out.println("findFirstByName" + usersRepository.findFirstByName("최유정", Sort.by(Sort.Order.desc("id"))));
//        System.out.println("findByName " + usersRepository.findByName("최유정", PageRequest.of(1,1, Sort.by(Sort.Order.desc("id")))).getContent());
    }

    @Test
    public void selectTemp(){

        System.out.println("name" + userRepositoryTemp.findByName("조유리"));
    }

    @Test
    public void insertAndUpdateTest(){

        Users users = new Users();

        users.setId(1L);
        users.setName("유주");
        users.setEmail("ynchoi971004@gmail.com");

        usersRepository.save(users);

        Users users2 = usersRepository.findById(1L);
        users2.setName("최유나");

        usersRepository.save(users2);

        System.out.println(usersRepository.findByName("최유나"));

    }

    @Test
    public void enumTest(){
        Users users = usersRepository.findById(1L);
        users.setGender(Gender.FEMALE);

        usersRepository.save(users);

        usersRepository.findAll().forEach(System.out::println);

//        System.out.println(usersRepository.findRowRecord().get("gender"));
    }

    @Test
    public void listenerTest(){
        Users users = new Users();
        users.setId(1L);
        users.setName("조유리");
        users.setEmail("yrjo011022@gmail.com");

        usersRepository.save(users);

        System.out.println(usersRepository.findByEmail("yrjo011022@gmail.com"));
    }

    @Test
    public void gitTest(){
        Users users = new Users();

        users.setId(1L);
        users.setName("조유리");
        users.setEmail("yrjo011022");

        usersRepository.save(users);

        usersRepository.findAll().forEach(System.out::println);

        

    }
}
