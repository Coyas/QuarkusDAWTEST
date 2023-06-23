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
public class WanIp {
    @Builder.Default
    private String ip = "not-define";
    @Builder.Default
    private String location = "not-defined";
}
