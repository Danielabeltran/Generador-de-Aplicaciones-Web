SELECT data_type FROM INFORMATION_SCHEMA.COLUMNS 
WHERE table_schema = 'academico'
AND table_name = 'administrador' 
AND column_name = 'id' 
AND data_type 
IS NOT NULL



