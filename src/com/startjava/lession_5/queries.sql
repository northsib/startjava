-- вывод всей таблицы
SELECT *
  FROM jaegers;
-- вывод только не уничтоженных роботов
SELECT *
  FROM jaegers
 WHERE status NOT IN ('Destroyed');
-- вывод роботов только серии Mark-1 и Mark-4
SELECT *
  FROM jaegers
 WHERE mark IN ('Mark-1', 'Mark-4');
/*
вывод всех роботов, кроме Mark-1 и Mark-4, с сортировкой
таблицы по убыванию по столбцу mark
*/
SELECT *
  FROM jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
 ORDER BY mark DESC;
-- вывод информации о самых старых роботах
SELECT *
  FROM jaegers
 WHERE launch =
       (SELECT MIN(launch)
          FROM jaegers);
/*
вывод информации из столбцов: model_name, mark, launch, kaiju_kill,
тех роботов, которые уничтожили больше всех kaiju
*/
SELECT model_name, mark, launch, kaiju_kill
  FROM jaegers
 WHERE kaiju_kill =
       (SELECT MAX(kaiju_kill)
          FROM jaegers);
/*
вывод среднего веса роботов, с округлением до 3 знаков
с отображением avg_weight
*/
SELECT ROUND(AVG(weight), 3) AS avg_weight
  FROM jaegers;
-- увеличение на 1 количество уничтоженных kaiju у неразрушенных роботов
UPDATE jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status NOT IN ('Destroyed');
-- отображение таблицы
SELECT *
  FROM jaegers;
-- удаление уничтоженных роботов
DELETE
  FROM jaegers
 WHERE status = 'Destroyed';
-- отображение таблицы
SELECT *
  FROM jaegers;
