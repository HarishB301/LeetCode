# Write your MySQL query statement below
select D.name as Department,
       E.name as Employee, 
       E.salary as salary
from Employee E 
join Department D on E.departmentId=D.id
where E.salary in (
    select max(salary) 
    from Employee 
    where departmentId=E.departmentId
)