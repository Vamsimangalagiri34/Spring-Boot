⚙️ Internal Working of DispatcherServlet
Here's a simplified step-by-step flow of how it works internally':

Client Request 🌐
A browser or Postman sends an HTTP request (e.g., GET /employees).

DispatcherServlet 🧭
The request first hits the DispatcherServlet, which acts as the central coordinator.

Handler Mapping 🔗
It consults HandlerMapping to determine which controller method should handle the request.

Controller 🧑‍🏫
The matched controller method is called.

Service Layer (optional) ⚙️
If business logic is involved, the controller calls the service layer.

DAO / Repository Layer 🗄️
To interact with the database, service uses Repository.

Return Response ↩️
Data flows back from Repository → Service → Controller.

View Resolver (for web apps) 🪟
If the response needs a view (like an HTML page), ViewResolver resolves it.

Response to Client 📤
The final data or view is sent back to the client.
