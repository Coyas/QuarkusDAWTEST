package cv.terrasystem.group3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

// anotaçoes de lombok
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString

// daqui para baixo sao do Jakarta

@Entity // isso aqui "talvez" nao pertence a lombok mas sim ao framework Java Persistence API (JPA)
@Table(name = "edu_student")  // se o name nao for especificado sera usado o nome da classe como tabela de BD
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String curso;
    private String morada;
}

