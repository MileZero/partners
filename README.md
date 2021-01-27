# partners
This package was created by the rest-service-template archetype version 1.0.28




```
To run jetty:run you need to initialize git. So first run
1. run `git init`
2. run `git add .`
3. run `git commit -m "first commit"`
```

```
To run the webserver do the following
mvn clean
mvn install
cd  partners-war
mvn jetty:run

```

Customize as needed.
Remove: Candy.java in resources, CandyPojo.java in model.

```
src
   |-> main
           |-> java
                   |-> config - "Configuration beans, the 2 in there are metrics and properties loading."
                   |-> model - "Business object model, these are by default jackson (de)serialized pojos"
                   |-> resources - "API resources, these are the logical entry point to apis."
           |-> resources - "config files loaded as part of application.  currently has server config and logback config."
           |-> webapp - "web application files, includes swagger static resources, and web.xml descriptor."
   |-> test
           |-> java - unit tests
```

After server is running, go to:
```
http://localhost:4874/partners-war to see swagger documentation and testing dashboard.
http://localhost:4874/partners-war/api/swagger.json  to see swagger json data.
http://localhost:4874/partners-war/api/candy/marsbar to directly see GET api.
```


1. run `git init`
2. run `git add .`
3. run `git commit -m "first commit"`

1. go to github.com/Milezero and create a new private repo named `partners`. Make sure the MZ engineering team (https://github.com/orgs/MileZero/teams/engineers)
are collaborators on this repo.
2. run `git remote add origin git@github.com:MileZero/partners.git`
3. run `git push origin master`

1. Go to build.dev.milezero.com
2. Click on "New Item"
3.  Enter a "Item name" in the top form field
4.  Select "Copy existing item" radio button and type in a previously existent jenkins item to clone this from for example "earp"
5.  On the next page replace the values for "Github project" and "Repository URL" with respective values for your service or package
6.  Hit save
7. (If you're savy) Add a pipeline version by following the format used by other projects
8.  on the left menu hit "Build now" to have the project start building
9.  Once built , hit "Perform Maven Release" and then hit "Schedule Maven Release Build"
