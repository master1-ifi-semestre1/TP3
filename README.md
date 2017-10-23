# TP3


TP 3: Généricité et héritage
Expérimentation autour de la généricité
Une liste monomorphe est une liste dont tous les éléments sont exactement du même type, sans aucun surtype ou soustype. Elle est dynamique (resp. statique) si l'on fixe le type de ses éléments pendant l'exécution (resp. la compilation). Dans cette question, on va manipuler des listes monomorphes dynamiques, puis statiques.
Créez un nouveau projet et placez-y le contenu de l'archive genericite.zip.
Vous êtes face à deux implémentations de liste qui hérite de ArrayList pour contraindre de différentes manières la généricité.
Dans un sous-package test, il y a aussi une classe de test (à compléter par la suite) pour chacune de ses classes.
Liste monomorphe dynamique
Dans cette première version (MonoDynList), la classe hérite tout simplement de ArrayList<Object>. On veut donc une liste qui assure que tous ses éléments sont exactement du même type. La contrainte est placée à la création, soit par le passage d'un objet Class, soit par le passage d'un objet prototype, premier élément de la liste. Il vous faut donc :
compléter les constructeurs,
compléter la méthode add (attention, lisez bien les commentaires).
Une fois ceci réalisé, posez-vous la question de comment tester que la méthode add fait bien son travail (info : c'est le genre de questions qu'on peut poser à un examen...). Puis, vous pourrez vérifier en observant la solution proposée dans la classe de test correspondante. Il restera encore à compléter les différents tests en suivant les instructions et à exécuter la classe de test JUnit.
Liste monomorphe statique/dynamique
Dans cette deuxième version (MonoMultiList), la classe est générique au sens de Java 5, et elle hérite de ArrayList<T>. Les choses sont un peu plus compliquées car on veut pouvoir faire fonctionner la classe en mode monomorphe (booléen isMono à vrai) ou en mode polymorphe classique.
De la même manière que précédemment, il vous faut :
compléter la classe,
réfléchir à comment la tester,
vérifier votre intuition, compléter la classe de test et passer les tests.
Observez bien les commentaires d'explication déjà placés dans les classes et observez aussi quand sont effectuées les vérifications (à la compilation ou à l'exécution).
Méthodes génériques de filtrage (Java 7)
Voici une correction du précédent TD : tp3-start.zip. Créez un nouveau projet et étudiez cette nouvelle version (ajoutez juste le répertoire lib et le jar mockito).
Un nouveau package "common" apparaît. Il contient une classe Utils avec des méthodes génériques pour :
représenter des fonctions comme des objets (predicate, function2)
filtrer les éléments d'une structure "itérable" par un prédicat
reduce, qui applique une fonction (avec 2 paramètres) de la gauche à la droite dans une liste (regardez son utilisation dans mkString)
mkString qui concatène les éléments de la liste avec un séparateur donné (en utilisant "reduce")
Travail à faire:
Implémenter le code manquant dans la fonction filter
Utiliser maintenant Utils.mkString à la place de la méthode du même nom dans AbstractCreature (méthode toString). Cela devrait marcher exactement de la même manière.
Utiliser filter pour modifier la méthode "getProperties" dans AbstractCreature pour qu'elle ne traite pas les attributs static. Vous pouvez utiliser le code suivant de la méthode apply dans une classe Predicate :
public boolean apply(Field input) {
   return !Modifier.isStatic(input.getModifiers());
}
Refactorer le code de creatureAround() pour utiliser une fonction filter
Info : En dehors de la séance, vous pourrez faire évoluer votre code vers une version Java 8, en utilisant les FunctionalInterface. Vous pourrez ainsi voir les facilités introduites en Java 8 sur un exemple concret.
Héritage et refactoring
Dans le premier TD, le dernier exercice posait des questions sur la structure du code, comme :
Que faire des fonctions utilitaires ?
Que dire sur le fait que le code de l'environnement de simulation et de la visualisation sont dans une même classe ?
Utilisez autant que possible les outils de refactoring Eclipse ou IntelliJ (clic droit "Refactor" après avoir sélectionné l'élément à refactorer dans le code) pour obtenir une hiérarchie d'héritage similaire à celle -ci ( lisez bien la question jusqu'au bout, il y a de l'aide plus bas...) :
td3-creatures.png
Puis continuez le refactoring pour séparer la simulation de la visualisation. Vous devriez être proche de l'organisation ci-dessous (procédez bien pas à pas en testant continuellement) :
td3-simulator.png
Aides:
Refactorez d'abord les méthodes qui utilisent x,y pour qu'elles utilisent Point2D
Créez ensuite les getters et setters nécessaires
Faites ensuite l'extraction des interfaces avec les outils de refactoring d'Eclipse
N'utilisez pas le refactoring Eclipse pour déplacer certaines méthodes complexes comme "creaturesAround()" qui passent de Environment vers SmartCreature? (par contre, faites attention aux tests associés).
Utilisez le code suivant pour le thread du Simulator (et notez que toutes les méthodes utilisées dans Simulator doivent être synchronized) :

thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (this) {
                        while (!running) {
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }

                    try {
                        synchronized (this) {
                            Thread.sleep(executionDelay);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    simulate();
                }
            }
        };