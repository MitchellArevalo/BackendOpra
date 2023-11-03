SELECT products.id, products.product_name, products.product_item_code, products.product_size, products.product_sales_price, products.product_cost_price, products.product_description, products.product_image, products.product_stock, products.category_id,
SUM(saleproducts.saleproduct_quantity) as cantidad_producto_vendidos
from opraecommerce.products
JOIN opraecommerce.saleproducts ON products.id = saleproducts.product_id
JOIN opraecommerce.sales ON saleproducts.sale_id = sales.id
WHERE sales.sale_status = 'APROBADA'
GROUP BY products.id, saleproducts.saleproduct_quantity
ORDER BY saleproducts.saleproduct_quantity ASC
