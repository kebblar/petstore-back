RUTA=/Users/garellano/Desktop/configurator

docker stop configurador
docker rm configurador

docker run -d \
--name=configurador \
--restart=unless-stopped \
-p 8888:8888 \
-v $RUTA:/ok \
openjdk:11 java -jar /ok/SpringCloudConfigurationServer-1.0-SNAPSHOT.jar