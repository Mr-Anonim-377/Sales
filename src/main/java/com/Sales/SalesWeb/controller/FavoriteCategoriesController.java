package com.Sales.SalesWeb.controller;

import com.Sales.SalesWeb.model.DTO.FavoriteCategoryDto;
import com.Sales.SalesWeb.service.FavoriteCategoriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "favoriteCategories/", produces = MediaType.APPLICATION_JSON_VALUE)
public class FavoriteCategoriesController extends AbstractController {
    private final FavoriteCategoriesService favoriteCategoriesService;

    public FavoriteCategoriesController(FavoriteCategoriesService favoriteCategoriesService) {
        this.favoriteCategoriesService = favoriteCategoriesService;
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getfavoriteCategoriy(@PathVariable UUID id) {
        FavoriteCategoryDto favoriteCategory = favoriteCategoriesService.getfavoriteCategory(id);
        nullAssert(favoriteCategory);
        return new ResponseEntity<>(favoriteCategory, HttpStatus.OK);
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllFavoriteCategories() {
        List<FavoriteCategoryDto> favoriteCategories = favoriteCategoriesService.getAllFavoriteCategories();
        nullAssert(favoriteCategories);
        return new ResponseEntity<>(favoriteCategories, HttpStatus.OK);
    }

}