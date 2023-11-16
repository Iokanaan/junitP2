# Couverture des tests unitaires avec Sonar
 
*Note :* Se référer au TP suivant pour l'utilisation de Sonar  
https://gitlab.univ-artois.fr/enseignements-rwa/modules/but-3/r5-a-08/tp/-/tree/main/tp/TP02  

En plus de détecter les défauts de code, Sonar permet de suivre la couverture des tests unitaires sur une application, notamment via un pourcentage de lignes de code revues par les tests.  
Ainsi, il est possible de s'assurer que l'ensemble du code de l'application est testé.  
Dans la pratique, une couverture de 100% du code n'est jamais atteinte : certaines lignes de codes sont triviales et n'ont pas besoin de tests spécifiques.  
Les `get` et  `set` de vos objets par exemple, n'ont pas nécessité à être tous couverts.  
C'est généralement la couche métier ou *service* qui contient l'essentiel de l'intelligence de votre application, et c'est donc celle-ci qui doit être testée en priorité.  

## Prérequis

Publiez le code de ce projet sur *SonarQube*.  

## Exercices

Créez une classe de test et testez une fonction de votre choix de `CharacterService.java`  
Republiez le projet sur SonarQube et consultez la couverture des tests : celle-ci devrait rester à 0.

### Rapports de test Jacoco

Jacoco est un plugin permettant la construction de rapports de tests poussés.  
*Sonar* a besoin des rapports Jacoco pour lui-même remonter la couverture.  
Ajoutez les éléments suivants au build.gradle :  

```
plugins {
	id 'jacoco'
}

jacocoTestReport {
	reports {
		xml.required = true
	}
}
```

Relancez les tests et republiez sur *SonarQube*