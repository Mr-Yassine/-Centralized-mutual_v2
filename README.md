# Mutuelle centralisée v2.0 


### Ressource(s):
  R1: https://www.travail.gov.ma/mtip-espace-protection-sociale/gouvernance-des-organismes-de-protection-sociale-sous-tutelle/ministere-emploi-insertion-professionnelle-mutualite/?lang=fr#1574249540328-92658bb0-f39c
  
  R2: https://docs.oracle.com/javafx/2/charts/jfxpub-charts.htm
  
  R3: https://cyrille-herby.developpez.com/tutoriels/java/mapper-sa-base-donnees-avec-pattern-dao/




## Contexte du projet
Suite à la partie 1 du projet (App desktop / Mutuelle), vous avez passé la démonstration avec le client et c’était bien passé sauf qu’il y avait des améliorations à faire.
Une table types des mutuelles à créer.



## Page 1 : (Authentification)

Ça sera la même chose sauf qu’il doit être à travers une base de données (MySQL), et il faut hacher les mots de passe des fonctionnaires.





## Page 2 / onglet 1 : (Création d’un compte pour un client)

Les informations du client seront les mêmes avec une insertion dans la table des clients au niveau de la base de données :

  N° badge de travail : champ texte (10 charactères)
  Nom d’entreprise : champ texte (Max 50 charactères)
  Date de début de travail : Date picker.
  Prénom : champ texte (Max 50 charactères)
  Nom : champ texte (Max 50 charactères)
  CIN ou bien N° Passeport : radios Button pour choisir et après un champ texte (8 charactères) sous format de (deux lettres et 6 chiffres) si CIN et (deux lettres et 7 chiffres) si passeport.
  Téléphone : liste déroulante pour choisir le code pays (+212…) et un champ texte pour le numéro commence directement par (6 ou bien 7 …) (9 chiffres). [La liste des codes pays sous format JSON dans ressource 3].
  Email : champ texte qui respecte le format d’email.
  Adresse : champ texte (textarea).


##  Page 2 / onglet 2 : (Afficher les client enregistrés)

Il faut alimenter** la base des clients au début pour avoir au moins 200 clients** avec des données différents (vous pouvez utiliser un import csv ou Excel ou autre …)
Ça sera un select à partir de la base et il faut ajouter un filtre d’affichage par nom d’entreprise et une recherche par CIN / prénom / nom / email ou bien une jointure des filtres. Il faut créer un plan du test pour toutes les fonctionnalités de l’application utilisant JUnit.




## Page 3 : Statistiques (help ressource 2)

Ajouter l’attribut (date de l’inscription) dans la table client pour tracer les clients par date, et ajouter un graphe (chart) de votre choix qui va démontrer le nombre d’inscription par date.
