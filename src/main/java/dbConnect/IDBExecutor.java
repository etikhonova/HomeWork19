package dbConnect;

import java.util.List;
import java.util.Map;

public interface IDBExecutor {
    List<Map<String, String>> execute(String query);
}
