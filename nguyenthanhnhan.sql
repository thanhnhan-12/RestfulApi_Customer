Create database NguyenThanhNhanCustomer;

Use NguyenThanhNhanCustomer;

Create table customer
(
	customer_id int auto_increment primary key,
    name varchar(45),
    age int,
    money float,
    phone int,
    address varchar(45)
)