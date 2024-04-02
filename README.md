# AutoQA Store - Example RESTful API Automation Project

This repository contains a sample project for automating API testing using REST Assured. It includes implementations for testing various endpoints of a fictitious online store's API,
covering user management, product catalog, shopping carts, orders, and payments. The project is designed to demonstrate  API automation testing with Java and REST Assured.

## Key Features:
- Automated tests for CRUD operations on users, products, carts, orders, and payments
- Usage of REST Assured for API testing
- Structured project layout and modular design
- Integration with Allure for test reporting and documentation

## Running the Project Locally with JSON Server
To run the AutoQA Store project locally on your machine

1. **Install JSON Server**: 
    ```bash
    npm install -g json-server
    ```

2. **Run JSON Server**: 
    ```bash
    cd <project_folder>
    json-server --watch db.json
    ```

## Endpoints
### User API Client

- **Create User**: `POST /users`
- **Delete User**: `DELETE /users/{id}`
- **Update User**: `PUT /users/{id}`
- **Get All Users**: `GET /users`
- **Get User by ID**: `GET /users/{id}`

### Product API Client

- **Create Product**: `POST /products`
- **Delete Product**: `DELETE /products/{id}`
- **Update Product**: `PUT /products/{id}`
- **Get All Products**: `GET /products`
- **Get Product by ID**: `GET /products/{id}`

### Order API Client

- **Create Order**: `POST /orders`
- **Delete Order**: `DELETE /orders/{id}`
- **Update Order**: `PUT /orders/{id}`
- **Get All Orders**: `GET /orders`
- **Get Order by ID**: `GET /orders/{id}`

### Payment API Client

- **Create Payment**: `POST /payments`
- **Delete Payment**: `DELETE /payments/{id}`
- **Update Payment**: `PUT /payments/{id}`
- **Get All Payments**: `GET /payments`
- **Get Payment by ID**: `GET /payments/{id}`
