
SELECT 
    YEAR(A.DIFFERENTIATION_DATE) AS YEAR,
    B.MAX_COLONY - A.SIZE_OF_COLONY AS YEAR_DEV,
    A.ID
FROM ECOLI_DATA A
JOIN (
    SELECT 
        YEAR(DIFFERENTIATION_DATE) AS YEAR,
        MAX(SIZE_OF_COLONY) AS MAX_COLONY
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)
) B ON YEAR(A.DIFFERENTIATION_DATE) = B.YEAR
ORDER BY YEAR, YEAR_DEV;

