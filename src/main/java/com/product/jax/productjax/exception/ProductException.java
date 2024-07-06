package com.product.jax.productjax.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ProductException extends WebApplicationException {

    public ProductException(String message) {
        super(Response.status(Response.Status.BAD_REQUEST)
                .entity(new ApiException(message, Response.Status.BAD_REQUEST.getStatusCode()))
                .build());
    }

}
