UPDATE products
SET
product_name = :product_name,
product_item_code = :product_item_code,
product_size = :product_size,
product_description = :product_description,
product_image = :product_image,
category_id = :category_id
WHERE id = :id