# Write your MySQL query statement below
select name from Customer
where referee_id is null
union all
select name from Customer
where 
referee_id<>2;