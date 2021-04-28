echo "Usung dump.sh with following content:"
echo "mysqldump -u garellano -pgarellano ejemplo4 > /scripts/db.sql"
docker exec -it container-proyecto-backend-db bash ./dump.sh
cp /Users/garellano/development/code/curso-is/proyecto-backend/src/main/resources/db/db.sql .

