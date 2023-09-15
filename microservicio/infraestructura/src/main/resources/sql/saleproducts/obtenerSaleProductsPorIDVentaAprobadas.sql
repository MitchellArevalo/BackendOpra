SELECT saleproducts.id, sale_id, product_id, saleproduct_quantity, saleproduct_sale_price, saleproduct_profit, saleproduct_margin_profit, saleproduct_total, saleproduct_date
FROM opraecommerce.saleproducts
INNER JOIN opraecommerce.sales ON saleproducts.sale_id = opraecommerce.sales.id
WHERE sales.sale_status = 'APROBADA' AND saleproducts.sale_id = :sale_id