package com.beiketianzhuang;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;

import java.util.List;
import java.util.Map;

import static com.alibaba.druid.util.JdbcConstants.MYSQL;

public class SqlParser {

    public Map<String, ColumnItem> parser(String sql) {
        DefinitionMySqlSchemaStatVisitor visitor = new DefinitionMySqlSchemaStatVisitor();
        List<SQLStatement> sqlStatements = SQLUtils.parseStatements(sql, MYSQL);
        SQLStatement sqlStatement = sqlStatements.get(0);
        sqlStatement.accept(visitor);
        List<List<SQLSelectItem>> items = visitor.sqlSelectItems();
        for (List<SQLSelectItem> item : items) {
            for (SQLSelectItem sqlSelectItem : item) {
                SQLExpr expr = sqlSelectItem.getExpr();

            }

        }



        return null;
    }

    public static void main(String[] args) {
        SqlParser sqlParser = new SqlParser();
        sqlParser.parser("select u.name,u.age,c.card from user u inner join (select * from card) c on c.uid = u.uid");
    }

}
