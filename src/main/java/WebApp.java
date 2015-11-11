import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import todos.config.DataSourceConfig;

/**
 * Created by andrey on 10.11.15.
 */
@ComponentScan(value = "todos", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "todos.entities"),
        @ComponentScan.Filter(type = FilterType.REGEX, pattern = "todos.config")
})
@EnableAutoConfiguration
@Import(DataSourceConfig.class)
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);

    }
}