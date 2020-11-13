select C.customer_id, c.`name` from Orders O join Product P using(product_id) join Customers C using(customer_id)
where year(O.order_date) = 2020 and (month(O.order_date) = 6 or month(O.order_date) = 7)
group by O.customer_id
having sum(if(month(O.order_date) = 6, O.quantity * P.price, 0)) >= 100 and sum(if(month(O.order_date) = 7, O.quantity * P.price, 0)) >= 100;