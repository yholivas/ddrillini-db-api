# DDRIllini Online DB
## REST API
### setup
1. install mariadb, set up a database and user for that database
2. edit `src/main/resources/application.properties` with the URL and username+password
for that database
3. either edit `src/main/java/club/ddrillini/api/controller/FileUploadController.java`
with the url for image storage, or `mkdir ~/projects/data-store/`
4. run `./mvnw spring-boot:run`

### troubleshooting
the database might complain about time zones, either edit the database to work
(search "mysql time zone error" or something) or just append
`?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC`
to the end of the database url
