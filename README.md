# my-kitchen-manager

## Database Initialization and Migration
```aidl
$ cd my-kitchen-manager
$ docker-compose up -d mysql
$ ./gradlew flywayMigration -i
```
