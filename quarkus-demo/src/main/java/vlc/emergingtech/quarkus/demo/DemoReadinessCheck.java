package vlc.emergingtech.quarkus.demo;

import java.util.Optional;

import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class DemoReadinessCheck implements HealthCheck {

  @Inject
  @ConfigProperty(name = "demo.hello-name")
  private String name;

  @Override
  public HealthCheckResponse call() {
    return HealthCheckResponse.builder().name("demo-config-check")
              .withData("hello-name", name)
              .state(Optional.ofNullable(name).filter(str -> !str.isEmpty()).isPresent())
              .build();
  }

}