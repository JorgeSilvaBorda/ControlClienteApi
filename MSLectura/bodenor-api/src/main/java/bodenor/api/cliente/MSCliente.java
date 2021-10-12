/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodenor.api.cliente;

import bodenor.api.cliente.model.Cliente;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/bodenor/cliente")
public class MSCliente {
    @Inject
    private EntityManager manager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getCliente() {
        String query = "SELECT C FROM CLIENTE C";
        return manager.createQuery(query, Cliente.class).getResultList();
    }

    @Path("/{idcliente}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getClienteIdCliente(@PathParam("idcliente") Integer idcliente) {
        String query = "SELECT C FROM CLIENTE C WHERE C.idcliente = " + idcliente;
        List<Cliente> clientes = manager.createQuery(query, Cliente.class).getResultList();
        if (clientes.size() < 1) {
            return new Cliente();
        } else {
            return clientes.get(0);
        }
    }
}
