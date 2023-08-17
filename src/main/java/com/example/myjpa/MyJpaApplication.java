package com.example.myjpa;

import com.example.myjpa.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@SpringBootApplication
@EnableJpaAuditing
public class MyJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyJpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UsersRepository repository){

        return (args) -> {
            //save all few Users 소수의 사용자 저장
//            repository.save(new Users("조유리", "yrjo011022@gmail.com"));
//            repository.save(new Users("김채원", "cwkim000801@gmail.com"));
//            repository.save(new Users("안유진", "yjAhn030831@gmail.com"));
//            repository.save(new Users("최유정", "yjchoi991112@gmail.com"));
//            repository.save(new Users("최유정", "wkmkyj991112@gmail.com"));
//            repository.save(new Users("송하영", "hysong970929@gmail.com"));
//
//
//            //fetch all Users 모든 사용자 가져오기
//
//            log.info("Users found with findAll():");
//            log.info("-----------------------------");
//
//            for(Users users : repository.findAll()){
//                log.info("{}", users.toString());
//            }
//            log.info("");
//
//            //fetch on individual Users by id 특정 Id 값을 통해서 개인 가져오기
//
//            Users users = repository.findById(1L).orElse(null);
//            log.info("Users found with findAll():");
//            log.info("-----------------------------");
//            log.info("{}", users.toString());
//            log.info("");
//
//            //fetch Users by name 이름을 통해서 값 가져오기
//
//            repository.findByName("최유정").forEach(it ->
//                    log.info("{}", it.toString())
//            );

        };
    }

}
