package cv.terrasystem.group3.resource.v1;

import cv.terrasystem.group3.constant.Constants;
import cv.terrasystem.group3.model.DataBean;
import cv.terrasystem.group3.model.PayloadResponse;
import cv.terrasystem.group3.model.Student;
import cv.terrasystem.group3.repository.StudentRepository;
import cv.terrasystem.group3.utils.Utils;
import jakarta.inject.Inject;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.transaction.Transactional;




@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    @Inject
    StudentRepository studentRepository;


    @GET
    @Tag(name = Constants.ENDPOINT_TAG_ALUNOS_LOCATION)
    @Operation(summary = Constants.RETORNA_IP_ADDRESS_SUMMARY, description = Constants.RETORNA_IP_ADDRESS)
    @Path("/students/grades")
    public String getNotas(@NotNull @HeaderParam("X-Type-Format") String typeFormat,
                           @PathParam("id") int id,
                           @QueryParam("curso") int curso,
                           @QueryParam("ano") int ano
    ){
        return "Resources get IP using Text: " + typeFormat + " " + ano + " " + id + " " + curso;
    }

    @GET
    @Tag(name = Constants.ENDPOINT_TAG_ALUNOS_LOCATION)
    @Operation(summary = Constants.RETORNA_IP_ADDRESS_SUMMARY, description = Constants.RETORNA_IP_ADDRESS)
    @Path("/students")
    public PayloadResponse getStudents(){
        return Utils.payloadResponse(
                DataBean
                        .builder()
                        .code(0)
                        .payload(studentRepository.findAllStudent())
                .build());
    }

    @DELETE
    @Tag(name = Constants.ENDPOINT_TAG_ALUNOS_LOCATION)
    @Operation(summary = Constants.ENDPOINT_TAG_ALUNOS_DELETE, description = "elimina um aluno baseado num ip")
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/students/{id}")
    public String deleteAluno(@PathParam("id") int id){
        return "Aluno deletedo com sucesso: " + id;
    }

    @POST
    @Tag(name = Constants.ENDPOINT_TAG_ALUNOS_LOCATION)
    @Operation(summary = "POST de Alunos para H2", description = "envia dados por um formulario para o banco de dados H2")
    @Path("/students")
    @Transactional
    public PayloadResponse insertAluno(Student student) {
        return studentRepository.save(student);
    }

    @PUT
    @Tag(name = Constants.ENDPOINT_TAG_ALUNOS_LOCATION)
    @Operation(summary = "Atualiza dados", description = "atualiza dados por um formulario")
    @Path("/students/{id}")
    public String updateAluno(@PathParam("id") int id) {
        return "aluno atualizado com sucesso";
    }

    @PATCH
    @Tag(name = Constants.ENDPOINT_TAG_ALUNOS_LOCATION)
    @Operation(summary = "Atualiza mini dados", description = "atualiza mini dados por um formulario")
    @Path("/students/{id}/")
    public String miniupdateAluno(@PathParam("id") int id) {
        return "alguns dados do aluno atualizado com sucesso";
    }
}
