package com.Transactions;

class InvalidAccountNumberException extends RuntimeException {

	int accno;

	InvalidAccountNumberException() {
	}

	InvalidAccountNumberException(int accno) {
		this.accno = accno;
	}

	public String toString() {
		return "Accno : " + accno + "  is Not Found";
	}
}
