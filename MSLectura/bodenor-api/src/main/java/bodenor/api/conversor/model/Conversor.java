package bodenor.api.conversor.model;

import java.util.List;
import org.bson.types.ObjectId;

public class Conversor {
    private ObjectId id;
    private String ip;
    private Integer numConversor;
    private List<Remarcador> remarcadores;

    public Conversor() {
    }

    public Conversor(ObjectId id, String ip, Integer numConversor, List<Remarcador> remarcadores) {
        this.id = id;
        this.ip = ip;
        this.numConversor = numConversor;
        this.remarcadores = remarcadores;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getNumConversor() {
        return numConversor;
    }

    public void setNumConversor(Integer numConversor) {
        this.numConversor = numConversor;
    }
    
    public List getRemarcadores(){
        return remarcadores;
    }
    
    public void setRemarcadores(List<Remarcador> remarcadores){
        this.remarcadores = remarcadores;
    }
    
}
