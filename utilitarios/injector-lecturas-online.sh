

(
    IFS=$'\n'
    for linea in $(mysql -BN -u root -pBodenor848 -h 192.168.100.228 bodenor <<<"CALL SP_GET_CONVERSORES_COMANDO_API()"); do
        #echo $linea | sed 's/\t/;/g' | cut -d ";" -f7
        ./$linea
    done;
)
