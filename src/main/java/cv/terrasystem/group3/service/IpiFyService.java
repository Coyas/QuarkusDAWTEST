package cv.terrasystem.group3.service;

import cv.terrasystem.group3.model.WanIp;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/")
@RegisterRestClient(configKey = "wan-ipify-api")
public interface IpiFyService {
    @GET
    String getWanIp();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    WanIp getWanIp(@QueryParam("format") String format);

}
