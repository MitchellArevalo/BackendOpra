UPDATE employees
SET
employee_avatar = :employee_avatar,
employee_name = :employee_name,
employee_email = :employee_email,
employee_document = :employee_document,
employee_address = :employee_address,
employee_phone_number = :employee_phone_number,
employee_active = :employee_active,
employee_notifications_email = :employee_notifications_email,
rol_id = :rol_id
where id = :id