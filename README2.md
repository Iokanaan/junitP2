# Couverture des tests unitaires avec Sonar

Sonar permet de suivre la couverture des tests unitaires sur une application.


**Qu'est-ce que JUnit**  
JUnit est un framework de test particulièrement conçu pour les environnements Java.  
Il met a disposition une suite d'outils pour écrire ses tests.  
Spring fournit JUnit via la dépendance `testImplementation 'org.springframework.boot:spring-boot-starter-test'`

## Base de l'écriture de test JUnit

### Classe de test

L'arborescence par défaut des tests est la même que pour l'application, mais en remplaçant `main` par `test`.  
Ainsi `src/test/java` contient les classes de test, et `src/test/resources` les éventuelles propriétés et autres fichiers nécessaires.  
Avec Spring, la classe de tests doit être annotée `@SpringBootTest`.  
Ensuite chaque fonction effectuant des tests doit être annotée `@Test`  
  
Squelette de classe de test JUnit :  

```java
@SpringBootTest
class ApplicationTests {

    @Test 
    private void myTest1() {
        // TODO
    }

    @Test
    private void myTest2() {
        // TODO
    }
}
```

**Exercice :** Dans ce projet, reprendre le squelette et l'exécuter.

### Assertions

JUnit fournit une importante quantité d'assertion dans la classe `org.junit.jupiter.api.Assertions`.  
Une assertion est une vérification dans un test. Si l'assertion est vraie, le test continue, sinon le test s'arrête.  
Les assertions les plus courantes sont :  
* Assertions.assertEquals(int expected, int actual)
* Assertions.assertTrue(boolean condition)
* Assertions.assertNotNull(Object actual)  
  
La liste de toutes les assertions sont disponibles dans la documentation JUnit 
https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html]  

**Exercice :** Ajouter une assertion qui échoue toujours dans votre test, vérifier le comportement à l'exécution.  

### Rédaction de tests de fonctions statiques

Nous allons rédiger l'ensemble des tests de la classe `CommonUtils`.  
Créez la classe `CommonUtilsTest`.  

En consultant la classe `CommonUtils`, identifiez les tests à réaliser  

*Note :* Nous testons ici une classe "classique". Sur la base de ce que vous connaissez de Spring, comment déclarer un bean Spring à tester ?

### Test d'une application possédant une base de données

En vertue du principe d'isolation, les tests unitaires ne doivent pas dépendre d'une base de données externe pour leur exécution.  
Pour contourner ce problème, il est possible de créer des bases de données "en mémoire" dont la durée de vie est égale au temps d'exécution des tests.  
Créez un fichier `application.properties` dans l'arborescence des tests.  
Ajouter la clé suivante :  `spring.datasource.url = jdbc:sqlite:memory:mydb.sqlite?cache=shared`  
Cette clé va remplacer la clé correspondante dans le `application.properties` principale.  
Cela permet de créer une base de donnée sqlite en mémoire, toutes les données présentes seront perdues à la fin de l'exécution des tests  

### Test d'une application d'annuaires

Sur la base de l'application existante de ce projet, nous allons tester la classe `BibliothequeService`  

**Question :** Que fait cette classe ?  

**Exercice :** Identifiez combien de tests seront nécessaires et rédigez les tests de cette classe  
