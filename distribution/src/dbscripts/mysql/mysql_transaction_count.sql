-- Related to the deprecated transaction counter feature
CREATE TABLE IF NOT EXISTS CURRENT_STATS (
  TIME_STAMP DATE NOT NULL,
  NODE_ID VARCHAR(40) NOT NULL,
  TRANSACTION_COUNT INT NOT NULL,
  TRANSACTION_COUNT_ENCRYPTED VARCHAR(400) NOT NULL
) ENGINE INNODB;
