(
    STRING="["
    export APIHOST=http://localhost:7070/api/bodenor/lectura
    ## for fila in $(mysql -u root -pBodenor848 -h 192.168.100.228 bodenor -e "SELECT * FROM CONVERSOR" | sed 's/\t/;/g' | grep -v IDCONVERSOR); do
    for fila in $(mysql -u root -pBodenor848 -h 192.168.100.228 bodenor <CONVERSORES.sql | sed 's/\t/;/g' | grep -v IDCONVERSOR); do
        ##echo $fila;
        IDCONVERSOR=$(echo $fila";" | cut -d ";" -f 1)
        IPCONVERSOR=$(echo $fila";" | cut -d ";" -f 2)
        NUMCONVERSOR=$(echo $fila";" | cut -d ";" -f 3)
        NUMREMARCADOR=$(echo $fila";" | cut -d ";" -f 4)
        NUMPUERTO=$(echo $fila";" | cut -d ";" -f 5)
        TIPOREMARCADOR=$(echo $fila";" | cut -d ";" -f 6 | tr [:upper:] [:lower:])

        STRING=$STRING"{
            \"idconversor\": "$IDCONVERSOR",
            \"ipconversor\": \""$IPCONVERSOR"\",
            \"numconversor\": "$NUMCONVERSOR",
            \"numremarcador\": "$NUMREMARCADOR",
            \"numpuerto\": "$NUMPUERTO",
            \"tiporemarcador\": \""$TIPOREMARCADOR"\","
            
        ## echo "Procesando :"
        ## echo $STRING | jq
        ##./lectura-circutor.sh $IPCONVERSOR $IDCONVERSOR $NUMPUERTO $APIHOST"/"$TIPOREMARCADOR
        ### Mandar a la lectura que corresponde
        if [ "$TIPOREMARCADOR" = "circutorcvmc10" ]; then
            echo "Se manda al sh de circutor."
            ####### logging ########
            STRING=$STRING"\"comando\":"
            STRING=$STRING"\"./lectura-circutor.sh "$IPCONVERSOR" "$IDCONVERSOR" "$NUMPUERTO" "$APIHOST"/"$TIPOREMARCADOR"\""
            ########################

            #ejecución de lectura-circutor.sh ## consume api de remarcadores circutor para almacenar continuidad.
            #./lectura-circutor.sh $IPCONVERSOR $IDCONVERSOR $NUMPUERTO $APIHOST"/"$TIPOREMARCADOR
            ./lectura-circutor.sh $IPCONVERSOR $IDCONVERSOR $NUMPUERTO $APIHOST"/"$TIPOREMARCADOR
        fi
        if [ "$TIPOREMARCADOR" = "schneiderpm710" ]; then
            echo "Se manda al sh de 710."
            #./lectura-schneiderPM710.sh $IPCONVERSOR $IDCONVERSOR $NUMPUERTO $APIHOST"/"$TIPOREMARCADOR
            STRING=$STRING"\"comando\":"
            STRING=$STRING"\"./lectura-schneiderPM710.sh "$IPCONVERSOR" "$IDCONVERSOR" "$NUMPUERTO" "$APIHOST"/"$TIPOREMARCADOR"\""

            #./lectura-schneiderPM710.sh $IPCONVERSOR $IDCONVERSOR $NUMPUERTO $APIHOST"/"$TIPOREMARCADOR
            ./lectura-schneiderPM710.sh $IPCONVERSOR $IDCONVERSOR $NUMPUERTO $APIHOST"/"$TIPOREMARCADOR
        fi
        if [ "$TIPOREMARCADOR" = "schneiderpm5300" ]; then
            echo "Se manda al sh de 5300."
            #./lectura-schneiderPM5300.sh $IPCONVERSOR $IDCONVERSOR $NUMPUERTO $APIHOST"/"$TIPOREMARCADOR
            STRING=$STRING"\"comando\":"
            STRING=$STRING"\"./lectura-schneiderPM5300.sh "$IPCONVERSOR" "$IDCONVERSOR" "$NUMPUERTO" "$APIHOST"/"$TIPOREMARCADOR"\""

            #./lectura-schneiderPM5300.sh $IPCONVERSOR $IDCONVERSOR $NUMPUERTO $APIHOST"/"$TIPOREMARCADOR
            ./lectura-schneiderPM5300.sh $IPCONVERSOR $IDCONVERSOR $NUMPUERTO $APIHOST"/"$TIPOREMARCADOR
        fi

        STRING=$STRING"}," ## El último objeto json siempre arrastra una ",". Se debe remover más abajo.
    done;
    echo "Ejecuciones:"
    ######

    ## Remover la coma que arrastra el último objeto json antes de cerrar el Arreglo.
    STRING=${STRING::-1}

    #echo $STRING2"]"
    #######

    ## Cerrar arreglo de salida
    echo $STRING"]" | jq
)
