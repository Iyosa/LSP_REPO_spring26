#1 :
The discount percentages are hard coded and buried in if statements, making them hard to maintain or reuse

#2 :
The class is closed to extension but open to modification, so to add a new customer type you have to physically open the class' file and manually add a new if statement

#3 : 
The class requiring modifying the existing calculatePrice method risks breaking the current logic