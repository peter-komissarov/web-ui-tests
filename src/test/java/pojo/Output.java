package pojo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class Output {
    @Builder.Default
    String body = "expected_email_body";

    @Builder.Default
    String subject = "expected_email_subject";

    @Builder.Default
    String sender = "expected_email_sender";
}
