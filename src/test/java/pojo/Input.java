package pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(toBuilder = true)
public class Input {
    @Builder.Default
    String baseUrl = "https://mail.ru/";

    @Builder.Default
    String login = "your_login_here";

    @Builder.Default
    String password = "your_password_here";

    @Builder.Default
    int mailNumber = 1;  // number of a mail in the mailbox from above
}
