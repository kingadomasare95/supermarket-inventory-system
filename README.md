# Supermarket Inventory Management System

## Description

This is a JavaFX desktop application developed using Java and Object-Oriented Programming (OOP) principles.

The **Supermarket Inventory Management System** allows supermarket administrators to efficiently manage product records through a graphical user interface.

The system provides an easy-to-use dashboard for performing inventory operations and managing supermarket stock information.

It supports full CRUD operations:

- **Create** (Add Product)
- **Read** (View Products)
- **Update** (Edit Product)
- **Delete** (Remove Product)
- **Search Product**

The application was developed as part of the **INF811D: Object Oriented Programming** course at the University of Cape Coast.

---

# Features

The system provides the following features:

- Add new product records
- View all products in a table format
- Search products using product ID
- Update existing product information
- Delete products from inventory
- Dashboard-based navigation
- Product information management
- Input validation and error handling
- Clean and user-friendly JavaFX interface

---

# 🛠️ Technologies Used

The project was developed using the following technologies:

| Technology | Purpose |
|------------|---------|
| Java | Core programming language |
| JavaFX | Graphical User Interface development |
| Maven | Project build and dependency management |
| IntelliJ IDEA | Integrated Development Environment |
| Object-Oriented Programming | Software design approach |
| ArrayList | Temporary in-memory data storage |

---

# System Architecture

The system follows a simple layered architecture:

```
Supermarket Inventory Management System

        +----------------------+
        |     JavaFX UI        |
        |  Dashboard / Forms   |
        +----------+-----------+
                   |
                   |
        +----------+-----------+
        |   Logic Layer        |
        |     Inventory       |
        +----------+-----------+
                   |
                   |
        +----------+-----------+
        |    Model Layer       |
        |      Product         |
        +----------------------+
```

---

# Project Structure

```
com.supermarket

│
├── Main.java
├── Dashboard.java
│
└── model
    │
    ├── Product.java
    ├── Inventory.java
    ├── AddProductForm.java
    ├── ViewProducts.java
    ├── SearchProductForm.java
    ├── DeleteProductForm.java
    └── UpdateProductForm.java
```

---

# Class Description

## Product Class

The `Product` class represents a supermarket product.

### Product Attributes:

- Product ID
- Product Name
- Category
- Price
- Quantity
- Supplier

### Responsibilities:

- Store product information
- Provide access to product attributes
- Calculate product total value

---

## Inventory Class

The `Inventory` class manages product records and performs inventory operations.

### Main Methods:

```java
addProduct()
getAllProducts()
searchProduct()
deleteProduct()
updateProduct()
```

### Responsibilities:

- Store products using ArrayList
- Manage product records
- Perform CRUD operations

---

## Dashboard Class

The `Dashboard` class serves as the main navigation center of the application.

It provides access to:

- Add Product
- View Products
- Search Product
- Update Product
- Delete Product

---

## AddProductForm

Provides a JavaFX form that allows users to enter and save new product information.

---

## ViewProducts

Displays all available products using JavaFX `TableView`.

---

## SearchProductForm

Allows users to search for products using the product ID.

---

## DeleteProductForm

Allows users to remove products from the inventory.

---

## UpdateProductForm

Allows users to modify existing product details.

---

# Object-Oriented Programming Concepts Applied

## Encapsulation

Product attributes are kept private and accessed using getter methods.

Example:

```java
private String productName;
```

---

## Abstraction

The `Inventory` class hides the internal storage implementation and provides simple methods for managing products.

---

## Inheritance

The main JavaFX application uses inheritance from JavaFX application classes.

---

## Polymorphism

Different objects and methods are handled through Java's polymorphism features.

---

# GUI Design

The application interface was developed using JavaFX components.

The following components were used:

- **VBox** - Organizes interface layouts
- **BorderPane** - Provides dashboard structure
- **Buttons** - Performs user actions
- **TextFields** - Accepts user input
- **TableView** - Displays product records
- **Labels** - Displays information and messages

The interface was designed to be:

- Simple
- Clean
- Easy to navigate
- User-friendly

---

# Screenshots

## Dashboard Interface
<img width="1092" height="970" alt="Screenshot 2026-07-06 201827" src="https://github.com/user-attachments/assets/7fc9a485-5d5f-4e5a-8847-1fd2e97a8e67" />



---

## Add Product Form

<img width="620" height="598" alt="Screenshot 2026-07-06 204752" src="https://github.com/user-attachments/assets/9269a6e5-9836-482f-a667-b063e1ff613e" />


---

## Product Table

<img width="713" height="573" alt="Screenshot 2026-07-06 203551" src="https://github.com/user-attachments/assets/d84d9c28-b43e-4b70-bade-58a15bd42e0d" />


---

# How to Run the Project

## Requirements

Before running the project, ensure you have:

- Java Development Kit (JDK 17 or later)
- JavaFX SDK
- Maven
- IntelliJ IDEA

---

## Steps

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/supermarket-inventory-system.git
```

### 2. Open Project

Open the project folder using IntelliJ IDEA.

### 3. Configure Dependencies

Ensure Maven dependencies are downloaded successfully.

### 4. Run Application

Run:

```bash
Main.java
```

or execute:

```bash
mvn javafx:run
```

---

# Challenges Faced

During the development of this project, several challenges were encountered:

- JavaFX configuration issues in IntelliJ IDEA
- Managing multiple JavaFX windows
- Handling scene transitions
- Connecting UI components with backend logic
- Maintaining data sharing between different forms
- Resolving package structure problems

These challenges were solved by:

- Proper Maven configuration
- Correct JavaFX dependency setup
- Applying proper Object-Oriented design principles
- Organizing project classes into appropriate packages

---

# Future Improvements

The following improvements can be implemented in future versions:

- Database integration using MySQL or SQLite
- User authentication and role management
- Barcode scanning functionality
- Sales management module
- Stock notification system
- Cloud-based inventory storage
- Report generation

---
#Author
**Adom Peter-King Asare**
- **MSc Information Technology
- **Institution:** University of Cape Coast, Ghana


