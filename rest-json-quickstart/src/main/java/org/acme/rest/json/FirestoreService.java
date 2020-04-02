package org.acme.rest.json;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.HeaderParam;
import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

@Path("/v1/projects/<PROJECT_ID>/databases/(default)/documents")
@RegisterRestClient(configKey = "firestore-api")
public interface FirestoreService {

    @GET
    @Path("/stores/{name}")
    @Produces("application/json")
    @Consumes("text/plain")
    Store getStores(@HeaderParam(HttpHeaders.AUTHORIZATION) String authToken, 
            @PathParam String name);

    @POST
    @Path("/stores")
    @Produces("application/json")
    @Consumes("application/json")
    String addStore(@HeaderParam(HttpHeaders.AUTHORIZATION) String authToken, 
            @QueryParam("documentId") String name,
            Store store);

}


