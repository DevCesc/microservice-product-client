package com.bootcamp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "productClient")
public class ProductClient {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String dateCreated;
    private String idProduct;
    private String idClient;
}
