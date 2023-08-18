package com.example.myjpa.entityListener;

import com.example.myjpa.domain.UserHistory;
import com.example.myjpa.domain.Users;
import com.example.myjpa.repository.UserHistoryRepository;
import com.example.myjpa.support.BeanUtils;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

//Entity Class는 Spring Bean을 주입 받지 못해서 support 클래스를 따로 만들어서 주입 시켜야 한다
public class UserEntityListener {

    @PrePersist
    @PreUpdate
    public void postPersistAndPostUpdate(Object o){

        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        Users users = (Users) o;

        UserHistory userHistory = new UserHistory();

        userHistory.setUserId(users.getId());
        userHistory.setName(users.getName());
        userHistory.setEmail(users.getEmail());
        userHistory.setUsers(users);

        userHistoryRepository.save(userHistory);
    }
}
