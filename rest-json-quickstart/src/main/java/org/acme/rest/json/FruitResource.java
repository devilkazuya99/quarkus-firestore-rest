package org.acme.rest.json;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/fruits")
@ApplicationScoped
public class FruitResource {

    @Inject
    @RestClient
    FirestoreService fs;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Store hello() {
        System.out.println("FirestoreService == " + fs);
        return fs.getStores(getBearerToken(), "ALIBABA");
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String addStore(@FormParam("name") String name) {
        System.out.println("name = " + name);
        Store store = new Store(1980, "Lily", "Makota");
        return  fs.addStore(getBearerToken(), name, store);
    }
    
    String getBearerToken() {
        return "Bearer " + TokenUtils.generate30minTokenString();
    }
}