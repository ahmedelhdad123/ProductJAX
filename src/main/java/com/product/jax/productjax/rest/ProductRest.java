package com.product.jax.productjax.rest;

import com.product.jax.productjax.entity.Product;
import com.product.jax.productjax.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductRest {

    @Inject
    private ProductService productService;

    @GET
    @Path("all")
    public Response getProducts() {
        List<Product> products = productService.findAll();
        return Response.ok(products).build();
    }

    @GET
    @Path("findById/{id}")
    public Response getProductById(@PathParam("id") Integer id) {
        Product product = productService.findById(id);
        return Response.ok(product).build();
    }

    @POST
    @Path("add")
    public Response addProduct(Product product) {
        productService.add(product);
        return Response.status(Response.Status.CREATED).entity(product).build();
    }

    @PUT
    @Path("update/{id}")
    public Response updateProduct(@PathParam("id") int id, Product product) {
        productService.update(id, product);
        return Response.ok(product).build();
    }

    @DELETE
    @Path("delete/{id}")
    public Response deleteProduct(@PathParam("id") int id) {
        productService.delete(id);
        return Response.ok().build();
    }

    @GET
    @Path("findByName/{name}")
    public Response getProductByName(@PathParam("name") String name) {
        Product product = productService.findByName(name);
        return Response.ok(product).build();
    }
}