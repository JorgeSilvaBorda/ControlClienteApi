SELECT
	IDCONVERSOR,
    IPCONVERSOR,
    NUMCONVERSOR,
    NUMREMARCADOR,
    NUMPUERTO,
    TIPOREMARCADOR
FROM
	
(SELECT
	ROW_NUMBER() OVER(PARTITION BY TIPOREMARCADOR) NUM,
	IDCONVERSOR,
    IPCONVERSOR,
    NUMCONVERSOR,
    NUMREMARCADOR,
    NUMPUERTO,
    TIPOREMARCADOR
FROM
	CONVERSOR
ORDER BY IPCONVERSOR ASC) A
ORDER BY NUM ASC,
NUMREMARCADOR ASC