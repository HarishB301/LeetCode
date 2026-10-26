SELECT 'Low Salary' AS category, 
SUM(case when income<20000 then 1 else 0 end) AS accounts_count
FROM Accounts

UNION ALL 

SELECT 'Average Salary' AS category,
SUM(case when income BETWEEN 20000 AND 50000 then 1 else 0 end) AS accounts_count
FROM Accounts

UNION ALL

SELECT 'High Salary' AS category, 
SUM(case when income > 50000 then 1 else 0 end)AS accounts_count
FROM Accounts
