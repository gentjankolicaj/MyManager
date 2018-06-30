package com.mymanager.data.models;

/**
 * 
 * @author gentjan koliçaj
 *
 */
public class PaymentType extends MyModel {

	private String payment;

	/**
	 * 
	 */
	public PaymentType() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param payment
	 */
	public PaymentType(String payment) {
		super();
		this.payment = payment;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String toNormal() {
		String cls = getClass().getSimpleName();
		String text = cls + ": paymentType:" + payment;
		return text;
	}

	@Override
	public String toJson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toXml() {
		// TODO Auto-generated method stub
		return null;
	}

}
