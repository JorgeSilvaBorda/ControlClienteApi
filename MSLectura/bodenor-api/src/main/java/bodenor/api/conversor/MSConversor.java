package bodenor.api.conversor;

import bodenor.api.conversor.model.Conversor;
import bodenor.api.conversor.model.Remarcador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.bson.Document;
import org.bson.types.ObjectId;

@Path("/api/bodenor/conversor")
public class MSConversor {

    @Inject
    MongoClient mongoClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Conversor> getConversores() {
        MongoCollection<Document> collectionConversor = getCollection();
        FindIterable<Document> documents = collectionConversor.find();

        Iterator i = documents.iterator();
        List<Conversor> conversores = new ArrayList();
        while (i.hasNext()) {
            Conversor conversor = new Conversor();
            Document doc = (Document) i.next();
            conversor.setId(doc.getObjectId("_id"));
            conversor.setIp(doc.getString("ipConversor"));
            conversor.setNumConversor(doc.getInteger("numConversor"));
            List<Document> rems = doc.getList("remarcadores", Document.class);
            List<Remarcador> remarcadores = new ArrayList();
            if (!rems.isEmpty()) {
                for (Document rem : rems) {
                    Remarcador remarcador = new Remarcador();
                    remarcador.setNumPuerto(rem.getInteger("numPuerto"));
                    remarcador.setTipoRemarcador(rem.getString("tipoRemarcador"));
                    remarcadores.add(remarcador);
                }
            }
            conversor.setRemarcadores(remarcadores);
            conversores.add(conversor);
        }
        return conversores;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/numconversor/{numConversor}")
    public Conversor getConversorNum(@PathParam("numConversor") Integer numConversor) {
        MongoCollection<Document> collectionConversor = getCollection();
        Document docConversor = collectionConversor.find(Filters.eq("numConversor", numConversor)).first();
        if (docConversor == null) {
            return new Conversor();
        }
        List<Document> docRemarcadores = docConversor.getList("remarcadores", Document.class);
        Conversor conversor = new Conversor();
        conversor.setId(docConversor.getObjectId("_id"));
        conversor.setIp(docConversor.getString("ip"));
        conversor.setNumConversor(docConversor.getInteger("numConversor"));
        if (docRemarcadores.size() > 0) {
            List<Remarcador> remarcadores = new ArrayList();
            for (Document docRem : docRemarcadores) {
                remarcadores.add(new Remarcador(docRem.getInteger("numPuerto"), docRem.getString("tipoRemarcador")));
            }
            conversor.setRemarcadores(remarcadores);
        }
        return conversor;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{objectId}")
    public Conversor getConversorId(@PathParam("objectId") ObjectId id) {
        MongoCollection<Document> collectionConversor = getCollection();
        Document docConversor = collectionConversor.find(Filters.eq("_id", id)).first();
        if (docConversor == null) {
            return new Conversor();
        }
        List<Document> docRemarcadores = docConversor.getList("remarcadores", Document.class);
        Conversor conversor = new Conversor();
        conversor.setId(docConversor.getObjectId("_id"));
        conversor.setIp(docConversor.getString("ip"));
        conversor.setNumConversor(docConversor.getInteger("numConversor"));
        if (docRemarcadores.size() > 0) {
            List<Remarcador> remarcadores = new ArrayList();
            for (Document docRem : docRemarcadores) {
                remarcadores.add(new Remarcador(docRem.getInteger("numPuerto"), docRem.getString("tipoRemarcador")));
            }
            conversor.setRemarcadores(remarcadores);
        }
        return conversor;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Conversor postConversor(Conversor conversor) {
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        Gson gson = builder.create();
        String json = gson.toJson(conversor);
        Document doc = Document.parse(json);
        ObjectId id = getCollection().insertOne(doc).getInsertedId().asObjectId().getValue();
        return this.getConversorId(id);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/addremarcador")
    public Conversor addRemarcadorConversor(Conversor conversor, Remarcador remarcador) {
        List<Remarcador> remarcadores = conversor.getRemarcadores();
        
        GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
        Gson gson = builder.create();
        String json = gson.toJson(conversor);
        Document doc = Document.parse(json);
        
        if(remarcadores == null){
            remarcadores = new ArrayList();
        }
        remarcadores.add(remarcador);
        conversor.setRemarcadores(remarcadores);
        conversor.setId(null);
        getCollection().findOneAndReplace(Filters.eq("_id", doc.getObjectId("_id")), conversor);
        return this.getConversorId(doc.getObjectId("_id"));
    }

    private MongoCollection getCollection() {
        return mongoClient.getDatabase("bodenor").getCollection("Conversor");
    }
}
