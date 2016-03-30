package net.marton.trainingjournal.rest.api;

import net.marton.trainingjournal.entities.Exercise;
import net.marton.trainingjournal.entities.Person;
import net.marton.trainingjournal.entities.Training;
import net.marton.trainingjournal.entities.TrainingSection;
import net.marton.trainingjournal.service.TrainingService;
import org.picketlink.authorization.annotations.LoggedIn;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by tmarton on 8/30/15.
 */
@Path("/api/trainings")
@Produces("application/json")
@Consumes("application/json")
//@LoggedIn
public class TrainingRest {

    @Inject
    private TrainingService trainingService;

    @GET
    public Response listTrainings() {
        try{
            List<Training> found = trainingService.listTrainings();
            return Response.ok().entity(found).build();
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Path("{id}")
    public Response getTraining(@PathParam("id") Long id) {
        try{
            Training found = trainingService.getTrainingById(id);
            return Response.ok().entity(found).build();
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }
    }

    @POST
    public Response saveTraining(Training training){
        try{
            if (training.getId() == null) {
                trainingService.createTraining(training);
            } else {
                trainingService.updateTraining(training);
            }
            return Response.ok().entity(training).build();
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteTraining(@PathParam("id") Long id) {
        try{
            Training found = trainingService.getTrainingById(id);
            if (found != null) {
                trainingService.deleteTraining(found);
                return Response.ok().build();
            }
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }

        return Response.status(400).build();
    }

    @POST
    @Path("/{id}/sections")
    public Response saveTrainingSection(@PathParam("id") Long id, TrainingSection trainingSection) {
        try{
            Training training = trainingService.getTrainingById(id);
            if (trainingSection.getId() == null) {
                trainingService.createTrainingSection(training,trainingSection);
            } else {
                trainingService.updateTraining(training);
            }
            return Response.ok().entity(training).build();
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}/sections/{sectionId}")
    public Response deleteTrainingSection(@PathParam("sectionId") Long id) {
        try{
            TrainingSection found = trainingService.getTrainingSectionById(id);
            if (found != null) {
                trainingService.deleteTrainingSection(found);
                return Response.ok().build();
            }
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }

        return Response.status(400).build();
    }

    @POST
    @Path("/{id}/sections/{sectionId}/exercises")
    public Response saveExercise(@PathParam("sectionId") Long id, Exercise exercise) {
        try{
            TrainingSection trainingSection = trainingService.getTrainingSectionById(id);
            if (exercise.getId() == null) {
                trainingService.createExercise(trainingSection, exercise);
            } else {
                trainingService.updateExerciseg(exercise);
            }
            return Response.ok().entity(exercise).build();
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }
    }

    @DELETE
    @Path("{id}/sections/{sectionId}/exercises/{exerciseId}")
    public Response deleteTrainingSection(@PathParam("sectionId") Long sectionId, @PathParam("exerciseId") Long exerciseId) {
        try{
            TrainingSection sectionFound = trainingService.getTrainingSectionById(sectionId);
            Exercise exerciseFound = trainingService.getExercideById(exerciseId);
            if (sectionFound != null && exerciseFound != null) {
                trainingService.deleteExercise(sectionFound, exerciseFound);
                return Response.ok().build();
            }
        }
        catch(Exception ex){
            return Response.status(400).entity(ex.getMessage()).build();
        }

        return Response.status(400).build();
    }

}
