package tables;

import DB.Group;
import dbConnect.IDBExecutor;
import dbConnect.SqlExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupTable extends AbsTable {
    private IDBExecutor idbExecutor = new SqlExecutor(new ArrayList<>(){{
        add("groupname");
        add("id_curator");
        add("id_group");
    }});
    private final String tableName = "studentgroup";

    @Override
    public List list(String[] predicates) {
        String listGroupQuery = String.format("select * from %s", tableName);

        List<Group> group = new ArrayList<>();

        List<Map<String, String>> result = idbExecutor.execute(listGroupQuery);

        for(Map<String, String> res: result) {
            group.add(
                    new Group(
                            res.get("groupname"),
                            Integer.parseInt(res.get("id_curator")),
                            Integer.parseInt(res.get("id_group"))
                    )
            );
        }

        return group;

    }
}
