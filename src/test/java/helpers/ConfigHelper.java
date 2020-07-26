package helpers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import pojo.Input;
import pojo.Output;

@Configuration
public class ConfigHelper {

    //  pojo
    @Scope("prototype")
    @Bean
    Input getInput() {
        return Input.builder().build();
    }

    @Scope("prototype")
    @Bean
    Output getOutput() {
        return Output.builder().build();
    }

    // helpers
    @Scope("prototype")
    @Bean
    AllureHelper getAllureHelper() {
        return new AllureHelper();
    }

    @Scope("prototype")
    @Bean
    DriverHelper getDriverHelper() {
        return new DriverHelper();
    }

    @Scope("prototype")
    @Bean
    MapHelper getMapHelper() {
        return new MapHelper();
    }

    @Scope("prototype")
    @Bean
    ProcessHelper getProcessHelper() {
        return new ProcessHelper();
    }

    @Scope("prototype")
    @Bean
    SelenideHelper getSelenideHelper() {
        return new SelenideHelper();
    }

    @Scope("prototype")
    @Bean
    ThreadHelper getThreadHelper() {
        return new ThreadHelper();
    }
}

