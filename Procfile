release: ./gradlew flywayMigrate -i
release: export GOOGLE_APPLICATION_CREDENTIALS="./my-kitchen-manager-74c393348158.json"
web: java -Dserver.port=$PORT $JAVA_OPTS -jar ./build/libs/my-kitchen-manager-0.0.1-SNAPSHOT.jar
