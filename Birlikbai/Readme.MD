**Final Project: "Bus ticket reservation system"**

**Variant_1**

This project is a system for booking bus tickets. In it, users can
reserve seats for a bus ride, they also can choose the Route. The Administrator 
and Bus Drivers also have access to this system, for this they need 
to log in, after authorization, the 
Administrator gets access to monitoring and direct digital control
of the tickets booking system, as well as to the management of the bus
fleet and driver staff, Drivers, after authorization, can view their
schedule in a real time.


****
**Functionality:**

*For User:*
* User can buy ticket without any registration
* User can choose the Route (from Schedule)
* User can see the chosen trip information
* User can choose the seats
* After Entering all needed information, user has made a payment
* in the end System will print digital ticket for customer, 
which also be stored in the system itself 

*For Administrator*
* Admin can login to the system
* Admin can CRUD Bus
* Admin can CRUD Driver (add new, delete, update driver's schedule)
* Admin can CRUD Trip (Schedule)
* Admin can't delete bookings, but he will be able to delete schedule (which will be oneToMany to booking) 


*For Driver*
* Driver can login to the system
* After login Driver will have access to his schedules

***

***EndPoints***

tables:
* 1.Admin
* 2.Bus
* 3.Driver
* 4.Schedule
* 5.Booking
* 6.Payment

*User*  
* Main Page - http://localhost:8080/user/index
* Trip info - http://localhost:8080/user/buyTicket
* Payment -  http://localhost:8080/user/payment
* Show Ticket - http://localhost:8080/user/showTicket

*Admin*
* Admin Home - http://localhost:8080/admin/adminHome


* adminBus - http://localhost:8080/admin/adminBus/busList
* editBus - http://localhost:8080/admin/adminBus/edit?id=
* addBus - http://localhost:8080/admin/adminBus/new


* adminDriver - http://localhost:8080/admin/adminDriver/driverList
* editDriver - http://localhost:8080/admin/adminDriver/edit?id=
* addDriver - http://localhost:8080/admin/adminDriver/new


* adminSchedule - http://localhost:8080/admin/adminSchedule/scheduleList
* editSchedule - http://localhost:8080/admin/adminSchedule/edit?id=
* addSchedule - http://localhost:8080/admin/adminSchedule/new


* adminBooking - http://localhost:8080/admin/adminBooking/bookingList
* bookingInfo - http://localhost:8080/admin/adminBooking/info?id=


*Driver*
* driverSchedule - http://localhost:8080/driver/driverSchedule?driverId=

