-- make division.fk_director_id nullable
ALTER TABLE division ALTER COLUMN fk_director_id DROP NOT NULL;