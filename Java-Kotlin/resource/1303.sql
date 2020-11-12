
# 子查询
select a.employee_id, (select count(*) from Employee b where b.team_id = a.team_id) as team_size from Employee a;