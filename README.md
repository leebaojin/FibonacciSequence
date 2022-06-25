# FibonacciSequence

## Starting application on local machine
---
1. Run `mvn clean install` to build your application
2. Start application with `java -jar target/FibonacciSequence-0.0.1-SNAPSHOT.jar server config.yml`
3. To check that your application is running enter url `http://localhost:8080`


## Building Docker Image
---
1. DockerFile located at the root folder (FibonacciSequence)
2. Navigate console to the folder
3. Create the docker image
    > docker build -t <reponame>:<tagname> .
    > docker build -t leebaojin/fibonacci:v1.0 .
4. Push to docker hub
    > docker push <reponame>:<tagname>
    > docker push leebaojin/fibonacci:v1.0
5. Test run the docker image
    > docker run -d -p=<container_port>:<tcp_port> --name <name> <docker_image_name>
    > docker run -d -p=8080:8080 --name fiboapp leebaojin/fibonacci:v1.0
6. Stop docker
    > docker stop <container_id>


## React UI
---
1. React UI is in the folder /client/fibo-app
2. Navigate to folder location
3. Start the React server
    > npm install    //for first time 
    > npm start
4. The react component is linked to the Oracle Cloud application. http://152.67.99.60:8080


## Fibonacci Application
---
1. Implemented with Java using dropwizard.io
2. Create a project using dropwizard-archetype :
    > mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=2.0.0
    > project was set up by following instructions


## Other information
---
1. BigInteger was used as the implementation due to the huge number involved when elements == 100
2. React UI, however, receive String as an input since it is unable to handle the huge number, resulting in loss of accuracy
3. 3 implementations are available:
    > If using a post request with a json file
        e.g. {“elements”:10}
        Use : http://localhost:8080/fibonacci (will return in BigInteger)
        Use : http://localhost:8080/fibonacci/string (will return in String)
    > If calling from the url (get request)
        Use : http://localhost:8080/fibonacci/{elements} (will return BigInteger)


