-- Adicione a coluna permitindo valores nulos
ALTER TABLE doctor ADD COLUMN active smallint;

-- Atualize os registros existentes
UPDATE doctor SET active = 1;

-- Modifique a coluna para NOT NULL
ALTER TABLE doctor ALTER COLUMN active SET NOT NULL;
