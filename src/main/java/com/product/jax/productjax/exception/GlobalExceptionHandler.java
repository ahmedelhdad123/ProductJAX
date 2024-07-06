package com.product.jax.productjax.exception;


import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {


    @Override
    public Response toResponse(Throwable e) {

        ApiException apiException=new ApiException(e.getMessage(),Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        if (e instanceof WebApplicationException) {
            Response.StatusType statusInfo = ((WebApplicationException) e).getResponse().getStatusInfo();
            apiException.setStatus(statusInfo.getStatusCode());
        }

        return Response.status(apiException.getStatus())
                .entity(apiException)
                .build();
    }
}
