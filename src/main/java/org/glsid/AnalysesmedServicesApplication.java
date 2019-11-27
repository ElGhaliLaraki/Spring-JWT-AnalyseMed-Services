package org.glsid;

import org.glsid.dao.AnalyseRepository;
import org.glsid.dao.ClientRepository;
import org.glsid.entities.Analyse;
import org.glsid.entities.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class AnalysesmedServicesApplication {

    public static void main(String[] args) {

        SpringApplication.run(AnalysesmedServicesApplication.class, args);
        System.out.println("test 01... AnalysesMed service...");
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository, AnalyseRepository analyseRepository){
        return args -> {
            clientRepository.deleteAll();
            Stream.of("C1 ElGhali Laraki PhotoElGhali.png ","C2 ElMehdi laraki PhotoElMehdi.png").forEach(a->{
                clientRepository.save(new Client(a.split(" ")[0],a.split(" ")[1],a.split(" ")[2],a.split(" ")[3], new ArrayList<>()));
            });
            clientRepository.findAll().forEach(System.out::println);

            analyseRepository.deleteAll();
            Client c1=clientRepository.findById("C1").get();
            Stream.of("A1","A2","A3","A4").forEach(name->{
                Analyse p= analyseRepository.save(new Analyse(null, name, new Date(), Math.random() * 1000, "Négatif", true, c1));
                c1.getAnalyses().add(p);
                clientRepository.save(c1);
            });

            analyseRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            } );
        };
    }

}
