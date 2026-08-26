package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {

    private static final String DB_URL = System.getProperty("datasource.url");
    private static final QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    @SneakyThrows
    public static Connection getConnection() {
        return DriverManager.getConnection(DB_URL, "app", "pass");
    }

    @SneakyThrows
    public static void clear() {
        var connection = getConnection();
        runner.execute(connection, "DELETE FROM credit_request_entity");
        runner.execute(connection, "DELETE FROM order_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
    }

    @SneakyThrows
    public static String getDebitPaymentStatus() {
        var sqlStatus = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        var connection = getConnection();
        return runner.query(connection, sqlStatus, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditPaymentStatus() {
        var connection = getConnection();
        var sqlStatus = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        return runner.query(connection, sqlStatus, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getDebitOrderEntryId() {
        var sqlStatus = "SELECT payment_id FROM order_entity ORDER BY created DESC LIMIT 1";
        var connection = getConnection();
        return runner.query(connection, sqlStatus, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getDebitPaymentID() {
        var sql = "SELECT transaction_id FROM payment_entity ORDER BY created DESC LIMIT 1";
        var connection = getConnection();
        return runner.query(connection, sql, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditRequestReEntryId() {
        var sql = "SELECT bank_id FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        var connection = getConnection();
        return runner.query(connection, sql, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditOrderEntryId() {
        var sql = "SELECT credit_id FROM order_entity ORDER BY created DESC LIMIT 1";
        var connection = getConnection();
        return runner.query(connection, sql, new ScalarHandler<>());
    }
}