# Write your MySQL query statement below
select name from SalesPerson
    where sales_id not in (
        select O.sales_id from
        Company C join Orders O
        on C.com_id=O.com_id and C.name="RED"
    )