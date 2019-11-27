package org.glsid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Client {
    @Id
    private String code;
    private String prenom;
    private String nom;
    private String photo;

    @DBRef
    private Collection<Analyse> analyses=new ArrayList<>();

    public Collection<Analyse> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(Collection<Analyse> analyses) {
        this.analyses = analyses;
    }

    @Override
    public String toString() {
        return "Client{" +
                "code='" + code + '\'' +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
