/*--Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’--*/
select * from student where studentName like 'h%';

/*Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.*/
select * from class where month(startDate) = 12;

/*Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.*/
select * from subject where credit between 3 and 5;
/*Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2*/
select * from student;
update student set classID = 2 where studentName = 'Hung';

/*Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) 
giảm dần. nếu trùng sắp theo tên tăng dần*/

select s.studentName, su.subName, m.mark
from student as s join mark as m on s.studentID = m.studentID join subject as su on m.subID = su.subID 
order by mark desc;