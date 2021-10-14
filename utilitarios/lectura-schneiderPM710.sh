## $1="192.168.94.2"
## $2="2"
## $3="10"



TIMESTAMP="TIMESTAMP["$(date +"%Y-%m-%d %H:%M:%S")"]"
IP="IP[$1]"
EQUIPO="EQUIPO[$2]"
IDREM="IDREM[$3]"

HOST=$4

CONTENIDO=$(./modpoll -m enc -t4 -a $3 -r 4000 -c 109 -1 -o 1 $1 -p 1024)
echo $TIMESTAMP$IP$EQUIPO$IDREM$CONTENIDO

SALIDA_API=$(curl -X POST -H "Content-Type: text/plain" -d "$TIMESTAMP$IP$EQUIPO$IDREM$CONTENIDO" $HOST)

mongo --eval "db.LogCargaOnline.insertOne({timestamp: '"$TIMESTAMP"', ipConversor: '"$1"', numPuerto: "$3", numConversor: "$2", url: '"$HOST"', respuestaModpoll: '"$CONTENIDO"', salidaApi: '"$SALIDA_API"'});" bodenor
