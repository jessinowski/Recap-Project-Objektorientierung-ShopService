import java.util.UUID;

public class IdService {
    private String id;

    public String generateId(){
        return UUID.randomUUID().toString();
    }
}
