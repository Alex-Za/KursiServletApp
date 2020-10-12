package exception;

import java.sql.SQLException;

public class CantFindCountryException extends RuntimeException {
    public CantFindCountryException(SQLException throwables) {
        super(throwables);
    }
}
