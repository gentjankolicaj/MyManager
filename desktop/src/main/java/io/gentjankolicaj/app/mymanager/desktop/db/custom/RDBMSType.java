package io.gentjankolicaj.app.mymanager.desktop.db.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author gentjan kolicaj
 */
@AllArgsConstructor
@Getter
public enum RDBMSType {
    MySQL("MySQL"), ORACLE("ORACLE"), PostgreSQL(" PostgreSQL");
    private final String value;
}
