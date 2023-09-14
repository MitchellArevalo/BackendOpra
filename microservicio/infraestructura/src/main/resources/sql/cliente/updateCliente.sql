update clients
set
client_name = :client_name,
client_email = :client_email,
client_identity = :client_identity,
client_address = :client_address,
client_phone_number = :client_phone_number
where id = :id