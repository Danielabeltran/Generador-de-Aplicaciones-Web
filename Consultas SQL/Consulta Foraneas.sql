
SELECT CONCAT( table_name, '.', column_name, '->', referenced_table_name, '.', referenced_column_name ) 
AS relation 
FROM INFORMATION_SCHEMA.key_column_usage 

WHERE referenced_table_schema = 'academico'
AND referenced_table_name 
IS NOT NULL

ORDER BY table_name, column_name
