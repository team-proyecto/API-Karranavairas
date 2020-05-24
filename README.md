# API-Karranavairas
herramientas usadas (java, spring, jwt)

-java version "1.8.0_241"
-javac 1.8.0_241
-IDE Eclipse Spring Tool Suite 4
-Maven
-Mysql Ver 14.14 Distrib 5.7.29
-Postman


//para crear jar en linux:

 mvn clean package -Pjar

//para crear jar en Windows

 .\mvnw.cmd clean package

//deploy en heroku:
heroku login
heroku git:remote -a api-corona-spring
heroku plugins:install java
heroku addons:create jawsdb
heroku config:get JAWSDB_URL
mysql://k4kgo5711asus25p:n0co3oy96id6z7fl@pqxt96p7ysz6rn1f.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/uim9e0kix598bv7f


//URL en nube:
https://api-corona-spring.herokuapp.com/


//ver logs de deploy
heroku logs --tail

