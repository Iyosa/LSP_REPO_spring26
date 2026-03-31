#1 : Hueristics 2.1 
customerName, email, item, and price are all public fields, which allows for users of the class to modify the states directly while bypassing any validation logic.

#2 : Hueristics 3.2
The processOrder methods handles tax calculation, console output, file I/O, email logic, and logging this makes this a "God Class" which hold too much of the system's logic. to change the logic of one method the whole class must be modified which could increase the chance of bugs. Splitting up this class would make maintanance simpler

#3 : Heuristic 2.11
The class is tightly coupled to specific external environments like System.out and FileWriter which makes unit testing impossible. A class should be independent of its environment.

#4 :
The discount logic is applied after the receipt is printed and the data is saved to a file, so the customer never recieves the discount and the result is never used