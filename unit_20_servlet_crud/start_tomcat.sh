cd ./apache-tomcat-10.1.25/bin
sh ./shutdown.sh

cd ../../

mvn clean install

cp target/unit_20_servlet_crud.war ./apache-tomcat-10.1.25/webapps

cd ./apache-tomcat-10.1.25/bin

sh ./startup.sh

cd ../../