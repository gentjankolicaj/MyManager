package io.gentjankolicaj.app.mymanager.desktop.db.custom.impl;

import io.gentjankolicaj.app.mymanager.desktop.db.custom.Database;
import io.gentjankolicaj.app.mymanager.desktop.db.datasource.HikariCPManager;
import org.apache.commons.collections4.CollectionUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GenericDatabase extends Database {

    public GenericDatabase() throws Exception {
        super(null, null, false, null, null, 0, null, null, null);
    }


    @Override
    public ResultSet selectStatement(String query) throws SQLException {
        return HikariCPManager.getConnection().createStatement().executeQuery(query);
    }

    @Override
    public PreparedStatement updateStatement(String query) throws SQLException {
        return HikariCPManager.getConnection().prepareStatement(query);
    }

    @Override
    public ResultSet selectStatement(String query, List<Object> list) throws SQLException {
        if (CollectionUtils.isEmpty(list))
            throw new SQLException("Error list of objects empty");

        PreparedStatement preparedStatement = HikariCPManager.getConnection().prepareStatement(query);
        for (int i = 1, len = list.size(); i < len + 1; i++) {
            preparedStatement.setObject(i, list.get(i));
        }
        return preparedStatement.executeQuery();
    }


}
