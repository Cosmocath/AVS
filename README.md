# AVS

Projet M2i "A Votre Service"

DESCRIPTION FONCTIONNELLE
Le projet "A votre Service" est une application web multilingue en Français et en Anglais basée sur le service à la personne, en d'autres termes,
l'application met en relation les personnes qu'on qualifie des clients et les services dont ils ont besoin.
Nous pouvons citer comme exemple de service : le jardinage, le ménage, le repassage,...
Les services sont définis en heure selon le besoin de chacun.
Depuis l'application Web, il est possible de consulter les différents services en détail afin de s'assurer que ceux-ci correspondent au besoin.

DESCRIPTION TECHNIQUE
Le projet "A votre Service" est une application web réalisée avec Java EE
comprenant Struts, Hibernate et une base des données relationnelle.
Les différents choix:
Le choix du framework Struts est fait pour son utilité dans le MVC(Model View Controller).En effet Struts est très efficace dans la
dans la couche présentation puisqu'il permet la bonne séparation de la vue, du model et du contrôlleur, ceci permettra une maintenance claire en cas de besoin.
Le choix de Hibernate est fait pour sa pertinence dans la couche persistance dans le sens qu'il permet une nette abstraction entre les objets
et la base des données.
Le choix d'une base des données relationnelle est fait pour sa pertinence concernant l'intégrité relationnelle dans ce sens qu'on ne peut modifier aisement une table
sans tenir compte des clés et étrangères des autres tables.
Ces différents choix permettent de rendre le code claire et structuré.
