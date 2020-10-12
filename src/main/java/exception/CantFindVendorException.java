package exception;

import java.sql.SQLException;

public class CantFindVendorException extends Throwable {
    public CantFindVendorException(SQLException throwables) {
        super(throwables);
    }
}
