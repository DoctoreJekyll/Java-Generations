package org.example.mapper;

import java.sql.ResultSet;

public interface BaseMapper<T> {
    T toModel(ResultSet rs);
}
