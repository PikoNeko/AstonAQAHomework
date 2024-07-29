package lesson17.POJOClasses.getClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;

@JsonRootName("headers")
@Getter
public class POJOGetHeader {

    private String host;

    @JsonProperty("x-request-start")
    private String xRequestStart;

    @JsonProperty("x-forwarded-proto")
    private String xForwardedProto;

    @JsonProperty("x-forwarded-port")
    private String xForwardedPort;

    @JsonProperty("x-amzn-trace-id")
    private String xAmazonTraceId;

    private String accept;

    @JsonProperty("user-agent")
    private String userAgent;

    @JsonProperty("accept-encoding")
    private String acceptEncoding;

}
