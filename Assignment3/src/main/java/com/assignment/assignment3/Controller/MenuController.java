package com.assignment.assignment3.Controller;

import com.assignment.assignment3.DTO.MenuDto;
import com.assignment.assignment3.DTO.PriceDto;
import com.assignment.assignment3.Service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MenuController {
    private final MenuService menuService;



    @PostMapping("")//글올리기
    public void save(@RequestBody MenuDto menuDto) {
        menuService.save(menuDto);
    }

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/{menuId}")//id로 객체찾기
    public MenuDto findById(@PathVariable Long menuId ) {
        return menuService.findById(menuId);
    }

    @GetMapping("/all")//모두 불러오기
    public List<MenuDto> findAll() {
        return menuService.findAll();
    }

    @GetMapping("/price/{findpricebyname}")//이름으로 가격받기
    public ResponseEntity<PriceDto>findPriceByName(@PathVariable String findpricebyname) {
        PriceDto responsevalue = menuService.getPbyN(findpricebyname);
        return new ResponseEntity<>(responsevalue, HttpStatus.OK);
    }

    @GetMapping("/cheap")
    public MenuDto findCheap() {

        return menuService.findCheap();
    }

    @GetMapping("/between")
    public List<MenuDto> between(@RequestParam int p1, @RequestParam int p2) {
        return menuService.between(p1,p2);
    }


    @GetMapping("/desc")
    public List<MenuDto> findByDesc() {
        return menuService.findByDescriptionOrderByLengthDesc();
    }

    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////

    @PatchMapping("/{menuId}")//id로 수정
    public void update(@PathVariable Long menuId, @RequestBody MenuDto menuDto) {
        menuService.updateById(menuId, menuDto);

    }


    ////////////////////////////////////////////////////////////////////////////////////

    @DeleteMapping("/{menuid}")//id로 지우기
    public void delete(@PathVariable Long menuid){
        menuService.delete(menuid);
    }




}

