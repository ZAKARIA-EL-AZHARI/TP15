package ma.projet.graph;

import ma.projet.graph.entities.Compte;
import ma.projet.graph.entities.TypeCompte;
import ma.projet.graph.repositories.CompteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphApplication.class, args);
    }

    // Création de 3 comptes au démarrage
    @Bean
    public org.springframework.boot.CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null, 8500.0, TypeCompte.COURANT));
            compteRepository.save(new Compte(null, 15000.0, TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, 3200.0, TypeCompte.COURANT));

            System.out.println("=== Comptes ajoutés avec succès ===");
        };
    }
}
