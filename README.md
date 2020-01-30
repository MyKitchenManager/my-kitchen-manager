# my-kitchen-manager

## Database Initialization and Migration
```aidl
$ cd my-kitchen-manager
$ docker-compose up -d mysql
$ ./gradlew flywayMigration -i
```

local mysql
host: 127.0.0.1
port: 3306
username: root
password: loh1Uego
