-- Customer Table
CREATE TABLE Customer (
    customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(10),
    shipping_address VARCHAR(255)
);

-- Product Table
CREATE TABLE Product (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    brand VARCHAR(50),
    category VARCHAR(50),
    price DECIMAL(10,2) NOT NULL,
    quantity_in_stock INT NOT NULL
);

-- Order Table
CREATE TABLE `Order` (
    order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT,
    order_date DATETIME NOT NULL,
    order_status VARCHAR(50),
    total_amount DECIMAL(10,2),

    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);

-- OrderItem Table (M-M relationship bridge between Order and Product)
CREATE TABLE Order_Product (
    order_product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price_at_purchase DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (order_id) REFERENCES `Order`(order_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);