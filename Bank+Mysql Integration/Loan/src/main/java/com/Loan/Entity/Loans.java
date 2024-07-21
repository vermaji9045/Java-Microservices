package com.Loan.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "LOANS")
@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Loans extends BaseEntity{

  @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long Loan_id;

    private String mobileNumber;
    private String loanNumber;
    private String LoanType;
    private int TotalLoan;
    private int amountPaid;
    private int outstandingAmount;



}
