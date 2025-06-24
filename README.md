# Lottery System Coding Solution
## Description
This project implements a **weighted lottery system** where customers can buy lottery tickets priced from **1 cent to 100 dollars**. At the end of the ticket sale, a **lucky draw** is conducted.

The core requirement is that the **probability of winning** should be **proportional to the amount paid**. That is, someone who pays more should have a higher chance of winning — just like spinning a weighted wheel.

## Approach
### Explaination
Think of the lottery as a **spin wheel** where each customer's share on the wheel is proportional to the price they paid for the ticket.  
The total ticket value defines the **entire wheel size**, and each participant owns a section of that wheel.

---

let's take an example
```
A pays 50 cents
B pays 1 dollar / 100 cents
C pays 90 dollar / 9000 cents

total = 50 + 100 + 9000 = 9150 cents

Share of A = 100 / 9150 = 0.0054
Share of B = 100 / 9150 = 0.0109
Share of C = 9000 / 9150 = 0.9836

Hence winning chances of C is higher

lets say D came and vuys 50 dollar ticket
D pays 50 dollar / 5000 cents

new total = 50 + 100 + 9000 + 5000 = 14150

revise shares
A ->  50 / 14150
B ->  100 / 14150
C ->  9000 / 14150
D ->  5000 / 14150
```

### Winner Selection Algorithm
1. Generate a **random number** between `1` and `total` (inclusive).
2. Iterate through the candidates and **keep adding their paid amounts**.
3. The candidate whose **cumulative sum** either **meets or exceeds** the random number is declared the **winner**.

---

## Mini Example
```
Example
A = 10
B = 50
C = 60

total = 120

random number = 55

lets add them
A = 10
B = 60
C = 150

we see at B the value overflowed hence B is the winner.
```

