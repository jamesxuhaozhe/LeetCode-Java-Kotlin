select b.product_name, a.`year`, a.`price` from Sales a join Product b on a.product_id = b.product_id;

select `product_name`, `year`, `price` from `Sales` join `Product` using(`product_id`);