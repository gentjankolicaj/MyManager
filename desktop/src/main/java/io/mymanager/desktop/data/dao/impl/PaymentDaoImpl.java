package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.commons.enums.QueryType;
import io.mymanager.desktop.data.dao.PaymentDao;
import io.mymanager.desktop.data.models.Currency;
import io.mymanager.desktop.data.models.Payment;
import io.mymanager.desktop.data.models.PaymentType;
import io.mymanager.desktop.db.DatabaseManager;
import io.mymanager.desktop.enums.PrintType;
import io.mymanager.desktop.util.PrintUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gentjan kolicaj
 */
public class PaymentDaoImpl implements PaymentDao {

  protected static Database database = DatabaseManager.getDb();

  private QueryType queryType;

  /**
   *
   */
  public PaymentDaoImpl() {
    super();
    this.queryType = QueryType.NORMAL;
  }

  /**
   * @param queryType
   */
  public PaymentDaoImpl(QueryType queryType) {
    super();
    this.queryType = queryType;
  }

  public void setQueryType(QueryType queryType) {
    this.queryType = queryType;
  }

  @Override
  public List<Payment> findAllPayments() throws Exception {
    List<Payment> paymentList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_payments";
    } else {
      query = "SELECT * FROM mymanager.employee_payments_history";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Payment temp = new Payment(results.getInt("payment_id"),
          new PaymentType(results.getString("payment_type")),
          results.getString("employee_id"), new Currency(results.getString("currency")),
          results.getFloat("payment_amount"), results.getString("payment_desc"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      paymentList.add(temp);
    }
    PrintUtils.print(paymentList, PrintType.QUERY_RESULTS);
    return paymentList;
  }

  @Override
  public List<Payment> findAllPayments(int limit, int offset) throws Exception {
    List<Payment> paymentList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_payments LIMIT " + limit + " OFFSET " + offset;
    } else {
      query =
          "SELECT * FROM mymanager.employee_payments_history LIMIT " + limit + " OFFSET " + offset;
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Payment temp = new Payment(results.getInt("payment_id"),
          new PaymentType(results.getString("payment_type")),
          results.getString("employee_id"), new Currency(results.getString("currency")),
          results.getFloat("payment_amount"), results.getString("payment_desc"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      paymentList.add(temp);
    }
    PrintUtils.print(paymentList, PrintType.QUERY_RESULTS);
    return paymentList;
  }

  @Override
  public List<Payment> findAllPaymentsByPaymentType(PaymentType paymentType) throws Exception {
    List<Payment> paymentList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_payments WHERE payment_type LIKE '"
          + paymentType.getPayment()
          + "'";
    } else {
      query = "SELECT * FROM mymanager.employee_payments_history WHERE payment_type LIKE '"
          + paymentType.getPayment() + "'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Payment temp = new Payment(results.getInt("payment_id"),
          new PaymentType(results.getString("payment_type")),
          results.getString("employee_id"), new Currency(results.getString("currency")),
          results.getFloat("payment_amount"), results.getString("payment_desc"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      paymentList.add(temp);
    }
    PrintUtils.print(paymentList, PrintType.QUERY_RESULTS);
    return paymentList;
  }

  @Override
  public List<Payment> findAllPaymentsByDescription(String paymentDescription) throws Exception {
    List<Payment> paymentList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query =
          "SELECT * FROM mymanager.employee_payments WHERE payment_desc LIKE '" + paymentDescription
              + "%'";
    } else {
      query = "SELECT * FROM mymanager.employee_payments_history WHERE payment_desc LIKE '"
          + paymentDescription
          + "%'";
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Payment temp = new Payment(results.getInt("payment_id"),
          new PaymentType(results.getString("payment_type")),
          results.getString("employee_id"), new Currency(results.getString("currency")),
          results.getFloat("payment_amount"), results.getString("payment_desc"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      paymentList.add(temp);
    }
    PrintUtils.print(paymentList, PrintType.QUERY_RESULTS);
    return paymentList;
  }

  @Override
  public List<Payment> findAllPaymentsByEmployeeId(String employeeId) throws Exception {
    List<Payment> paymentList = new ArrayList<>();
    ResultSet results = null;
    String query = null;
    if (queryType.equals(QueryType.NORMAL)) {
      query = "SELECT * FROM mymanager.employee_payments WHERE employee_id=" + employeeId;
    } else {
      query = "SELECT * FROM mymanager.employee_payments_history WHERE employee_id=" + employeeId;
    }

    results = database.selectStatement(query);
    while (results.next()) {
      Payment temp = new Payment(results.getInt("payment_id"),
          new PaymentType(results.getString("payment_type")),
          results.getString("employee_id"), new Currency(results.getString("currency")),
          results.getFloat("payment_amount"), results.getString("payment_desc"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
      paymentList.add(temp);
    }
    PrintUtils.print(paymentList, PrintType.QUERY_RESULTS);
    return paymentList;
  }

  @Override
  public Payment findPayment(int paymentId) throws Exception {
    Payment payment = null;
    ResultSet results = null;
    String query = "SELECT * FROM mymanager.employee_payments WHERE payment_id=" + paymentId;

    results = database.selectStatement(query);
    while (results.next()) {
      payment = new Payment(results.getInt("payment_id"),
          new PaymentType(results.getString("payment_type")),
          results.getString("employee_id"), new Currency(results.getString("currency")),
          results.getFloat("payment_amount"), results.getString("payment_desc"),
          results.getString("created_by"), results.getString("updated_by"),
          results.getTimestamp("created_date").toLocalDateTime(),
          results.getTimestamp("updated_date").toLocalDateTime());
    }
    PrintUtils.print(payment, PrintType.QUERY_RESULTS);
    return payment;
  }

  @Override
  public int updatePayment(Payment oldPayment, Payment newPayment) throws Exception {
    String query =
        "UPDATE mymanager.employee_payments SET payment_id=?,payment_type=?,employee_id=?,currency=?,payment_amount=?,payment_desc=?,"
            + "created_by=?,created_date=?,updated_by=?,updated_date=? WHERE payment_id=?";

    setQueryType(QueryType.NORMAL);
    Payment temp = findPayment(oldPayment.getPaymentId());
    savePreviousRow(temp);

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setInt(1, newPayment.getPaymentId());
    pstmt.setString(2, newPayment.getPaymentType().getPayment());
    pstmt.setString(3, newPayment.getEmployeeId());
    pstmt.setString(4, newPayment.getCurrency().getCurrencyName());
    pstmt.setFloat(5, newPayment.getPaymentAmount());
    pstmt.setString(6, newPayment.getPaymentDescription());
    pstmt.setString(7, newPayment.getCreatedBy());
    pstmt.setObject(8, newPayment.getCreatedDate());
    pstmt.setString(9, newPayment.getUpdatedBy());
    pstmt.setObject(10, newPayment.getUpdatedDate());
    pstmt.setInt(11, oldPayment.getPaymentId());

    return pstmt.executeUpdate();
  }

  @Override
  public int savePayment(Payment payment) throws Exception {
    String query = "INSERT INTO mymanager.employee_payments (payment_type,employee_id,currency,payment_amount,payment_desc,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, payment.getPaymentType().getPayment());
    pstmt.setString(2, payment.getEmployeeId());
    pstmt.setString(3, payment.getCurrency().getCurrencyName());
    pstmt.setFloat(4, payment.getPaymentAmount());
    pstmt.setString(5, payment.getPaymentDescription());
    pstmt.setString(6, payment.getCreatedBy());
    pstmt.setObject(7, payment.getCreatedDate());
    pstmt.setString(8, payment.getUpdatedBy());
    pstmt.setObject(9, payment.getUpdatedDate());

    return pstmt.executeUpdate();
  }

  @Override
  public int deletePayment(Payment payment) throws Exception {
    String query = "DELETE FROM mymanager.employee_payments WHERE payment_id=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setInt(1, payment.getPaymentId());

    return pstmt.executeUpdate();
  }

  public int savePreviousRow(Payment payment) throws Exception {
    String query = "INSERT INTO mymanager.employee_payments_history (payment_id,payment_type,employee_id,currency,payment_amount,payment_desc,created_by,created_date,updated_by,updated_date) VALUES (?,?,?,?,?,?,?,?,?,?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setInt(1, payment.getPaymentId());
    pstmt.setString(2, payment.getPaymentType().getPayment());
    pstmt.setString(3, payment.getEmployeeId());
    pstmt.setString(4, payment.getCurrency().getCurrencyName());
    pstmt.setFloat(5, payment.getPaymentAmount());
    pstmt.setString(6, payment.getPaymentDescription());
    pstmt.setString(7, payment.getCreatedBy());
    pstmt.setObject(8, payment.getCreatedDate());
    pstmt.setString(9, payment.getUpdatedBy());
    pstmt.setObject(10, payment.getUpdatedDate());

    return pstmt.executeUpdate();
  }

}
