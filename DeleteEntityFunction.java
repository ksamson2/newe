@Component
public class DeleteEntityFunction implements Consumer<Message<Void>> {
    @Autowired
    private IDemoEntityDao dao;

    @Override
    public void accept(Message<Void> m) {

        String name = (String) m.getHeaders().get("name");

        dao.deleteEntity(name);

        System.out.println("Deleted entity with name " + name);
    }
}
