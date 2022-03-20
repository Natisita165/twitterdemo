#FROM azul/zulu-openjdk:11.0.10
FROM mysql:5.7
#ENV BD_URL "jdbc:mysql://127.0.0.1:23306/twitter"
#COPY "./target/demotwitter-0.0.1-SNAPSHOT.jar" "app.jar"
#EXPOSE 8181
#ENTRYPOINT ["java", \
#                       "-jar", \
#                       "app.jar"]