public class DynamoDemoEntityDeserializer
  extends JsonDeserializer<DynamoDemoEntity> {

    @Override
    public DynamoDemoEntity deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);
        DynamoDemoEntity entity = new DynamoDemoEntity();

        if (node.has("name")) {
            entity.setName(node.get("name").asText());
        }

        if (node.has("description")) {
            entity.setDescription(node.get("description").asText());
        }

        return entity;
    }
}
