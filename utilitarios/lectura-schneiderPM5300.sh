## $1="192.168.102.190"
## $2="2"
## $3="1"



TIMESTAMP="TIMESTAMP["$(date +"%Y-%m-%d %H:%M:%S")"]"
IP="IP[$1]"
EQUIPO="EQUIPO[$2]"
IDREM="IDREM[$3]"

HOST=$4

CONTENIDO1=$(./modpoll -m enc -t4:hex -a $3 -r 2700 -c 2 -1 -o 1 $1 -p 1024);
sleep 1;
CONTENIDO2=$(./modpoll -m enc -t4:hex -a $3 -r 3060 -c 2 -1 -o 1 $1 -p 1024);


echo "$TIMESTAMP$IP$EQUIPO$IDREM$CONTENIDO1 $CONTENIDO2";

SALIDA_API=$(curl -X POST -H "Content-Type: text/plain" -d "$TIMESTAMP$IP$EQUIPO$IDREM$CONTENIDO1$CONTENIDO2" $HOST)

mongo --eval "db.LogCargaOnline.insertOne({timestamp: '"$TIMESTAMP"', url: '"$HOST"', respuestaModpoll: '"$CONTENIDO1$CONTENIDO2"', salidaApi: '"$SALIDA_API"'});" bodenor
