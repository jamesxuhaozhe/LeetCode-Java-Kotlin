
# 子查询
select a.employee_id, (select count(*) from Employee b where b.team_id = a.team_id) as team_size from Employee a;

# 左连接
select e1.employee_id, count(*) team_size from Employee e1 left join Employee e2 on e1.team_id = e2.team_id group by e1.employee_id;