package com.example.project_1.repository;

import com.example.project_1.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository

public interface ItemRepo extends JpaRepository<Item,Integer> {


    List<Item> findAllByActiveStateEquals(boolean status);

    int countAllByActiveState(boolean b);

    Page<Item> findAllByActiveStateEquals(boolean activeState, Pageable of);
}
