package cv.terrasystem.group3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataBean<T> {
    @Builder.Default
    private int code = 0;
    @Builder.Default
    private String message = "";
    @Builder.Default
    private boolean error = false;
    private T payload;
}
