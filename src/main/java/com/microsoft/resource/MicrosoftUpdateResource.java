package com.microsoft.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.microsoft.dao.MicrosoftUpdateDaoImpl;
import com.microsoft.dto.MicrosoftUpdateDto;
import com.microsoft.dto.converter.MicrosoftUpdateDtoConverter;
import com.microsoft.entity.MicrosoftUpdate;

@Path("/update")
public class MicrosoftUpdateResource {

    private MicrosoftUpdateDtoConverter microsoftUpdateDtoConverter = new MicrosoftUpdateDtoConverter();
    private MicrosoftUpdateDaoImpl microsoftUpdateDaoImpl = MicrosoftUpdateDaoImpl.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MicrosoftUpdateDto> list() throws Exception {
	return microsoftUpdateDtoConverter.entityListToDto(microsoftUpdateDaoImpl.list());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MicrosoftUpdateDto getById(@PathParam("id") Long id) throws Exception {
	return microsoftUpdateDtoConverter.toDto(microsoftUpdateDaoImpl.getById(id));
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
	try {
	    MicrosoftUpdate microsoftUpdate = microsoftUpdateDaoImpl.getById(id);
	    if (microsoftUpdate == null)
		return Response.status(Response.Status.NOT_FOUND).build();

	    microsoftUpdateDaoImpl.delete(microsoftUpdate);
	    return Response.status(Response.Status.OK).build();
	} catch (Exception e) {
	    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
	}
    }
}