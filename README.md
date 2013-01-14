Note: Instructions in French are available [here](https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.fr.md)
Note: Instructions in Japanese are available [here](https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.jp.md)

#HANDS ON CLOUDFOUNDRY
##Exercise 1 (5 to 30 mins)
Before starting this Hands On, here are some mandatory prerequisites needed to convey the rest of the exercises.
###VMC
Run the `vmc` command in a terminal. If you get something like 
```bash   
vmc: command not found
```
please follow the next steps

1. run `ruby -v` in a terminal. Version 1.9.x is preferred. If you don't have ruby, 
    * On windows : http://www.rubyinstaller.org
    * On mac, you should have ruby. If that's not the case, https://rvm.io/ allows maintaining several ruby runtimes in parallel
    * On linux, use for example `apt` or https://rvm.io/
1. Run `sudo gem install vmc -V`

###SpringSource Tool Suite (STS)

1. Go to http://www.springsource.org/spring-tool-suite-download
1. Please download a >= 3.0.0 version
1. Run the installer / unzip, depending on the option you chose

####CloudFoundry Plugin
Go in `Help > About`: Is there a CloudFoundry icon? If not,

1. Go to `Help> Eclipse Marketplace` 
2. Search for "CloudFoundry"
3. Install, Restart

###Git

1. Go to http://git-scm.com/downloads
1. It's as easy as running the installer!

###Maven 
1. Run `mvn --version` in a terminal
1. A >= 3.0.3 version is recommended for this tutorial
1. If you don't have a Maven install yet, STS came with one

###Bonus:
If you already downloaded Micro CloudFoundry, now would be a good time to set it up

##Exercise 2 (20 mins)

###Where we run an app locally... (10 mins)
1. Clone this app : https://github.com/ericbottard/spring-social-showcase
1. Test it locally (`mvn tomcat:run` or "Import as Maven project" in STS and drag&drop it on a newly created vFabric tcServer)

###...and in the clouds (10 mins)
1. Create your http://cloudfoundry.com account ("Sign up for cloud foundry")
    1. Your email address will become your login
    1. You'll receive an email with a password. You can change it afterwards
    1. Use the promo code provided to you during the session 
1. Deploy the app on CloudFoundry using `vmc push`, binding it to a PostgreSQL service
1. Look Ma! I'm in the Cloud!

Hints:

- You need to build the app first! (`mvn package`)
- The build result lives in `target/`
- `vmc` works in the current directory. You can always use `--path xxxx` to tell it to look elsewhere
- You'll need to come up with an app name that hasn't been claimed by anyone yet...

###Bonus:
Delete the app and its service and deploy it again, using STS

##Exercise 3 (10 mins)

Run

 * `vmc apps` (what do you get?)
 * `vmc scale` *your_app_name*
 * `vmc services` (what do you get?)
 * `vmc stats` *your_app_name*
 * `vmc logs` *your_app_name*
 * `vmc help`

###Bonus:
 * Play with `vmc files`
 * Take a look inside the WEB-INF directory. Notice anything changed?

##Exercise 4 (15 mins)

Starting with exercise 4, you can use code from https://github.com/ericbottard/hands-on-cloudfoundry as a working skeleton. Remove comments around pieces of code as you go from one exercise to the next. Don't hesitate to fork the repo and tweet about your answers!
Once again, import the cloned project as a Maven project in STS.

1. Write a webapp that displays environment variables.
1. Deploy it locally and on CloudFoundry.
1. Have a look at variables named `VCAP_*`
1. Create and bind a service to your app (even if it does not use it)
1. See the contents of the `VCAP_SERVICES` variable?

###Bonus:
Try to do the same using Ruby on Rails, Sinatra, or node.js.

Hints: Here is a working sinatra example:
```ruby
require 'rubygems'
require 'sinatra'
get '/' do
	s = ''
	  ENV.each{|k, v| s += "#{k} = #{v}<br>"}
	s
end
```

##Exercise 5 (15 mins)

1. Add a (first) datasource using an embedded H2 db (or something else if you happen to have a database server locally).
2. Modify the `PersonController` class so that it writes in the database.
3. Deploy locally.
3. Deploy on CloudFoundry using a PostgreSQL service. The app works unchanged!

Hints:

- Spring allows you to easily create an embedded database thanks to `EmbeddedDatabaseFactory`
- To retrieve persisted Persons, check `jdbcTemplate.query(sql, parameters, BeanPropertyRowMapper)` out
- To store a new Person, check `jdbcTemplate.update(sql, new BeanPropertySqlParameterSource)` out

###Bonus:
Log or display the actual class of the `DataSource` that gets injected. What do you get locally? When running on CloudFoundry?

##Exercise 6 (15 mins)

1. Add another datasource (embedded H2 as well)
2. Modify `CopyController` so that it uses the two datasources.
3. Deploy locally.
3. Deploy on CloudFoundry. Look carefully at the logs. What do you think?

Hint:

- Play with the app a bit and then stop/restart it...


##Exercise 7 (20 mins)

1. Assuming you used `@Configuration` classes, get rid of the two datasources
2. In the `context-ex7.xml` file, make room for 2 profiles: `default` and `cloud`
3. Declare 2 local DataSources inside the `default` profile. You can use the `<jdbc: />` namesplace
4. Thanks to the `<cloud:xxx />` namespace, Insert your 2 DataSources in the `cloud` profile

###Bonus:

Get rid of all the XML stuff and do it again, this time using `@Configuration` classes.

Hint: 

- You can use `@Profile()` to narrow a configuration class to a given profile
- You can inject a `CloudEnvironment` in your `@Configuration`
- To get info about relational services, you can use `cloudEnvironment.getServiceInfo(String name, Class<T> serviceInfoType)` where `serviceInfoType` equals `RdbmsServiceInfo.class`
