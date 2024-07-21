package com.Loan.Service.impl;

import com.Loan.Constants.LoansConstants;
import com.Loan.DTO.LoansDto;
import com.Loan.Entity.Loans;
import com.Loan.Exception.LoanAlreadyExistsException;
import com.Loan.Exception.ResourceNotFoundException;
import com.Loan.Mapper.LoansMapper;
import com.Loan.Repository.LoansRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class LoanService implements IServiceLoan{


    @Autowired
    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {

        Optional<Loans> loans=loansRepository.findByMobileNumber(mobileNumber);

        if(loans.isPresent())
        {

            throw new LoanAlreadyExistsException("Loan Already registered with the given number " +mobileNumber);
        }
        loansRepository.save(createNewLoan(mobileNumber));
    }



    private Loans createNewLoan(String mobileNumber) {
        Loans newLoan = new Loans();
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        newLoan.setLoanNumber(Long.toString(randomLoanNumber));
        newLoan.setMobileNumber(mobileNumber);
        newLoan.setLoanType(LoansConstants.HOME_LOAN);
        newLoan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        newLoan.setAmountPaid(0);
        newLoan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return newLoan;
    }

    @Override
    public LoansDto Fetch(String mobileNumber) {

        Loans loans=loansRepository.findByMobileNumber(mobileNumber).orElseThrow(

                ()-> new ResourceNotFoundException("Loans","MobileNumber",mobileNumber)
        );

        return LoansMapper.mapToLoanDto(loans, new LoansDto());
    }

    @Override
    public boolean update(LoansDto loansDto) {

        Loans loans=loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(

                ()->new ResourceNotFoundException("Loans", "LoansNumber",loansDto.getLoanNumber())
        );
        LoansMapper.mapToLoan(loansDto,loans);
        loansRepository.save(loans);
        return true;
    }

    @Override
    public boolean delete(String mobileNumber) {

        Loans loans=loansRepository.findByMobileNumber(mobileNumber).orElseThrow(

                ()-> new ResourceNotFoundException("Loan","Mobile Number",mobileNumber)
        );
        loansRepository.deleteById(loans.getLoan_id());
        return true;
    }


}
