package cv.terrasystem.group3.swagger;

import cv.terrasystem.group3.constant.Constants;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name = Constants.ENDPOINT_TAG_ALUNOS_LOCATION, description = Constants.ALUNOS_DESCRIPTION)
        },
        info = @Info(
                title = "Servico da UNICV  - API",
                description = "e-Service - serviços unicv para os alunos",
                version = "0.0.1",
                contact = @Contact(
                        name = " Support UNICV",
                        url = "https://unicv.cv",
                        email = "support@unicv.cv"
                ),
                license = @License(
                    name = "Licença CLoud",
                    url = "https://terrasystem.cv"
                )
        )
)
public class SwaggerConfig extends Application {
}
