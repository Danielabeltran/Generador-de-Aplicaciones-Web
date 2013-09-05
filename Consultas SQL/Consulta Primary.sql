
SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS 
WHERE table_schema = 'academico' 
AND table_name = 'administrador' 
AND column_key = 'PRI'
AND data_type IS NOT NULL

