INSERT INTO BOOK(TYPE, ID, CREATED_BY, CREATED_TIME, MODIFIED_BY, MODIFIED_TIME, VERSION, BOOK_DESC, BOOK_FAVORITE, BOOK_FOLDER_ID, BOOK_NAME, BOOK_TAG, WS_ID) VALUES
('report', 'report-001', 'admin', now(), 'admin', now(), 0, NULL, FALSE, 'ROOT', 'testworkbook', '', 'ws-02');
INSERT INTO BOOK_REPORT(REPORT_CONF, ID) VALUES('', 'report-001');



