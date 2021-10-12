## compila y genera imagen docker
./mvnw clean package -Dquarkus.container-image.build=true

## Darle TAG para poder pushearla
## Ejemplo docker tag f86f2cb5a2a2 jsilvab/bodenor-api
docker tag [ID DE LA IMAGEN COMPILADA ARRIBA] jsilvab/bodenor-api

## subir la imagen
docker push

## Desplegarla en kubernetes
./mvnw package

####./mvnw package -Pnative -Dquarkus.native.container-build=true -Dquarkus.container-image.push=true -Dquarkus.quarkus.container-image.group=jsilvab -Dquarkus.quarkus.container-image.username=jsilvab