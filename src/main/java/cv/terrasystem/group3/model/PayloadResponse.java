package cv.terrasystem.group3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayloadResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Status status;
    private T payload = (T) new ArrayList<T>();
}
