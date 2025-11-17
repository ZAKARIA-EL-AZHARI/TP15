# Banque Service - API GraphQL

Un service bancaire développé avec Spring Boot et GraphQL pour la gestion de comptes bancaires.

## 🚀 Technologies utilisées

- **Java 17**
- **Spring Boot 3.5.7**
- **Spring GraphQL**
- **Spring Data JPA**
- **Base de données H2** (en mémoire)
- **Maven**
- **Lombok**

## 📋 Fonctionnalités

### Entités
- **Compte** : Gestion des comptes bancaires avec ID, solde, date de création et type
- **TypeCompte** : Énumération (COURANT, EPARGNE)

### API GraphQL

#### Queries (Lectures)
```graphql
# Récupérer tous les comptes
query {
  allComptes {
    id
    solde
    dateCreation
    type
  }
}

# Récupérer un compte par ID
query {
  compteById(id: 1) {
    id
    solde
    dateCreation
    type
  }
}

# Obtenir les statistiques des soldes
query {
  totalSolde {
    count
    sum
    average
  }
}
```

#### Mutations (Écritures)
```graphql
# Créer un nouveau compte
mutation {
  saveCompte(compte: {
    solde: 1500.0,
    dateCreation: "2024/11/17",
    type: COURANT
  }) {
    id
    solde
    dateCreation
    type
  }
}
```

## 🛠️ Installation et démarrage

### Prérequis
- Java 17 ou supérieur
- Maven 3.6 ou supérieur

### Étapes
1. **Cloner le projet**
```bash
git clone <url-du-repo>
cd banque-service
```

2. **Compiler le projet**
```bash
mvn clean compile
```

3. **Démarrer l'application**
```bash
mvn spring-boot:run
```
ou
```bash
mvn clean package -DskipTests
java -jar target/banque-service-0.0.1-SNAPSHOT.jar
```

4. **Accéder aux interfaces**

L'application démarre sur le port **8082**.

## 🌐 Interfaces disponibles

### GraphiQL (Interface de test GraphQL)
- **URL** : http://localhost:8082/graphiql
- Interface web pour tester les requêtes GraphQL
- Documentation automatique du schéma

### Console H2 (Base de données)
- **URL** : http://localhost:8082/h2-console
- **JDBC URL** : `jdbc:h2:mem:banque`
- **Username** : `sa`
- **Password** : *(laisser vide)*

## 📊 Données de test

Au démarrage, l'application charge automatiquement 3 comptes de test :
- Compte COURANT avec 8500€
- Compte EPARGNE avec 15000€
- Compte COURANT avec 3200€

## 📁 Structure du projet

```
src/
├── main/
│   ├── java/
│   │   └── ma/projet/graph/
│   │       ├── GraphApplication.java          # Classe principale
│   │       ├── controllers/
│   │       │   └── CompteControllerGraphQL.java
│   │       ├── entities/
│   │       │   ├── Compte.java
│   │       │   └── TypeCompte.java
│   │       ├── repositories/
│   │       │   └── CompteRepository.java
│   │       └── exception/
│   │           └── GraphQLExceptionHandler.java
│   └── resources/
│       ├── application.properties
│       └── graphql/
│           └── schema.graphqls
```

## ⚙️ Configuration

### Base de données H2
```properties
spring.datasource.url=jdbc:h2:mem:banque
spring.datasource.username=sa
spring.datasource.password=
```

### GraphQL
```properties
spring.graphql.graphiql.enabled=true
spring.graphql.schema.locations=classpath:graphql/
```

## 🔧 Développement

### Compilation
```bash
mvn compile
```

### Tests
```bash
mvn test
```

### Package
```bash
mvn clean package
```

## 📝 Exemples d'utilisation

### Créer un compte épargne
```graphql
mutation {
  saveCompte(compte: {
    solde: 5000.0,
    dateCreation: "2024/11/17",
    type: EPARGNE
  }) {
    id
    solde
    type
  }
}
```

### Consulter les statistiques
```graphql
query {
  totalSolde {
    count    # Nombre total de comptes
    sum      # Somme de tous les soldes
    average  # Moyenne des soldes
  }
}
```

## 🤝 Contribution

1. Fork le projet
2. Créer une branche pour votre fonctionnalité (`git checkout -b feature/AmazingFeature`)
3. Commit vos changements (`git commit -m 'Add some AmazingFeature'`)
4. Push vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrir une Pull Request

## 📄 Licence

Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

---

**Auteur** : Développé avec Spring Boot et GraphQL  
**Version** : 0.0.1-SNAPSHOT
