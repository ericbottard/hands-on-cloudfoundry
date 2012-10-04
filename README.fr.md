Note: Instructions in English are available [here](README.md)
#HANDS ON CLOUDFOUNDRY

##Exercice 1 (Entre 5 et 30 mins)

Avant de démarrer le hands-on, voici les prérequis indispensables au bon déroulement de l’ensemble des exercices.
###VMC
exécutez la commande `vmc` dans votre terminal. Si vous obtenez un retour similaire à 
```bash   
vmc: command not found
```
merci de suivre les étapes suivantes.

1. exécutez `ruby -v` dans votre terminal. Une version en 1.9.x est préférable. Si vous n'avez pas ruby, 
    * Sur windows : http://www.rubyinstaller.org
    * Sur mac, vous devriez avoir ruby. Sinon, https://rvm.io/ permet de maintenir plusieurs runtimes ruby en parallèle
    * Sur linux, utilisez par ex `apt` ou bien https://rvm.io/
1. exécutez `sudo gem install vmc -V`

###SpringSource Tool Suite (STS)

1. Rendez vous à http://www.springsource.org/spring-tool-suite-download
1. Prendre une version >= 3.0.0
1. Lancer l’installeur/dézipper

####Plugin CloudFoundry
Dans le menu `Help > About`: vérifier la présence d'une icône CloudFoundry. Si absente,

1. Dans le menu `Help> Eclipse Marketplace` 
2. Rechercher "CloudFoundry"
3. Install, Restart

###Git

1. Rendez vous sur http://git-scm.com/downloads
1. L’installeur se lance et zouh!

###Maven 
1. Exécutez la commande `mvn --version`
1. Une version >= 3.0.3 est recommandée pour ce tutoriel
1. Si vous n'avez pas de mvn installé, STS vous en a installé un

###Bonus:
Si vous avez déjà téléchargé Micro cloudFoundry, faites le setup dès à présent.


##Exercice 2 (20 mins)

###Une appli en local (10 mins)
1. Faites un clone de cette appli : https://github.com/ericbottard/spring-social-showcase
1. Testez-la en local (`mvn tomcat:run` ou bien "Import as Maven project" dans STS puis drag&drop sur un vFabric tcServer fraîchement configuré)

###Et dans les nuages (10 mins)
1. Créez votre compte sur http://cloudfoundry.com ("Sign up for cloud foundry")
    1. Votre adresse email sera votre login
    1. Vous recevez un email avec un password, que vous pourrez changer
    1. Utilisez le code promo "handsonjduchess"
1. Déployez l’application avec `vmc push` sur cloudfoundry en lui associant une db PostgreSQL
1. Admirez, vous êtes dans le Cloud!

Indices:

- Il faut d'abord construire l'appli! (`mvn package`)
- Le livrable construit de l'application se retrouve dans `target/`
- `vmc` travaille dans le répertoire courant. Vous pouvez sinon utiliser `--path xxxx`
- Il vous faut choisir une URL que personne n'a encore choisie...

###Bonus:
Supprimez l’application et le service puis redéployez-la *via* STS

##Exercice 3 (10 mins)

Faites

 * `vmc apps` (constatez)
 * `vmc instances` *le_nom_de_votre_appli* `+1`
 * `vmc services` (constatez)
 * `vmc runtimes`
 * `vmc frameworks`
 * `vmc stats` *le_nom_de_votre_appli*
 * `vmc logs` *le_nom_de_votre_appli*
 * `vmc help`

###Bonus:
 * Jouez un peu avec `vmc files`
 * Allez voir ce qui se trame dans le dossier WEB-INF...

##Exercice 4 (15 mins)

A partir de l'exercice 4, vous pouvez vous appuyer sur le squelette disponible ici : 
https://github.com/ericbottard/hands-on-cloudfoundry. Enlevez les commentaires autour du code au fur et à mesure. N'hésitez pas à forker le repo et à twitter vos solutions!
Encore une fois, dans STS, pensez à importer le projet en tant que projet Maven.

1. Ecrire une application web qui liste les variables d’environnement.
1. Déployez en local puis sur CloudFoundry.
1. Remarquez les variables nommées `VCAP_*`
1. Créez et bindez un service à votre application (même si elle ne l'exploite pas)
1. Remarquez la valeur de la variable `VCAP_SERVICES`

###Bonus:
Faites la même chose en Ruby on Rails, Sinatra, ou node.js.

Indices: Un exemple avec Sinatra:
```ruby
require 'rubygems'
require 'sinatra'
get '/' do
	s = ''
	  ENV.each{|k, v| s += "#{k} = #{v}<br>"}
	s
end
```

##Exercice 5 (15 mins)

1. Ajoutez une (première) datasource en utilisant une base H2 embarquée (ou autre si vous avez un serveur local).
2. Modifier le contrôleur `PersonController` afin qu'il écrive dans la base.
3. Déployez en local.
3. Déployez sur CloudFoundry en utilisant un service PostgreSQL, ça marche tout seul!

Indices:

- Spring permet de facilement créer une base embarquée grâce à `EmbeddedDatabaseFactory`.
- Pour récupérer des personnes, utilisez `jdbcTemplate.query(sql, parameters, BeanPropertyRowMapper)`
- Pour insérer des personnes, utilisez `jdbcTemplate.update(sql, new BeanPropertySqlParameterSource)`

###Bonus:
Loggez ou affichez la classe de la `DataSource` qui vous est injectée. Quelle est la valeur en local? Sur CloudFoundry?

##Exercice 6 (15 mins)

1. Ajoutez une deuxième datasource (toujours de type H2)
2. Modifiez `CopyController` pour qu'il utilise vos deux DataSources.
3. Déployez en local.
3. Déployez sur CloudFoundry. Regardez attentivement les logs. Qu'en pensez vous?

Indices:

- Exercez un peu l'application puis arrêtez/redémarrez-là...


##Exercice 7 (20 mins)

1. Supprimez les deux datasources ajoutées précédemment (si vous avez bien utilisé `@Configuration`)
2. Dans le fichier `context-ex7.xml`, déclarez deux profils: `default` et `cloud`
3. Re-déclarez vos deux DataSources locales au sein du profil `default`
4. Grâce au namespace `<cloud:xxx />`, déclarez vos deux DataSources du profil `cloud`

###Bonus:

Débarrassez-vous du XML et refaites l'équivalent de cet exercice avec des classes de `@Configuration`.

Indices: 

- `@Profile()` permet de limiter une configuration à un profil donné
- Vous pouvez injecter un `CloudEnvironment` dans votre `@Configuration`
- Pour obtenir par exemple les RDBMS, faites `cloudEnvironment.getServiceInfo(String name, Class<T> serviceInfoType)` avec `serviceInfoType` égal à `RdbmsServiceInfo.class`
