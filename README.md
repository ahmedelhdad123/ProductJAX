# Product Management Application

This project implements a Java-based RESTful API for managing products, featuring entity modeling, repository management, service layer operations, REST endpoints, and exception handling.

## Table of Contents

- [Project Structure](#project-structure)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Error Handling](#error-handling)
- [Contributing](#contributing)
- [License](#license)

## Project Structure

### 1. Entity Class (`Product.java`)

Represents a product entity with attributes:
- `id`: Unique identifier.
- `productName`: Name of the product.
- `price`: Price of the product.
- `description`: Description of the product.
- `quantity`: Available quantity of the product.

### 2. Repository Interface (`ProductRepo.java`)

Defines CRUD operations for products:
- `findAll()`: Retrieves all products.
- `findById(int id)`: Finds a product by ID.
- `add(Product product)`: Adds a new product.
- `update(int id, Product product)`: Updates an existing product.
- `delete(int id)`: Deletes a product by ID.
- `findByName(String name)`: Finds a product by name.

### 3. Repository Implementation (`ProductRepoImpl.java`)

Implements `ProductRepo` using an in-memory list:
- Stores `Product` objects.
- Provides methods for CRUD operations with error handling for update, delete, and find operations.

### 4. Service Interface (`ProductService.java`)

Defines service operations for managing products:
- Mirrors methods in `ProductRepo` for CRUD operations.

### 5. Service Implementation (`ProductServiceImpl.java`)

Implements `ProductService`:
- Injects `ProductRepo` using Jakarta EE `@Inject`.
- Implements service methods by delegating calls to `ProductRepo`.
- Handles errors for operations that may fail (e.g., product not found).

### 6. RESTful Web Service (`ProductRest.java`)

Exposes RESTful endpoints for product management:
- Annotations (`@Path`, `@Produces`, `@Consumes`) define path and media types.
- HTTP methods (`@GET`, `@POST`, `@PUT`, `@DELETE`) mapped to CRUD operations.
- Methods handle HTTP requests and delegate operations to `ProductService`.

### 7. Exception Handling (`ApiException.java`, `GlobalException.java`, `ProductException.java`)

- **`ApiException.java`:** Represents API error responses with status code and message.
- **`GlobalException.java`:** Implements `ExceptionMapper<Throwable>` to handle uncaught exceptions and convert them to standardized API error responses.
- **`ProductException.java`:** Custom exception extending `RuntimeException`, used for specific product-related errors (e.g., product not found).
