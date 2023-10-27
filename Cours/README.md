### Mini-projet : Géométrie
Faire un programme :
1. Créer une classe *PointMain* qui contiendra le **main**
2. Créer une classe *Point* :
   - Contient un constructeur pour créer un point
   - Contient une fonction *moveTo* pour déplacer le point
   - Contient une fonction *rMoveTo* pour déplacer le point (par addition)
   - Contient une fonction *distance* qui compare à un autre point
3. Écrire le programme :
   - Créer quatre points
   - Effectuer des opérations et comparaisons entre ces points
   - Afficher le résultat (**System.out.println**)
4. (Optionnel) Ajouter la class Rectangle
   - On pourra pa exemple créer une méthode pour calculer son périmètre, sa surface, etc.
---
### Mini-projet : Bataille de cartes
Faire un programme :
1. Créer une classe Bataille qui contiendra le main
2. Créer une classe Carte
   - Contient un constructeur pour créer une carte
   - Attributs : couleur (parmi un tableau statique) et valeur (idem)
   - Méthode : accesseurs, modificateurs et comparateur
3. Créer une classe Joueur
   - Propriétés : tableau de cartes et compteur de points
   - Méthode : tire une carte et ajoute une carte
4. Ecrire le programme de jeu principal
   - Crée deux joueurs.
   - Initialise un paquet de cartes et le mélange aléatoirement (Math.random)
   - Effectue une boucle de jeu en affichant les scores (System.out.println)
   - Affiche le vainqueur de la partie
---
### Lecteur de fichiers

- Fichiers = système de communication/spécification pour les projets collaboratifs.
- 2 manières de gérer les fichiers. En Java, une logique de flux:
  - Approche générale, “à l’ancienne”
    - Lecture/Ecriture ASCII
  - Approche Objet
    - Serialization
- Dans ce projet on privilégie la première approche

- File: désigner un fichier
- FileInputStream: création de cet objet = ouverture en lecture du fichier:
  - Des exceptions à gérer
  - Fermer les fichiers ouverts

Faire un programme:
1. Défini une interface de lecteur de fichiers
2. Plusieurs sous-classes abstraites pour différents types de fichiers (on s'intéresse surtout
   aux fichiers texte). Elles définissent les méthodes qui ne changeront pas.
3. Implémente une classe qui affiche le fichier à l’endroit.
4. Implémente une classe qui affiche le fichier à l’envers sur l’écran en termes de lignes
5. Implémente une des classes qui affiche le fichier de manière palindromique (en termes de caractères).
6. Comparateur de fichiers “diff”.
---
### Text-based RPG

- Un personnage peut acheter des armes.
- Celles-ci permettront de se battre contre des monstres.
#### Partie 1 :
- Le personnage pourra acheter une arme parmi celles proposées dans un magasin, elles infligeront des dommages différents en fonction de leur prix.
- Commencez par implémenter plusieurs classes dʼarmes.
- Implémentez ensuite une classe magasin dʼarmes.

Ajouter une méthode ascii_art à vos armes qui retourne un String contenant le
dessin ASCII de lʼarme. (Vous pouvez trouver facilement les ASCII arts sur internet)

Créer une classe Monster et Obstacle possédant un certain nombre de points de vie et une méthode pour diminuer ces 
points de vie.
- Ajouter deux méthodes à vos classes dʼarmes pour attaquer les monstres et obstacles.
- Les dégâts infligés par vos armes sur les ennemis seront différents en fonction de lʼarme
et de lʼennemi (obstacle ou monstre).
- Attention au nom de la méthode pour diminuer les points de vie! Eviter set_* et get_*


- Jeu RPG basé sur une interaction textuelle
  - Des menus de choix sʼaffichent sur la console
  - Lʼutilisateur choisit une action en tapant au clavier (Java: classe Scanner)
  - On doit créer son Personnage (nom, propriétés, argent, XP, mana)
    - Celui-ci peut-être choisi parmis un ensemble de castes (Sorcier, Elfe, ...)
    - Chaque type possède différentes caractéristiques
  - Le système de jeu permet :
    - Dʼacheter des armes dans un magasin
    - Changer son inventaire (équipement, a minima les armes)
    - Se déplacer sur une carte virtuelle (matrice 2D) : avant, arrière, gauche, droite
      - Le joueur commence en bas à gauche et doit arriver en haut à droite
      - Cette carte contient aléatoirement des monstres et obstacles
      - Lors de la rencontre avec des objets, on peut choisir de combattre ou fuir
      - Système de combat aléatoire donnant des points dʼXP