




echo $PATH
OSNAME=`uname -s`
FILE_PATH=/tmp/applifire/db/DP0WEVRCBLYMABIMILSABW





sh $FILE_PATH/create.sh  
sh $FILE_PATH/alter.sh  
sh $FILE_PATH/loaddata.sh   
