#Set the image file
FROM openjdk:8-jre-alpine

# Create new app directory (at the image side)
Run mkdir /app

CMD ["export JAVA_HOME=`which java`"]

# To select the port
EXPOSE 8080

#Copy from host machine to the image
COPY ["/target/FibonacciSequence-0.0.1-SNAPSHOT.jar","/app"] 

# The app directory
WORKDIR /app

# To add an entry point
ENTRYPOINT exec java -jar FibonacciSequence-0.0.1-SNAPSHOT.jar server