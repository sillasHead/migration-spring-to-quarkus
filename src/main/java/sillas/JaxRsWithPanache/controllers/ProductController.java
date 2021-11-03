package sillas.JaxRsWithPanache.controllers;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import sillas.JaxRsWithPanache.entities.Product;
import sillas.JaxRsWithPanache.services.ProductService;

@Path("product")
public class ProductController {

    @Inject 
    ProductService service;

    @GET
    public Response findAll() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    public Response findByName(@QueryParam(value = "name") String name) {
        return Response.ok(service.findByName(name)).build();
    }

    @GET
    public Response findByNameOrderByPrice(@QueryParam(value = "name") String name) {
        return Response.ok(service.findByNameOrderByPrice(name)).build();
    }

    @GET
    @Path("/{id}")
    public Response findByIdentifier(@PathParam(value = "id") Long id) {
        return Response.ok(service.findByIdentifier(id)).build();
    }

    @GET
    public Response findOfPriceHigherThan(@QueryParam(value = "price") Double price) {
        return Response.ok(service.findOfPriceHigherThan(price)).build();
    }

    @POST
    @Transactional
    public Response save(Product product) {
        return Response.ok(service.save(product)).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam(value = "id") Long id, Product product) {
        return Response.ok(service.update(id, product)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam(value = "id") Long id) {
        service.deleteById(id);
    }
}
