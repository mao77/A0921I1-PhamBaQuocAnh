use quanlysinhvien;
/*Hiển thị số lượng sinh viên ở từng nơi*/
select s.adress,count(studentID) 'số lượng sinh viên' from student as s group by adress;

/*Tính điểm trung bình các môn học của mỗi học viên*/
select m.studentID, s.studentName , avg(mark) 'điểm trung bình'from mark as m 
join student as s on m.studentID = s.studentID group by studentID;
/*Hiển thị những bạn học viên co điểm trung bình các môn học lớn hơn 15*/
select m.studentID, s.studentName , avg(mark) 'điểm trung bình'from mark as m 
join student as s on m.studentID = s.studentID group by studentID
having 'điểm trung bình';

/*Hiển thị thông tin các học viên có điểm trung bình lớn nhất.*/
SELECT S.StudentId, S.StudentName, AVG(Mark)
FROM Student S join Mark M on S.StudentId = M.StudentId
GROUP BY S.StudentId, S.StudentName
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.StudentId);