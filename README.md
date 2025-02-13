# Loan Eligibility System

## Description

This Java project is a **Loan Eligibility System** that determines whether a customer qualifies for a loan based on their bank balance and credit score. It also calculates the **Equated Monthly Installment (EMI)** based on the approved loan amount, interest rate, and tenure.

## Features

- Register a customer with **ID, name, bank balance, and credit score**.
- Select from four loan types:
  - **Personal Loan**
  - **Home Loan**
  - **Car Loan**
  - **Education Loan**
- Eligibility check based on:
  - **Minimum Bank Balance:** Rs 10,000
  - **Minimum Credit Score:** 600
- Loan approval and maximum loan amount determination based on:
  - **Credit Score 800+:** 5x bank balance, 5.0% interest
  - **Credit Score 700-799:** 4x bank balance, 7.5% interest
  - **Credit Score 600-699:** 2x bank balance, 10.0% interest
- EMI calculation based on loan tenure.

## How to Run

1. **Clone the repository**:
   ```sh
   git clone https://github.com/your-username/Loan-Eligibility-System.git

