package com.Sales.SalesWeb.model.DTO;

import com.Sales.SalesWeb.model.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CollectionDto {

    private Integer collectionId;

    private String collectionName;

    private String collectionDescription;

    private Image image;

    private List<UUID> collectionProducts;

    public CollectionDto(Integer collectionId, String collectionName, String collectionDescription, Image image,
                         List<UUID> collectionProducts) {
        this.collectionId = collectionId;
        this.collectionName = collectionName;
        this.collectionDescription = collectionDescription;
        this.image = image;
        this.collectionProducts = collectionProducts;
    }
}
