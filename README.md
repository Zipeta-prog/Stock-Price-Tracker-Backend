**Project Summary: Stock Price Tracker App**
The Stock Price Tracker App is a Spring Boot application that tracks and displays real-time stock prices for various companies. It is designed to fetch data from financial APIs, 
such as Alpha Vantage, and present it through a simple, user-friendly interface built with Angular. The app includes several key functions and features that enhance its usability, 
performance, and security.

**Key Functions:**
Real-Time Stock Price Tracking: The app fetches and displays real-time stock prices based on user-inputted stock symbols.

RESTful API Endpoints: The app exposes RESTful endpoints through a StockController to allow users to retrieve stock prices via HTTP requests.

Service Layer Integration: The StockService class handles business logic, including making API calls 
                            to fetch stock prices and caching the results for improved performance.

**Key Features:**
Secure API Endpoints with Basic Authentication: The application secures its API endpoints using Spring Security, requiring Basic Authentication for access. 
                                                This ensures that only authenticated users can retrieve stock price information.

Environment Variable Protection for API Keys: API keys used to access financial data are stored securely in environment variables,
                                              preventing exposure in the codebase and enhancing security.

Caching for Improved Performance: The app leverages Spring's caching mechanisms to store and reuse stock price data, 
                                  reducing the number of API calls and improving response times.

User-Friendly UI with Angular: The front-end is built with Angular, providing a responsive and accessible user interface 
                                where users can input stock symbols and view prices.

Error Handling: Proper error handling is implemented to catch exceptions and provide informative error 
                messages to users, ensuring a robust and user-friendly experience.

Accessibility: The UI is designed to be accessible, adhering to best practices to ensure that 
                the app is usable by individuals with disabilities.

Testing: Unit tests are written for the service and controller layers, ensuring the correctness of the application's 
        functionality and facilitating easier maintenance.

**Conclusion:**
The Stock Price Tracker App is a comprehensive solution for tracking stock prices in real-time. It combines secure, efficient backend processing with a modern, 
accessible front-end interface, making it a reliable and user-friendly tool for anyone interested in financial data.
