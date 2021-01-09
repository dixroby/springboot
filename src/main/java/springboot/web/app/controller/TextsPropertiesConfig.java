package springboot.web.app.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:texts.properties")
})
public class TextsPropertiesConfig {

}
