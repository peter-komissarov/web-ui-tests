package helpers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.Input;
import pojo.Output;

@Configuration
public class ConfigHelper {

    @Bean
    public Input getInput() {
        return Input.builder().build();
    }

    @Bean
    public Output getOutput() {
        return Output.builder().build();
    }
}
