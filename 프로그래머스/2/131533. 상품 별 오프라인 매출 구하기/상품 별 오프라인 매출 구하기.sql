-- 상품코드 별 매출액 합계

SELECT A.PRODUCT_CODE, SUM(B.SALES_AMOUNT * A.PRICE) AS SALES
FROM PRODUCT A JOIN OFFLINE_SALE B ON A.PRODUCT_ID = B.PRODUCT_ID
GROUP BY A.PRODUCT_CODE
ORDER BY SALES DESC, A.PRODUCT_CODE 