package net.marton.trainingjournal.rest.api;

import net.marton.trainingjournal.entities.Person;
import net.marton.trainingjournal.service.PersonService;
import org.picketlink.authorization.annotations.LoggedIn;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by tmarton on 9/2/15.
 */
@Path("/api/persons")
@Produces("application/json")
@Consumes("application/json")
//@LoggedIn
public class PersonRest {

    @Inject
    private PersonService personService;

    @GET
    public Response listPersons() {
        try{
            List<Person> found = personService.listPersons();
            return Response.ok().entity(found).build();
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    public Response getPerson(@PathParam("id") Long id) {
        try{
            Person found = personService.getPersonById(id);
            return Response.ok().entity(found).build();
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }
    }

    @POST
    public Response save(Person person){
        try{
            if (person.getId() == null) {
                personService.createUser(person);
            } else {
                personService.updatePerson(person);
            }
            return Response.ok().entity(person).build();
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deletePerson(@PathParam("id") Long id) {
        try{

            Person found = personService.getPersonById(id);
            if (found != null) {
                personService.deletePerson(found);
                return Response.ok().build();
            }
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }

        return Response.status(400).build();
    }
}
