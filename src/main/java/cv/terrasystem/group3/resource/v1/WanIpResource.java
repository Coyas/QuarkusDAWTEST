package cv.terrasystem.group3.resource.v1;

import cv.terrasystem.group3.constant.Constants;
import cv.terrasystem.group3.model.WanIp;
import cv.terrasystem.group3.service.IpiFyService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("/v1/wan")
public class WanIpResource {

    @Inject
    @RestClient
    IpiFyService ipiFyService;

    @GET
    @Tag(name = Constants.ENDPOINT_TAG_WAN_IP)
    @Operation(summary = Constants.RETORNA_IP_ADDRESS_SUMMARY, description = Constants.RETORNA_IP_ADDRESS)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/get-ip-text/{aluno}/")
    public String getIpByText(@NotNull @HeaderParam("X-Type-Format") String typeFormat, @QueryParam("id") int id,
                              @PathParam("aluno") int aluno){
        return "Resources get IP using Text: " + typeFormat;
    }

    @GET
    @Tag(name = Constants.ENDPOINT_TAG_WAN_IP)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get-ip-json")
    public WanIp getIpByJson(){
        String ip = ipiFyService.getWanIp();
        //WanIp ip = ipiFyService.getWanIp("json");

    /*        WanIp wanip = WanIp.builder()
                .ip(String.valueOf(ip))
                .location("london")
                .build();
        */

        return WanIp.builder()
                .ip(String.valueOf(ip))
                .location("london")
                .build();
    }

    @GET
    @Tag(name = Constants.ENDPOINT_TAG_WAN_LOCATION)
    @Path("/get-ip-location")
    public WanIp getIpLocation() {

        return WanIp.builder()
                .build();
    }
}
