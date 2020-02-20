@SpringBootApplication
public class SpringCloudFunctionAwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFunctionAwsApplication.class, args);
    }

    @Bean
    public GetEntityFunction getEntityFunction() {

        return new GetEntityFunction();
    }

    @Bean
    public CreateEntityFunction createEntityFunction() {

        return new CreateEntityFunction();
    }

    @Bean
    public UpdateEntityFunction updateEntityFunction() {

        return new UpdateEntityFunction();

    }

    @Bean
    public DeleteEntityFunction deleteEntityFunction() {

        return new DeleteEntityFunction();
    }
}
