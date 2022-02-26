select * from student;
select * from class;
select * from student where status = true;
select * from `subject` where credit < 10;
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student as S join Class as C on S.ClassId = C.ClassID;
SELECT S.StudentId, S.StudentName, C.ClassName
FROM Student as S join Class as C on S.ClassId = C.ClassID
WHERE C.ClassName = 'A1';
SELECT S.StudentId, S.StudentName, Sub.SubName, M.Mark
FROM Student S join Mark M on S.StudentId = M.StudentId join Subject Sub on M.SubId = Sub.SubId
 WHERE Sub.SubName = 'CF';