import java.util.Scanner;


class Customer 
{
    private int id;
    private String name;
    private int bankBalance; 
    private int creditScore;

    public Customer(int id, String name, int bankBalance, int creditScore) 
	{
        this.id = id;
        this.name = name;
        this.bankBalance = bankBalance;
        this.creditScore = creditScore;
    }
    public int getId() 
	{
        return id;
    }

    public String getName() 
	{
        return name;
    }
    public int getBankBalance() 
	{
        return bankBalance;
    }
    public int getCreditScore() 
	{
        return creditScore;
    }
    public void displayCustomerInfo() 
	{
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Bank Balance: Rs " + bankBalance);
        System.out.println("Credit Score: " + creditScore);
    }
}

class Loan {
    private String loanType;
    private int maxLoanAmount;
    private double interestRate;
    private int tenure; 

    public Loan(String loanType, int maxLoanAmount, double interestRate, int tenure) 
	{
        this.loanType = loanType;
        this.maxLoanAmount = maxLoanAmount;
        this.interestRate = interestRate;
        this.tenure = tenure;
    }
    public String getLoanType() 
	{
        return loanType;
    }
    public int getMaxLoanAmount() 
	{
        return maxLoanAmount;
    }
    public double getInterestRate() 
	{
        return interestRate;
    }
    public int getTenure() 
	{
        return tenure;
    }
    public double calculateEMI() 
	{
        double r = (interestRate / 12) / 100; 
        int n = tenure; 
        double P = maxLoanAmount; 
        return (P * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
    }

    public void displayLoanDetails() 
	{
        System.out.println("Loan Type: " + loanType);
        System.out.println("Max Loan Amount: Rs " + maxLoanAmount);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Tenure: " + tenure + " months");
        System.out.printf("EMI (Equated Monthly Installment): Rs %.2f\n", calculateEMI());
    }
}


class LoanSystem 
{
    private static final int MIN_BALANCE = 10000;
    private static final int MIN_CREDIT_SCORE = 600;

    public static Loan determineLoan(Customer customer, String loanType, int tenure) 
	{
        int balance = customer.getBankBalance();
        int creditScore = customer.getCreditScore();
        if (balance < MIN_BALANCE || creditScore < MIN_CREDIT_SCORE) 
		{
            System.out.println("\nLoan Application Rejected!");
            System.out.println("Reason: Insufficient Bank Balance or Low Credit Score.");
            return null;
        }
        int maxLoanAmount;
        double interestRate;
        if (creditScore >= 800) 
		{
            maxLoanAmount = balance * 5;
            interestRate = 5.0;
        } 
		else if (creditScore >= 700) 
		{
            maxLoanAmount = balance * 4;
            interestRate = 7.5;
        } 
		else 
		{
            maxLoanAmount = balance * 2;
            interestRate = 10.0;
        }

        return new Loan(loanType, maxLoanAmount, interestRate, tenure);
    }
}


class Main2
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Bank Balance (Rs): ");
        int bankBalance = scanner.nextInt();
        System.out.print("Enter Credit Score (300-850): ");
        int creditScore = scanner.nextInt();
        Customer customer = new Customer(id, name, bankBalance, creditScore);
        System.out.println("\nCustomer Registered Successfully!\n");
        System.out.println("Available Loan Types:");
        System.out.println("1. Personal Loan");
        System.out.println("2. Home Loan");
        System.out.println("3. Car Loan");
        System.out.println("4. Education Loan");
        System.out.print("Choose Loan Type (1-4): ");
        int loanChoice = scanner.nextInt();
        String loanType = "";
        switch (loanChoice) {
            case 1:
                loanType = "Personal Loan";
                break;
            case 2:
                loanType = "Home Loan";
                break;
            case 3:
                loanType = "Car Loan";
                break;
            case 4:
                loanType = "Education Loan";
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                return;
        }
        System.out.print("Enter Loan Tenure (in months): ");
        int tenure = scanner.nextInt();
        Loan loan = LoanSystem.determineLoan(customer, loanType, tenure);
        if (loan != null) 
		{
            System.out.println("\nLoan Approved!");
            loan.displayLoanDetails();
        }
    }
}
