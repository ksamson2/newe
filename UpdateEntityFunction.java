@Component
public class UpdateEntityFunction
  implements Consumer<Message<IDemoEntity>> {

    @Autowired
    private IDemoEntityDao dao;

    @Override
    public void accept(Message<IDemoEntity> m) {

        String name = (String) m.getHeaders().get("name");

        Optional<IDemoEntity> entity = dao.getEntity(name);
        entity.get().setDescription(m.getPayload().getDescription());
        dao.updateEntity(entity.get());

        System.out.println("Updated entity with name " + name);
    }
}
