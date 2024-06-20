package io.mymanager.desktop.data.dao.impl;

import io.mymanager.commons.db.Database;
import io.mymanager.desktop.data.dao.PaymentTypeDao;
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
public class PaymentTypeDaoImpl implements PaymentTypeDao {

  protected static Database database = DatabaseManager.getDb();

  @Override
  public List<PaymentType> findAllPaymentTypes() throws Exception {
    List<PaymentType> paymentTypeList = new ArrayList<>();
    ResultSet results = null;
    String query = "Select * FROM mymanager.payment_type";

    results = database.selectStatement(query);
    while (results.next()) {
      PaymentType temp = new PaymentType(results.getString("payment_type"));
      paymentTypeList.add(temp);
    }
    PrintUtils.print(paymentTypeList, PrintType.QUERY_RESULTS);
    return paymentTypeList;

  }

  @Override
  public PaymentType findPaymentType(String paymentType) throws Exception {
    PaymentType paymentTypeObj = null;
    ResultSet results = null;
    String query = "Select * FROM mymanager.payment_type WHERE payment_type=" + paymentType;

    results = database.selectStatement(query);
    while (results.next()) {
      paymentTypeObj = new PaymentType(results.getString("payment_type"));
    }
    PrintUtils.print(paymentTypeObj, PrintType.QUERY_RESULTS);
    return paymentTypeObj;

  }

  @Override
  public int savePaymentType(PaymentType paymentType) throws Exception {
    String query = "INSERT INTO mymanager.payment_type (payment_type) VALUES (?)";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, paymentType.getPayment());

    return pstmt.executeUpdate();
  }

  @Override
  public int updatePaymentType(PaymentType oldPaymentType, PaymentType newPaymentType)
      throws Exception {
    String query = "UPDATE mymanager.payment_type SET payment_type=? WHERE payment_type=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, newPaymentType.getPayment());
    pstmt.setString(2, oldPaymentType.getPayment());

    return pstmt.executeUpdate();
  }

  @Override
  public int deletePaymentType(PaymentType paymentType) throws Exception {
    String query = "DELETE FROM mymanager.payment_type WHERE payment_type=?";

    PreparedStatement pstmt = database.updateStatement(query);
    pstmt.setString(1, paymentType.getPayment());

    return pstmt.executeUpdate();
  }

}
