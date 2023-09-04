UPDATE notifications
SET
employee_id = :employee_id,
notification_subject = :notification_subject,
notification_message = :notification_message,
notification_readed = :notification_readed
where id = :id