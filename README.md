# Microservices in a box
A presentation and a small codebase to showcase a monolithic application with completely independent business services.
The intention behind the presentation is to make the tradeoff between a Monolithic and a Microservices architecture more visible.
The codebase should show a way to design a monolithic application which is set up to be easily split up at a later point in time (when the usecase for a Microservices application is actually given).
The service split is guaranteed through ArchUnit tests which ensure the code separation between the different business services.
