package com.ds.paymentservice;


import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {
    
	@Id
    @Column(name = "paymentid", nullable = false, length = 50)
    private String paymentid;

    @Column(name = "customerid", length = 50)
    private String customerid;
    
    @Column(name = "bookingid", nullable = false, length = 50)
    private String bookingid;

    @Column(name = "amount", length = 100)
    private String amount;

    @Column(name = "txndate", length = 20)
    private Date txndate;
    
    @Column(name = "paymenttype", length = 50)
    private String paymenttype;

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getTxndate() {
		return txndate;
	}

	public void setTxndate(Date txndate) {
		this.txndate = txndate;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

 
}