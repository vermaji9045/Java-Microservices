package com.Loan.Service.impl;

import com.Loan.DTO.LoansDto;
import com.Loan.Entity.Loans;

public interface IServiceLoan {

    void createLoan(String mobileNumber);
    LoansDto Fetch(String mobileNumber);
    boolean update(LoansDto loansDto);
    boolean delete(String mobileNumber);
}
