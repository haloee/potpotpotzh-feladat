package hu.pte.mik.prog4.api.controller;
import hu.pte.mik.prog4.entity.TravelEntity;
import hu.pte.mik.prog4.service.TravelService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/travel")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TravelController {
    private final TravelService travelService;

    public TravelController() {
        this.travelService = new TravelService();
    }

    @GET
    public Response findAll() {
        var travels = travelService.listAll();
        return Response
                .status(Response.Status.OK)
                .entity(travels).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        var travel = travelService.findById(id);
        if (travel != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(travel)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @PUT
    public Response save(TravelEntity travelEntity) {
        var cmp = this.travelService.save( new TravelEntity(
                travelEntity.getUticelid(),
                travelEntity.getNev(),
                travelEntity.getTipus(),
                travelEntity.getLeiras(),
                travelEntity.getOrszag()
        ));
        if (cmp != null) {
            return Response
                    .status(Response.Status.ACCEPTED)
                    .entity(cmp)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

    @POST
    @Path("/{id}/travelling")
    public Response getRating(@PathParam("id") Long id) {
        var rating = this.travelService.getTravelling(String.valueOf(id));

        if (rating != 0) {
            return Response
                    .status(Response.Status.OK)
                    .entity(rating)
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        }
    }

}
