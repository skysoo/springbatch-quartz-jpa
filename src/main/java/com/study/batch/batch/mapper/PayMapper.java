package com.study.batch.batch.mapper;

import com.study.batch.dto.Pay;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PayMapper implements RowMapper<Pay> {

    @Override
    public Pay mapRow(ResultSet resultSet, int i) throws SQLException {
        return Pay.builder()
                .id(resultSet.getLong(1))
                .amount(resultSet.getLong(2))
                .txDateTime(resultSet.getString(3))
                .txName(resultSet.getString(4))
                .build();
    }
}
