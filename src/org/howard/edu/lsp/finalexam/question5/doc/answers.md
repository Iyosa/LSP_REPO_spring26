Heuristic 1:
Name:
H2.1: All data should be hidden within its class.

Explanation:
This heuristic makes code much easier to maintain and is the foundation for standard coding rules, like making all data attributes private. By keeping the data hidden, you prevent outside code from messing with the object's internal state, which keeps the class simple and secure.

Heuristic 2:
Name:
H2.8: A class should capture one and only one key abstraction.

Explanation:
This improves readability because it forces a class to have a single, clear purpose. In class, we discussed how mixing multiple abstractions together gives a class way too much unnecessary functionality. Keeping it focused means your documentation stays simple and the code's intent is immediately obvious.

Heuristic 3:
Name:
H3.2: Do not create god classes/objects in your system.

Explanation:
This greatly improves maintainability by preventing a "centrally controlled architecture." In lecture, we looked at the home heating system example where a single HeatFlowRegulator class acted as an "omnipotent controller," pulling all the data from other classes to make decisions. Avoiding this god class ensures that system intelligence is distributed evenly, which prevents massive headaches when you need to add new features later.
