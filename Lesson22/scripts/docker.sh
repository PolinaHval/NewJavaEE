docker run --rm \
    --name tomcat \
    -p 8080:8080 \
    --network my-bridge-network \
    -v "/Users/admin/IdeaProjects/NewJavaEE/Lesson22/target/Lesson22-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" \
    tomcat:9.0.53-jdk11-openjdk

docker build -t "servlet:latest" .

docker run --rm \
    --name custom-tomcat \
    -p 8080:8080 \
    --network my-bridge-network \
    servlet:latest


docker run --network my-bridge-network --rm curlimages/curl:7.85.0 http://custom-tomcat:8080/servlet/user
