Class: Order

Responsibilities: 
Store customer information (name, email) 
Store item details and base price 
Provide data to other classes via getters
Collaborators: None


Class: TaxCalculator

Responsibilities:
Calculate tax based on order price 
Apply discounts for high-value orders (price > 500) 
Determine the final total for the order 
Collaborators: Order

Class: OrderRepository

Responsibilities:
Format order data for storage 
Save processed order details to "orders.txt" 
Manage file streams and exceptions 
Collaborators: Order


Class: NotificationService

Responsibilities:
Format receipt for display 
Send confirmation emails to customers 
Log the time of processing 
Collaborators: Order


Class: OrderProcessor (Controller)

Responsibilities:
Coordinates the order processing 
Does the calculations, storage, and notifications 
Collaborators: Order, TaxCalculator, OrderRepository, NotificationService