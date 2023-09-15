SELECT id, employee_id, client_id, sale_amount, sale_profit, sale_margin_profit, sale_type, sale_date, sale_status
FROM opraecommerce.sales
WHERE sale_date >= :sale_date_inicial AND sale_date <= :sale_date_final AND sale_status = 'APROBADA'
