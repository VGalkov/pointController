# pointController
это просто бессмысленная ковырялка для возни пока ищу работу.

несколько модулей spring с многопоточными действиями с разными контекстами, общаюшиеся друг с другом через один из модулей. 
по идее это пищут из нескольких сервисов, общающихся через кафку. но тут скоя очередь и свои "микросервисы" в одной куче. 
по идеевсё можно разнести на разные aplication, так как реюза между модулями без очереди нет. 


1. исправить дублирование в схеме бинов. 
2. согласовать протокол обмена между очередью и частями.
5. заложить профили движения дронов.
6. запустить алгоритм построеия границ меду группами дрнов.
7. заложить какие-то рамки-условия движений относительно друг друга групп.
   (движение по профилю, но с учётом состояний границы и положений других)
------  
это просто неаккуратная упражнялка головы.
