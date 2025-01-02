-- 데이터베이스에 product 테이블 생성
CREATE TABLE IF NOT EXISTS product (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL
    );

-- 제품에 대한 초기 데이터 삽입 (옵션)
INSERT INTO product (name, price) VALUES ('Product A', 100.0);
INSERT INTO product (name, price) VALUES ('Product B', 200.0);
git