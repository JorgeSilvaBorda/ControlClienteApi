mvn io.quarkus:quarkus-maven-plugin:1.10.3.Final:create \
-DprojectGroupId=api.controlcliente \
-DprojectArtifactId=api-control-cliente \
-DclassName="api.controlcliente.InstalacionResource" \
-Dpath="/instalacion" \
-Dextensions="resteasy,resteasy-jsonb,agroal,jdbc-mysql,smallrye-openapi,hibernate-orm,hibernate-validator"