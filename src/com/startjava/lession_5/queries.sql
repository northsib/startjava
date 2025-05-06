-- ����� ���� �������
SELECT *
  FROM jaegers;
-- ����� ������ �� ������������ �������
SELECT *
  FROM jaegers
 WHERE status NOT IN ('Destroyed');
-- ����� ������� ������ ����� Mark-1 � Mark-4
SELECT *
  FROM jaegers
 WHERE mark IN ('Mark-1', 'Mark-4');
/*
����� ���� �������, ����� Mark-1 � Mark-4, � �����������
������� �� �������� �� ������� mark
*/
SELECT *
  FROM jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
 ORDER BY mark DESC;
-- ����� ���������� � ����� ������ �������
SELECT *
  FROM jaegers
 WHERE launch =
       (SELECT MIN(launch)
          FROM jaegers);
/*
����� ���������� �� ��������: model_name, mark, launch, kaiju_kill,
��� �������, ������� ���������� ������ ���� kaiju
*/
SELECT model_name, mark, launch, kaiju_kill
  FROM jaegers
 WHERE kaiju_kill =
       (SELECT MAX(kaiju_kill)
          FROM jaegers);
/*
����� �������� ���� �������, � ����������� �� 3 ������
� ������������ avg_weight
*/
SELECT ROUND(AVG(weight), 3) AS avg_weight
  FROM jaegers;
-- ���������� �� 1 ���������� ������������ kaiju � ������������� �������
UPDATE jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status NOT IN ('Destroyed');
-- ����������� �������
SELECT *
  FROM jaegers;
-- �������� ������������ �������
DELETE
  FROM jaegers
 WHERE status = 'Destroyed';
-- ����������� �������
SELECT *
  FROM jaegers;
