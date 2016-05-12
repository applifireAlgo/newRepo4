




echo $PATH
DB_PATH=/tmp/applifire/db/NIKO9B9S38HWASN7SYLG/74155743-19A0-469B-9B26-4C33083DA3B1
MYSQL=/usr/bin
USER=pro2
PASSWORD=pro2
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'