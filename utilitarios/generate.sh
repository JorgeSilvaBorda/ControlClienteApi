mvn io.quarkus:quarkus-maven-plugin:1.10.3.Final:create \
-DprojectGroupId=bodenor.api.lectura \
-DprojectArtifactId=bodenor-api \
-DclassName="bodenor.api.lectura.MSLectura" \
-Dpath="/lectura" \
-Dextensions="resteasy,resteasy-mutiny,context-propagation,resteasy-jsonb,rest-client,jdbc-mysql,mongodb-client,smallrye-openapi,hibernate-orm,hibernate-validator"
