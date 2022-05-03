#echo "Listo"
#docker stop petstore
#docker rm petstore
#docker run -d -p 9092:80 --name=petstore nginx


# Pay attention : This is the ONLY one line to change !!!!
BASE=/home/ubuntu/work/petstore
AWS_PARENT=/home/ubuntu/work/connect-aws

#/entrada-ultrasist
# ******************************************

RUTA=$BASE
#mvn -U -f $BASE/pom.xml -Dmaven.test.skip clean package
#cp $BASE/target/*.jar $RUTA/deploy

docker stop petstore
docker rm petstore


#docker run -it --privileged --device /dev/fuse --cap-add SYS_ADMIN 
#-v /home/ubuntu/work/experiment:/data petstore bash


echo "Ejecutando imagen"
docker run -d \
-p 56060:7777 \
--restart unless-stopped \
--name petstore \
--privileged --device /dev/fuse --cap-add SYS_ADMIN \
-e JASYPT_KEY_PHRASE=password \
-e JWT_KEY_PHRASE=password \
-v $RUTA/keys:/keys \
-v $RUTA/deploy:/deploy \
-v $RUTA/uploads:/uploads \
-v $RUTA/video:/video \
-v $RUTA/configuration:/configuration \
-v $RUTA/private-repo:/private-repo \
-v $RUTA/log:/log \
-v $RUTA/executor:/executor \
-w /deploy \
openjdk:11 \
java \
-Dmaven.test.skip=true \
-Duser.timezone="America/Mexico_City" \
-Dspring.config.location="file:/configuration/" \
-Dspring.profiles.active=dev \
-jar petstore-back-1.0-SNAPSHOT.jar

#docker exec -it -w /executor petstore bash /executor/aws.sh
#docker exec -it -w /executor petstore bash nohup /executor/observer.sh &

echo "Iniciando servidor de Imagenes..."
docker stop photos
docker rm photos

docker run \
-d -p 46060:80 \
--restart unless-stopped \
--name=photos \
-v $RUTA/uploads:/usr/share/nginx/html \
nginx

echo "Proceso concluido"
