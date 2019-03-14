package com.beiketianzhuang;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DefinitionMySqlSchemaStatVisitor extends MySqlSchemaStatVisitor {

    private List<List<SQLSelectItem>> items = new LinkedList<List<SQLSelectItem>>();

    @Override
    public boolean visit(SQLSelectQueryBlock x) {
        items.add(x.getSelectList());
        return super.visit(x);
    }

    @Override
    public TableStat.Column getColumn(SQLExpr expr) {
        return super.getColumn(expr);
    }

    public List<List<SQLSelectItem>> sqlSelectItems() {
        return Collections.unmodifiableList(items);
    }


}
