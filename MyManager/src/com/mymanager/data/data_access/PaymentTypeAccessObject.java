package com.mymanager.data.data_access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mymanager.data.data_access.interfaces.PaymentTypeAccess;
import com.mymanager.data.database.Database;
import com.mymanager.data.database.DatabaseManager;
import com.mymanager.data.database.DatabasePool;
import com.mymanager.data.models.PaymentType;
import com.mymanager.utils.PrintType;
import com.mymanager.utils.PrintUtils;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class PaymentTypeAccessObject implements PaymentTypeAccess {

	protected static Database database = DatabasePool.getReference(DatabaseManager.getRecentInstanceNumber());

	@Override
	public List<PaymentType> readAllPaymentTypes() throws Exception {
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
	public PaymentType readPaymentType(String paymentType) throws Exception {
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
	public int insertPaymentType(PaymentType paymentType) throws Exception {
		String query = "INSERT INTO mymanager.payment_type (payment_type) VALUES (?)";

		PreparedStatement pstmt = database.updateStatement(query);
		pstmt.setString(1, paymentType.getPayment());

		return pstmt.executeUpdate();
	}

	@Override
	public int updatePaymentType(PaymentType oldPaymentType, PaymentType newPaymentType) throws Exception {
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
