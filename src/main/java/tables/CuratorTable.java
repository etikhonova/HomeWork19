package tables;

import DB.Curator;
import DB.Group;
import dbConnect.IDBExecutor;
import dbConnect.SqlExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CuratorTable extends AbsTable{
    private IDBExecutor idbExecutor = new SqlExecutor(new ArrayList<>(){{
        add("fio");
        add("id_curator");
    }});
    private final String tableName = "curator";

    @Override
    public List list(String[] predicates) {
        String listCuratorQuery = String.format("select * from %s", tableName);

        List<Curator> curator = new ArrayList<>();

        List<Map<String, String>> result = idbExecutor.execute(listCuratorQuery);

        for(Map<String, String> res: result) {
            curator.add(
                    new Curator(
                            res.get("fio"),
                            Integer.parseInt(res.get("id_curator"))
                    )
            );
        }

        return curator;

    }

}
