
    /**
 * Write a description of class Coin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 public class Coin {
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // destination
    
     public Coin(int cost)
    {
       price = cost;
       balance = 0;
       total = 0;
    }
    
        public void insertMoney(int amount)
       {
           if(amount == 10) 
                {
                   balance = balance + amount;
                   System.out.println("Total amount money inserted: " + balance);
                   total = price - balance;
                   System.out.println("Your current balance: " + total);
                   System.out.println("Your ticket price: " + price);
                }
                else  if (amount == 20)
                {
                    balance = balance + amount;
                    System.out.println("Total amount money inserted: " + balance);
                    total = price - balance;
                    System.out.println("Your current balance: " + total);
                    System.out.println("Your ticket price: " + price);
                }
                else if (amount == 100)
                {
                    balance = balance + amount;
                    System.out.println("Total amount money inserted: " + balance);
                    total = price - balance;
                    System.out.println("Your current balance: " + total);
                    System.out.println("Your ticket price: " + price);
                }
                 else if (amount == 200)
                {
                    balance = balance + amount;
                    System.out.println("Total amount money inserted: " + balance);
                    total = price - balance;
                    System.out.println("Your current balance: " + total);
                    System.out.println("Your ticket price: " + price);
                    }
                    else 
                    {
                        System.out.println("You can only insert 10p, 20, £1.00 and £2.00 coins " + amount);
                    }
    }
     }
