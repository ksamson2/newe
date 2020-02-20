@DynamoDBTable(tableName = "DemoEntity")
public class DynamoDemoEntity implements IDemoEntity {

    private String name;
    private String description;

    @Override
    @DynamoDBHashKey
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
