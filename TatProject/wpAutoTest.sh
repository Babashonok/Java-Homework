cd vagrant-lamp-wordpress
vagrant up
cd AutoTests
mvn compile
mvn clean install
cd target/surefire-reports/html
firefox index.html
