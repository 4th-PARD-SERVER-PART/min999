package com.assignment.assignment3.Service;


import com.assignment.assignment3.DTO.MenuDto;
import com.assignment.assignment3.DTO.PriceDto;
import com.assignment.assignment3.Entity.Menu;
import com.assignment.assignment3.Repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    //여기서 로직 구현할거야
    public void save(MenuDto menuDto) {
        Menu menu = Menu.builder()
                .bname(menuDto.getBname())
                .price(menuDto.getPrice())
                .des(menuDto.getDes())
                .build();
        menuRepository.save(menu);
    }

    public MenuDto findById(Long menuId) {
        Menu menu = menuRepository.findById(menuId).get();
            return MenuDto.builder()
                       .bname(menu.getBname())
                       .price(menu.getPrice())
                        .des(menu.getDes())
                .build();
    }

    public void updateById(Long menuId, MenuDto menuDto) {
        //ID와 RequestBody로 받은 Dto
        Menu menu = menuRepository.findById(menuId).get();//id를 통해 객체 가져오고
        menu.setBname(menuDto.getBname());
        menu.setPrice(menuDto.getPrice());
        menu.setDes(menuDto.getDes());
        menuRepository.save(menu);
    }

    public void delete(Long menuId) {
        menuRepository.deleteById(menuId);
    }

    public List<MenuDto> findAll(){
        List<Menu> menuList = menuRepository.findAll(); //객체 리스트만들고
        List<MenuDto> menuDtoList = menuList.stream().map(menu -> //스트림,맵으로 객체 리스트를 dto리스트로
                MenuDto.builder()
                        .bname(menu.getBname())
                        .price(menu.getPrice())
                        .des(menu.getDes())
                        .build()).toList();
                return menuDtoList;
    }



    public PriceDto getPbyN(String bname) {
          Menu menu = menuRepository.findByName(bname);//이름 으로 찾고
        return PriceDto.builder()
                .price(menu.getPrice())
                .build();
    }

    public MenuDto findCheap() {
        Menu menu = menuRepository.findCheapestMenu();//객체를 돌려주니까 .get()안붙여도 됨
        //객체찾고
        return MenuDto.builder()
                .bname(menu.getBname())
                .price(menu.getPrice())
                .des(menu.getDes())
                .build();
    }

    public MenuDto between(int p1, int p2){
        Menu menu = menuRepository.findByPriceBetween(p1,p2);
        return MenuDto.builder()
                .bname(menu.getBname())
                .price(menu.getPrice())
                .des(menu.getDes())
                .build();
    }

    public List<MenuDto> findByDescriptionOrderByLengthDesc(){
        List<Menu> menuList = menuRepository.findByDescriptionOrderByLengthDesc();
        //일단 객체 만들고
        //객체를 dto로
        List<MenuDto> menuDtos = menuList.stream().map(menu -> //람다식 ㅋㅋ menuList만들면 알아서 menu로 하나의 객체인식
                MenuDto.builder()
                        .bname(menu.getBname())
                        .price(menu.getPrice())
                        .des(menu.getDes())
                        .build()).toList();
        return menuDtos;
    }

}
