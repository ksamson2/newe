@Component
public class CreateEntityFunction
  implements Consumer<Message<IDemoEntity>> {

    @Autowired
    private IDemoEntityDao dao;

    @Override
    public void accept(Message<IDemoEntity> m) {

        dao.createEntity(m.getPayload());
        System.out.println("Created entity with name "
          + m.getPayload().getName());
    }
}
