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