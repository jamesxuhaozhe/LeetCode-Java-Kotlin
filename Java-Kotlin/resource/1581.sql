// 用子查询
select customer_id, count(*) as count_no_trans from Visits where visit_id not in (select visit_id from Transactions) group by customer_id order by count_no_trans desc;

// 用左连接
select v.customer_id, count(*) as count_no_trans from Visits v left join Transactions t on v.visit_id = t.visit_id where t.transaction_id is NULL group by v.customer_id order by count_no_trans desc;