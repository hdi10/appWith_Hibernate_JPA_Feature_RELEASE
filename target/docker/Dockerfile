
VOLUME /tmp
ADD appWith_Hibernate_JPA.jar /opt/appWith_Hibernate_JPA/
EXPOSE 8081
WORKDIR /opt/appWith_Hibernate_JPA/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "appWith_Hibernate_JPA.jar"]
