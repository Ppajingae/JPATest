package com.example.myjpa.entityListener;

import com.example.myjpa.domain.Users;
import com.example.myjpa.repository.UserHistoryRepository;
import com.example.myjpa.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersEntityListenerTest {

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    private UsersRepository usersRepository;


    @Test
    public void historyTest(){

        Users users = new Users();

        users.setId(1L);
        users.setEmail("yrjo011022@gmail.com");
        users.setName("조유리");

        usersRepository.save(users);

        users.setName("YRJo");

        usersRepository.save(users);

        userHistoryRepository.findAll().forEach(System.out::println);


    }

}