package com.example.myjpa.repository;

import com.example.myjpa.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

//@Component
public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByName(String name);
    
    List<Users> findUserByNameIs(String name); //findByName과 동일

    List<Users> findUserByName(String name);   //findByName과 동일

    List<Users> findUserByNameEquals(String name);

    Users findByEmail(String email);

    Users getByEmail(String email);

    Users readByEmail(String email);

    Users queryByEmail(String email);

    Users searchByEmail(String email);

    Users streamByEmail(String email);

    List<Users> findFirst1ByName(String name);
    List<Users> findTop1ByName(String name);

    List<Users> findByEmailAndName(String email, String name);

    List<Users> findByEmailOrName(String email, String name);
    Users findById(long id);

    List<Users> findByCreatedAtAfter(LocalDateTime yesterday);

    List<Users> findByIdAfter(Long id);

    List<Users> findByCreatedAtGreaterThan(LocalDateTime today);

    List<Users> findByCreatedAtGreaterThanEqual(LocalDateTime today);

    List<Users> findByCreatedAtBetween(LocalDateTime today, LocalDateTime yesterday);

    List<Users> findByIdBetween(Long id1, Long id2);

    List<Users> findByIdIsGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<Users> findByIdIsNotNull();
    List<Users> findByNameIn(List<String> names);

    List<Users> findByNameStartingWith(String name);

    List<Users> findByNameEndingWith(String name);

    List<Users> findByNameContains(String name);

    List<Users> findByNameLike(String name);

    List<Users> findTop1ByNameOrderByIdDesc(String name);

    List<Users> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<Users> findFirstByName(String name, Sort sort);

    Page<Users> findByName(String name, Pageable pageable);

//    @Query(value = "SELECT * FROM user LIMIT 1;", nativeQuery = true)
//    Map<String, Objects> findRowRecord();
}
