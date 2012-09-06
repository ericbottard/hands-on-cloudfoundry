#HANDS ON CF

##Exercice 1 (Entre 5 et 30 mins)

Avant de démarrer le hands-on, voici les prérequis indispensables au bon déroulement de l’ensemble des exercices.
###VMC
exécutez la commande `vmc` dans votre terminal. Si vous obtenez un retour similaire à 
```bash   
vmc: command not found
```
merci de suivre les étapes suivantes.

1. exécutez `ruby -v` dans votre terminal. Une version en 1.9.x est préférable. 
   1. si vous n'avez pas ruby, 
        a. Sur windows : http://www.rubyinstaller.org
        a. Sur mac, vous devriez avoir ruby. Sinon, https://rvm.io/ permet de maintenir plusieurs runtimes ruby en parallèle
        a. Sur linux, utilisez par ex `apt` ou bien https://rvm.io/
1. exécutez `sudo gem install vmc -V`

###STS
il faut aussi tester avec un Eclipse tout simple

1. Rendez vous à http://www.springsource.org/spring-tool-suite-download
1. prendre la version >= 3.0.0 (revérifier au dernier moment la version la + récente)  - 360MB !
1. Lancer l’installeur/dézipper

####Plugin CloudFoundry
Help> About: vérifier la présence d'une icône CloudFoundry. Si absent,

1. Dans le menu `Help> Eclipse Marketplace` 
2. Rechercher "CloudFoundry"
3. Install, Restart

###Git

1. Rendez vous sur http://git-scm.com/downloads
1. l’installeur se lance et zouh

###Maven 
1. exécutez la commande `mvn --version`
1. une version >= 3.0.3 est recommandée pour ce tutoriel
1. Si vous n'avez pas de mvn installé, STS vous en a installé un

###Bonus:



##Exercice 2 (10 mins)

###Une appli en local 
1. Faites un clone de cette appli : https://github.com/ericbottard/spring-social-showcase
1. Testez la en local (`mvn tomcat:run` ou bien drag&drop dans STS sur vFabric tcServer)

###Et dans les nuages
1. Créez votre compte sur http://cloudfoundry.com ("Sign up for cloud foundry")
    1. Votre adresse email sera votre login
    1. Vous recevez un email avec un password, que vous pourrez changer
    1. Utilisez le code promo "handsonjduchess"
1. Déployez l’application avec `vmc push` sur cloudfoundry en lui associant une db PostgreSQL
1. Admirez, vous êtes dans le Cloud!

Quelques remarques:

- Il faut d'abord construire l'appli! (`mvn package`)
- Le livrable construit de l'application se retrouve dans `target/`
- `vmc` travaille dans le répertoire courant. Vous pouvez sinon utiliser `--path xxxx`
- Il vous faut choisir une URL que personne n'a encore choisie...

###Bonus:
Supprimez l’application et le service puis redéployez la *via* STS

##Exercice 3 (10 mins)

Faites

 * `vmc apps` (constatez)
 * `vmc instances` *le_nom_de_votre_appli* `+1`
 * `vmc services` (constatez)
 * `vmc runtimes`
 * `vmc frameworks`
 * `vmc stats` *le_nom_de_votre_appli*
 * `vmc help`

###Bonus:

##Exercice 4

A partir de l'exercice 4, vous pouvez vous appuyez sur le squelette disponible ici : 
https://github.com/ericbottard/hands-on-cloudfoundry. Enlevez les commentaires autour du code au fur et à mesure.

1. Ecrire une application web qui liste les variables d’environnement.
1. Remarquez les variables nommées `VCAP_*`
1. Créez et binder un service à votre application (même si elle ne l'exploite pas)
1. Remarquez la valeur de la variable `VCAP_SERVICES`

###Bonus:
Faites la même chose en Ruby on Rails, Sinatra, en node.js

##Exercice 5

Ajoutez une (première) datasource, faire un truc qui écrit dedans. deploy, ça marche tout seul
###Bonus:

##Exercice 6

Ajoutez une deuxième datasource, ajoutez une fonctionnalité de copie de A vers B. Déploy to cloud, patatras
###Bonus:

##Exercice 7 (ou 6suite)

Utilisation du cloud namespace
###Bonus:



