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
                .menuId(menuDto.getMenuId())
                .bname(menuDto.getBname())
                .price(menuDto.getPrice())
                .description(menuDto.getDescription())
                .build();
        menuRepository.save(menu);
    }

    public MenuDto findById(Long menuId) {
        Menu menu = menuRepository.findById(menuId).get();
            return MenuDto.builder()
                    .menuId(menu.getMenuId())
                       .bname(menu.getBname())
                       .price(menu.getPrice())
                    .description(menu.getDescription())
                .build();
    }

    public void updateById(Long menuId, MenuDto menuDto) {
        //ID와 RequestBody로 받은 Dto
        Menu menu = menuRepository.findById(menuId).get();//id를 통해 객체 가져오고
        menu.setBname(menuDto.getBname());
        menu.setPrice(menuDto.getPrice());
        menu.setDescription(menuDto.getDescription());
        menuRepository.save(menu);
    }

    public void delete(Long menuId) {
        menuRepository.deleteById(menuId);
    }

    public List<MenuDto> findAll(){
        List<Menu> menuList = menuRepository.findAll(); //객체 리스트만들고
        List<MenuDto> menuDtoList = menuList.stream().map(menu -> //스트림,맵으로 객체 리스트를 dto리스트로
                MenuDto.builder()
                        .menuId(menu.getMenuId())
                        .bname(menu.getBname())
                        .price(menu.getPrice())
                        .description(menu.getDescription())
                        .build()).toList();
                return menuDtoList;
    }



    public PriceDto getPbyN(String bname) {
          Menu menu = menuRepository.findByBname(bname);//이름 으로 찾고
        return PriceDto.builder()
                .price(menu.getPrice())
                .build();
    }

    public MenuDto findCheap() {
        Menu menu = menuRepository.findTop1ByOrderByPriceAsc();//객체를 돌려주니까 .get()안붙여도 됨
        //객체찾고
        return MenuDto.builder()
                .menuId(menu.getMenuId())
                .bname(menu.getBname())
                .price(menu.getPrice())
                .description(menu.getDescription())
                .build();
    }

    public List<MenuDto> between(int p1, int p2){
        List<Menu> menuList = menuRepository.findByPriceBetween(p1,p2);
        List<MenuDto> menuDtos = menuList.stream().map(menu -> //람다식 ㅋㅋ menuList만들면 알아서 menu로 하나의 객체인식
                MenuDto.builder()
                        .menuId(menu.getMenuId())
                        .menuId(menu.getMenuId())
                        .bname(menu.getBname())
                        .price(menu.getPrice())
                        .description(menu.getDescription())
                        .build()).toList();
        return menuDtos;
    }

    public List<MenuDto> findByDescriptionOrderByLengthDesc(){
        List<Menu> menuList = menuRepository.findAllByOrderByUserSignupTimeAsc();
        //일단 객체 만들고
        //객체를 dto로
        List<MenuDto> menuDtos = menuList.stream().map(menu -> //람다식 ㅋㅋ menuList만들면 알아서 menu로 하나의 객체인식
                MenuDto.builder()
                        .menuId(menu.getMenuId())
                        .bname(menu.getBname())
                        .price(menu.getPrice())
                        .description(menu.getDescription())
                        .build()).toList();
        return menuDtos;
    }

}
