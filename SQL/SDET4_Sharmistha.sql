use employees;

create database SDET4_Sharmistha;

use SDET4_Sharmistha;

CREATE TABLE salesman (
    salesman_id int primary key,
    name varchar(32),
    city varchar(32),
    commission int
);

desc salesman;
INSERT INTO salesman VALUES(5001, 'James Hoog', 'New York', 15);

Select * From salesman;

INSERT INTO salesman VALUES
    (5002, 'Nail Knite', 'Paris', 13),
    (5005, 'Pit Alex', 'London', 11), 
    (5006, 'McLyon', 'Paris', 14), 
    (5007, 'Paul Adam', 'Rome', 13),
    (5003, 'Lauson Hen', 'San Jose', 12);
    
Select * From salesman;

SELECT salesman_id, city FROM salesman;

SELECT * FROM salesman WHERE city='Paris';

SELECT salesman_id, commission FROM salesman WHERE name='Paul Adam';

alter table salesman
add grade int;

Update salesman
set grade = 100;

Update salesman
set grade = 200 WHERE city='Rome';
Update salesman
set grade = 300 WHERE name='James Hoog';
Update salesman
set name = 'Pierre' WHERE name='Piere';

Select * From salesman;


create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

insert into orders values
(70001, 150.5, '2012-10-05', 3005, 5002), (70009, 270.65, '2012-09-10', 3001, 5005),
(70002, 65.26, '2012-10-05', 3002, 5001), (70004, 110.5, '2012-08-17', 3009, 5003),
(70007, 948.5, '2012-09-10', 3005, 5002), (70005, 2400.6, '2012-07-27', 3007, 5001),
(70008, 5760, '2012-08-15', 3002, 5001), (70010, 1983.43, '2012-10-10', 3004, 5006),
(70003, 2480.4, '2012-10-10', 3009, 5003), (70012, 250.45, '2012-06-27', 3008, 5002),
(70011, 75.29, '2012-08-17', 3003, 5007), (70013, 3045.6, '2012-04-25', 3002, 5001);

Select distinct salesman_id from orders;
Select order_no, order_date from orders order by order_date;
select order_no, purchase_amount from orders order by purchase_amount DESC;
Select * from orders where purchase_amount<500;
Select * from orders where purchase_amount>=1000 AND purchase_amount<=2000;

Select SUM(purchase_amount) FROM orders;
Select avg(purchase_amount) FROM orders;
Select min(purchase_amount) FROM orders;
Select max(purchase_amount) FROM orders;
Select count(distinct salesman_id) AS "COUNT" FROM orders;

Select customer_id, Max(purchase_amount) AS "Highest Purchase Amt"
FROM orders GROUP BY customer_id;

Select salesman_id, Max(purchase_amount) AS "Highest Purchase Amt"
FROM orders Where order_date='2012-08-17' GROUP BY salesman_id;

SELECT customer_id, order_date, MAX(purchase_amount) AS "Max Amount" FROM orders
GROUP BY customer_id, order_date
HAVING MAX(purchase_amount) IN(2030, 3450, 5760, 6000);
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
insert into customers values 
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001),
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002),
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003),
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005)

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;






