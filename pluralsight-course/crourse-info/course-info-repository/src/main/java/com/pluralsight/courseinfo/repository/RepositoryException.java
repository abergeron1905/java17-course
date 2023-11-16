package com.pluralsight.courseinfo.repository;

import java.sql.SQLException;

public class RepositoryException extends Throwable {
    
    public RepositoryException(String message, SQLException e) {
        super(message, e);
    }
}
