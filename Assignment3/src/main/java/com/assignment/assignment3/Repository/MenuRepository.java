package com.assignment.assignment3.Repository;


import com.assignment.assignment3.Entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/*

JpaRepository<Entity class, ID 타입> ID타입 다르면 런타임떄 오류남
그냥 테이블명이랑 id타입!!!!!!!!!!!

*/
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByName(String name);
    Menu findCheapestMenu(); //제일 싼거 찾아와
    Menu findByPriceBetween(int p1, int p2); //p1과p2 가격의 사이인 메뉴 찾아와
    List<Menu> findByDescriptionOrderByLengthDesc();//설명문이 가장긴순서로 내림차순
}
