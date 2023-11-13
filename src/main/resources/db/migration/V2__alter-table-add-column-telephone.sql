-- Adicione a coluna permitindo valores nulos
ALTER TABLE doctor ADD COLUMN telephone VARCHAR(20);

-- Atualize os registros existentes
UPDATE doctor SET telephone = 'N/A' WHERE telephone IS NULL;

-- Modifique a coluna para NOT NULL
ALTER TABLE doctor ALTER COLUMN telephone SET NOT NULL;
