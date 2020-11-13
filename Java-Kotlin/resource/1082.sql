# pretty much the same using all
select seller_id from Sales group by seller_id having sum(price) >= all(select sum(price) from Sales group by seller_id);

# better
select seller_id from Sales group by seller_id having sum(price) = (select sum(price) from Sales group by seller_id order by sum(price) desc limit 1);