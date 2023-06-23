package cv.terrasystem.group3.utils;

import cv.terrasystem.group3.model.DataBean;
import cv.terrasystem.group3.model.PayloadResponse;
import cv.terrasystem.group3.model.Status;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Utils {
    public static PayloadResponse payloadResponse(DataBean bean) {
        return PayloadResponse.builder()
                .status(Status.builder()
                        .code(bean.getCode())
                        .message(bean.getMessage())
                        .error(bean.isError())
                        .build())
                .payload(bean.getPayload())
                .build();
    }
}
