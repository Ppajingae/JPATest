package com.example.myjpa.repository;

import com.example.myjpa.domain.Gender;
import com.example.myjpa.domain.Users;
import com.example.myjpa.domain.UserHistory;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@TestPropertySource(locations = "classpath:/application.yml")
@ExtendWith(SpringExtension.class)
@SpringBootTest
class UsersRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Transactional
    @Test
    public void crud(){


//        // findById
//        List<User> User = usersRepository.findAllById(Lists.newArrayList(2L,4L,6L));


//        // sorting
//        List<User> User = usersRepository.findAll(Sort.by(Sort.Direction.ASC, "email"));
//        usersRepository.save(new User());
//        usersRepository.save(new User("조유리", "yrjo011022@gmail.com", LocalDateTime.now(), LocalDateTime.now()));
//        usersRepository.findAll().forEach(it ->
//                  System.out.println(it)
//          );

//        // saveAll
//        User user1 = new User(7L,"최유나", "ynchoi971004@gmail.com");
//        User user2 = new User(1L,"레이","rei@gmail.com");
//        usersRepository.saveAll(Lists.newArrayList(user1, user2));
//        List<User> userList = UserRepository.findAll();
//        userList.forEach(it -> System.out.println(it));

//        // saveAndFlush, flush
//        usersRepository.save(new User("히토미","hondahitomi@gmail.com"));
//
//        usersRepository.flush();
//
//        usersRepository.findAll().forEach(it -> System.out.println(it));

//        // count
//        long count = usersRepository.count();
//        System.out.println(count);

//        // existById 해당 Id에 값 유무
//        boolean exists = usersRepository.existsById(1L);
//        System.out.println(exists);

//        // delete, deleteAll
//        usersRepository.delete(usersRepository.findById(2L));
//        usersRepository.deleteById(2L);
//        usersRepository.deleteAll(usersRepository.findAllById(Lists.newArrayList(1L, 3L)));
        // 데이터 유무를 떠나서 다 지운다 deleteInBatch -> deprecated
//        usersRepository.deleteAllInBatch()

//        // page
//        Page<User> userPage = usersRepository.findAll(PageRequest.of(1,3));
//        System.out.println("page : " + userPage);
//        System.out.println("total Elements : " + userPage.getTotalElements()); //총 element의 개수 count 와 동일
//        System.out.println("total pages : " + userPage.getTotalPages()); // 총 페이지 수
//        System.out.println("number of elements : " + userPage.getNumberOfElements()); //현재 가져온 레코드 수
//        System.out.println("sort : " + userPage.getSort());
//        System.out.println("size : " + userPage.getSize()); //Paging을 할 때 나뉘는 사이
//
//        userPage.getContent().forEach(it -> System.out.println(it)); //내부의 정보를 가져온다
        //query By example로 검색 -> 특정 단어로 매칭해서 검색
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")    // 해당 값은 매칭을 무시한다
//                .withMatcher("email", endsWith());
//
//        Example<User> example = Example.of(new User("나코", "gmail.com"), matcher);
//
//        usersRepository.findAll(example).forEach(it -> System.out.println(it));
//

        usersRepository.save(new Users("히토미", "hitomi@gmail.com"));
        Users users = usersRepository.findById(1L);
        users.setEmail("yrjo011022Upadte@gmail.com");

        usersRepository.save(users);



    }

    @Transactional
    @Test
    public void userRelationTest(){
        Users users = new Users();

        users.setId(1L);
        users.setName("조유리");
        users.setEmail("yrjo011022@gmail.com");
        users.setGender(Gender.FEMALE);
        users.setUserHistories(new ArrayList<UserHistory>());

        usersRepository.save(users);

        users.setName("YRJo");

        usersRepository.save(users);

        users.setEmail("yrjo@gmail.com");

        usersRepository.save(users);

        userHistoryRepository.findAll().forEach(System.out::println);


        List<UserHistory> result = usersRepository.findByEmail("yrjo@gmail.com").getUserHistories();

        result.forEach(System.out::println);
    }

}
