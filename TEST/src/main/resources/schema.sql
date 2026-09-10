CREATE TABLE IF NOT EXISTS payment (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    concept VARCHAR(255),
    quantity INTEGER,
    payer VARCHAR(255),
    payee VARCHAR(255),
    amount DECIMAL(10,2),
    status VARCHAR(255)
);
