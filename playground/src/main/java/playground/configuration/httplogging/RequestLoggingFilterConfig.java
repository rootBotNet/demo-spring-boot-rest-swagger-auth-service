/**
 * Logging incoming requests using Spring’s logging filter.
 * Spring provides a mechanism for configuring user-defined interceptors to perform actions before and after web requests.
 * Spring provides a built-in solution to log payloads.
 * AbstractRequestLoggingFilter is a filter which provides basic functions of logging. Subclasses should override the
 * beforeRequest() and afterRequest() methods to perform the actual logging around the request.
 *
 * CommonsRequestLoggingFilter implementation classes can be used to log the incoming request.
 * This logging filter requires the log level be set to DEBUG.
 *
 * We can enable the DEBUG mode by adding the below element in logback.xml:
 * <logger name="org.springframework.web.filter.CommonsRequestLoggingFilter">
 *     <level value="DEBUG" />
 * </logger>
 *
 * Another way of enabling the DEBUG level log is to add the following in application.properties:
 * logging.level.org.springframework.web.filter.CommonsRequestLoggingFilter=DEBUG
 *
 */

package playground.configuration.httplogging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {

    @Bean
    public CommonsRequestLoggingFilter loggingFilter(){
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }
}
