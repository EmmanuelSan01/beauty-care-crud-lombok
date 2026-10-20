-- Tabla de productos. IF NOT EXISTS la hace segura de ejecutar en cada arranque.
CREATE TABLE IF NOT EXISTS producto (
    id      INTEGER PRIMARY KEY AUTOINCREMENT,
    usuario TEXT NOT NULL,
    sala    TEXT NOT NULL,
    horas   INTEGER NOT NULL CHECK (horas >= 0),
    equipo  INTEGER NOT NULL DEFAULT 0 CHECK (equipo >= 0),
    motivo  TEXT
);