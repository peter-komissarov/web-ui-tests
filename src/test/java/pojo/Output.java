package pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class Output {
    @Builder.Default
    String body = "expected_email_body";

    @Builder.Default
    String subject = "expected_email_subject";

    @Builder.Default
    String sender = "expected_email_sender";
}
