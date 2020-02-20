@Component
public class GetEntityFunction
  implements Function<Message<Void>, Message<IDemoEntity>> {

    @Autowired
    private IDemoEntityDao dao;

    @Override
    public Message<IDemoEntity> apply(Message<Void> m) {

        String name = (String) m.getHeaders().get("name");

        Optional<IDemoEntity> response = dao.getEntity(name);

        Message<IDemoEntity> message
          = MessageBuilder.withPayload(response.get())
          .setHeader("contentType", "application/json").build();
        return message;
    }
}
