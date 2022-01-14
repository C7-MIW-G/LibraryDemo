package nl.miwgroningen.se.ch7.advanced.vincent.libraryDemo.configuration;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 */

@Configuration
public class LibraryTemplateDialectConfiguration {

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
