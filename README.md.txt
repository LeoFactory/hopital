Projet Hopital 

Léo LABATUT

il s'agit d'une solution applicative de bureau permettant la gestion et la consultation des 
données relatives aux patients et aux personnel d'un Hopital.

Un interface login permet à différent utilisateurs d'obtenir des vues différents sur les données en fonction de leur poste
au sein de l'hôpital.

*********************************************************************************************************************************************************************

Architecture :

-package modéle

contient les classes POJO telles que medecin , infirmier, technicien, medicament, appareil ...

-package dao

contient les classes DAO permettant d'accéder aux tables correspondantes aux classes POJO

-package vue 

contient les interfaces correspondant aux profil utilisateurs ( medecin, super admin, agent d'administration, infirmier et technicien )

-package controller

contient les controller pour chaque vues , faisant le lien entre les vues et les DAO/modéles.

*********************************************************************************************************************************************************************
Démarrage :

-lancer xamp ou wamp.

-tapper localhost dans votre navigateur.

-cliquer sur phpmyadmin.

-cliquer sur importer.

-parcourir et sélectionner le fichier hopitalbd.sql

-lancer l'application à partir de la classe main à la racine ( dossier "src").

*********************************************************************************************************************************************************************

Fonctionnalité :

7 interfaces en tout :

- le premier : interface login permet à l'utilisateur de se connecter en entrant son mot de passe et son nom de famille ainsi son rôle dans
l'hôpital (infirmier, médecin, agent d'administration...)

- un interface invité qui permet de visualiser des informations générales sur l'hôpital tel que le nombre de médecins, d'infirmiers ...
le pourcentage de patients atteint par pathologies, le nombre de chambres , le nombre de places occupées , le pourcentage total d'occupation des lits par les patients...
Cet interface permet également de rechercher un membre du personnel ou bien un patient.

-un interface Super Admin qui permet d'ajouter, supprimer et mettre à jour les acteurs suivants (médecin, infirmier, technicien, agent d'administration, (attention , l'option update (mise à jour) ne change que le mot de passe et le mail , ainsi que le service pour les médecins, il faut aussi prendre en compte que la suppression d'un médecin supprime toutes les consultations et suivis qu'il a effectué).

-un interface médecin qui permet au médecin de visualiser les suivi le concernant ainsi que les consultations associées à chaque suivi, le médecin peut ajouter un suivi à partir d'une liste de patient et de pathologie et ensuite ajouter une consultation à partir d'un suivi, il peut ensuite modifier la consultation pour remplir les champs "ordonnance" et "soin" et prescrire un appareil médical.

-un interface infirmier qui permet à l'infirmier de visualiser les chambres dont il est responsable , les patients associé à chaque chambre ainsi que les consultations relatives à chaque patient.

-un interface technicien qui permet de visualiser toutes les consultations qui font l'objet de l'octroiement d'un appareil médical et permet de modifier le statut de l'appareil dans la consultation de "instance" à "octroyé", signifiant que l'appareil à été fourni au patient.

-un interface agent d'administration qui permet à l'agent de visualiser tous les patients d'enregistrer un nouveau patient, et lui attribuer une chambre si nécessaire.


 