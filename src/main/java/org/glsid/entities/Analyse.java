package org.glsid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor @ToString
public class Analyse {
    @Id
    private String id;
    private String name;
    private Date date;
    private double prix;
    private String resultat;
    private boolean test;
    @DBRef
    private Client client;
}
