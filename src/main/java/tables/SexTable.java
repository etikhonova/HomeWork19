package tables;
import DB.Sex;
import dbConnect.IDBExecutor;
import dbConnect.SqlExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SexTable extends AbsTable{
    private IDBExecutor idbExecutor = new SqlExecutor(new ArrayList<>(){{
        add("sex_name");
        add("id_sex");

    }});
    private final String tableName = "sex";

    @Override
    public List list(String[] predicates) {
        String listSexQuery = String.format("select * from %s", tableName);

        List<Sex> sex = new ArrayList<>();

        List<Map<String, String>> result = idbExecutor.execute(listSexQuery);

        for(Map<String, String> res: result) {
            sex.add(
                    new Sex(
                            res.get("sex_name"),
                            Integer.parseInt(res.get("id_sex"))

                    )
            );
        }

        return sex;

    }
}
