# Quarkus-Kafka project: Massive Throughput Calculator

For now this is just the foundation for implementing a project that uses Quarkus to implement
a web app calculator that can handle massive amounts of requested operations using Kafka to make
two different applications communicate:

-  A `Client` that receives the requests, format them and sends them via Kafka to the calculator layer;
-  A `Calculator` that receives the operations from the client, computes the result and then sends them via Kafka back to the client;

Such application usually does not need to use Kafka, since it's a tool suitable for Cloud Computing in scenarios where
high throughput of data and event based systems are required.

This project helps us to understand better how Quarkus uses Kafka in a practical way and how high levels of data throughput
can be managed by an application hosted in Cloud. If we imagine the millions of users are using this calculator service at the
same time and millions of requests/operations need to be processed, then such architecture can be used to solve possible
overloading issues.

Again, this obviously is overkill and a simple calculator is not a service that should be using Cloud Computing to be
deployed anyway. Since we don't really need a database for this projetct, such web app could be fully implemented as a Front End
application.
