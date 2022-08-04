package tables;

import java.util.List;

public interface ITable {
    List list(String[] predicates);
}
