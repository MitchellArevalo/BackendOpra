select
modules.id,
modules.module_name,
modules.module_edit,
modules.module_create,
modules.module_delete,
modules.module_view
from modulerol INNER JOIN modules ON modulerol.module_id = modules.id
where modulerol.rol_id = :rol_id