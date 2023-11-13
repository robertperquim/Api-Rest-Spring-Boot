-- Adiciona uma nova coluna booleana
ALTER TABLE doctor
ADD COLUMN active_boolean boolean;

-- Atualiza a nova coluna com os valores da coluna original
UPDATE doctor
SET active_boolean = (active = 1);

-- Remove a coluna original
ALTER TABLE doctor
DROP COLUMN active;

-- Renomeia a nova coluna para o nome original
ALTER TABLE doctor
RENAME COLUMN active_boolean TO active;
